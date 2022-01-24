package com.mycompany.exampleproject.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PatternUtils {
    public static int getFirstMatchingPosition(final String str, final Pattern pattern) {
        if (StringUtils.isBlank(str) || pattern == null) {
            return -1;
        }

        final Matcher matcher = pattern.matcher(str);
        final boolean found = matcher.find();

        final int start;
        if (found) {
            start = matcher.start();
        } else {
            start = -1;
        }

        return start;
    }

    public static int getLastMatchingPosition(final String str, final Pattern pattern) {
        if (StringUtils.isBlank(str) || pattern == null) {
            return -1;
        }

        final Matcher matcher = pattern.matcher(str);

        int start = -1;
        while (matcher.find()) {
            start = matcher.start();
        }

        return start;
    }
}
