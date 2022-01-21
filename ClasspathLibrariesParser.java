package com.mycompany.exampleproject.parsers;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClasspathLibrariesParser {
    private static final List<String> ALLOWED_KINDS = Arrays.asList("lib", "con");
    private static final SAXParserFactory PARSER_FACTORY = ClasspathLibrariesParser.createParserFactory();

    private static SAXParserFactory createParserFactory() {
        final SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        return parserFactory;
    }

    public Set<String> parseClasspathFile() {
        final File file = new File("./.classpath");
        final Set<String> paths = this.parseClasspathFile(file);
        return paths;
    }

    public Set<String> parseClasspathFile(final File file) {
        try {
            final Set<String> paths = new TreeSet<>();
            final XMLReader parser = this.createClasspathFileParser(paths);
            parser.parse(file.toURI().toURL().toString());
            return paths;
        } catch (Exception e) {
            log.error("An error happened while parsing the classpath file \"{}\". Exception: {}", file, e.getMessage());
            return null;
        }
    }

    private XMLReader createClasspathFileParser(final Set<String> paths)
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
                    paths.add(path);
                }
            }
        });

        return parser;
    }
}
