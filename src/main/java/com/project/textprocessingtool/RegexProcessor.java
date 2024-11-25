package com.project.textprocessingtool;

import java.util.regex.*;

public class RegexProcessor {
    public static String findMatches(String text, String pattern) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        StringBuilder matches = new StringBuilder();

        while (matcher.find()) {
            matches.append("Found: ").append(matcher.group())
                    .append("\n");
        }

        return matches.length() > 0 ? matches.toString() : "No matches found.";
    }

    public static String replaceText(String text, String pattern, String replacement) {
        return text.replaceAll(pattern, replacement);
    }
}
