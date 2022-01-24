package com.mycompany.exampleproject.parsers;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.mycompany.exampleproject.parsers.output.JarLibrary;
import com.mycompany.exampleproject.utils.PatternUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClasspathLibrariesParser {
    private static final List<String> ALLOWED_KINDS = Arrays.asList("lib", "con");
    private static final SAXParserFactory PARSER_FACTORY = ClasspathLibrariesParser.createParserFactory();
    private static final String JAR_EXTENSION = ".jar";
    private static final int JAR_EXTENSION_LENGTH = JAR_EXTENSION.length();
    private static final Pattern VERSION_BEGINNING_PATTERN = Pattern.compile("-[0-9]");

    private static SAXParserFactory createParserFactory() {
        final SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        return parserFactory;
    }

    public Set<JarLibrary> parseClasspathFile() {
        final File file = new File("./.classpath");
        final Set<JarLibrary> paths = this.parseClasspathFile(file);
        return paths;
    }

    public Set<JarLibrary> parseClasspathFile(final File file) {
        try {
            final Set<JarLibrary> jarLibraries = new TreeSet<>();
            final XMLReader parser = this.createClasspathFileParser(jarLibraries);
            parser.parse(file.toURI().toURL().toString());
            if (jarLibraries != null) {
                for (JarLibrary jarLibrary : jarLibraries) {
                    log.debug("Classpath file path found: {}", jarLibrary);
                }
            }
            return jarLibraries;
        } catch (Exception e) {
            log.error("An error happened while parsing the classpath file \"{}\". Exception: {}", file, e.getMessage());
            return null;
        }
    }

    private XMLReader createClasspathFileParser(final Set<JarLibrary> jarLibraries)
            throws SAXException, ParserConfigurationException {
        final XMLReader parser = PARSER_FACTORY.newSAXParser().getXMLReader();
        parser.setContentHandler(new DefaultHandler() {
            @Override
            public void startElement(final String uri, final String localName, final String qname,
                    final Attributes atts) {
                if (!"classpathentry".equals(localName)) {
                    return;
                }

                for (int i = 0; i < atts.getLength(); i++) {
                    log.debug("read classpathentry attributes [{}] {} -> {}", i, atts.getLocalName(i), atts.getValue(i));
                }

                final String kind = atts.getValue("kind");
                if (kind != null && ALLOWED_KINDS.contains(kind)) {
                    final String path = atts.getValue("path");
                    final JarLibrary jarLibrary = this.getJarLibraryFromPath(path);
                    if (jarLibrary != null) {
                        jarLibraries.add(jarLibrary);
                    }
                }
            }

            private JarLibrary getJarLibraryFromPath(final String path) {
                final JarLibrary jarLibrary;
                if (path != null) {
                    final File file = new File(path);
                    final String fileName = file.getName();
                    final String filePath = file.getPath();
                    jarLibrary = this.getJarLibraryFromFileData(fileName, filePath);
                } else {
                    jarLibrary = null;
                }

                return jarLibrary;
            }

            private JarLibrary getJarLibraryFromFileData(final String fileName, final String filePath) {
                final JarLibrary jarLibrary;
                if (fileName != null && filePath != null) {
                    final String fileNameWithoutExtension;
                    if (fileName.toLowerCase().endsWith(JAR_EXTENSION)) {
                        fileNameWithoutExtension = fileName.substring(0, fileName.length() - JAR_EXTENSION_LENGTH);
                    } else {
                        fileNameWithoutExtension = fileName;
                    }

                    final int versionSeparatorPosition = PatternUtils.getFirstMatchingPosition(
                            fileNameWithoutExtension, VERSION_BEGINNING_PATTERN);

                    final String name;
                    final String version;
                    if (versionSeparatorPosition >= 0) {
                        name = fileNameWithoutExtension.substring(0, versionSeparatorPosition);
                        version = fileNameWithoutExtension.substring(versionSeparatorPosition + 1);
                    } else {
                        name = fileNameWithoutExtension;
                        version = null;
                    }

                    jarLibrary = new JarLibrary(fileName, name, version, filePath);
                } else {
                    jarLibrary = null;
                }

                return jarLibrary;
            }
        });

        return parser;
    }
}
