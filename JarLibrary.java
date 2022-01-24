package com.mycompany.exampleproject.parsers.output;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Getter
@ToString
@EqualsAndHashCode
public final class JarLibrary implements Serializable, Comparable<JarLibrary> {
    private static final long serialVersionUID = -4901659255567773566L;

    @NonNull
    private final String fileName;

    @NonNull
    private final String name;

    private final String version;

    @NonNull
    private final String filePath;

    @Override
    public int compareTo(final JarLibrary other) {
        if (other == null) {
            return 1;
        }

        return this.fileName.compareTo(other.fileName);
    }
}
