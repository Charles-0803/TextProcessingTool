package com.project.textprocessingtool;

public class TextProcessor {
    public static String processText(String text, String pattern, String replacement) {
        String matches = RegexProcessor.findMatches(text, pattern);
        String replaced = RegexProcessor.replaceText(text, pattern, replacement);
        return "Matches:\n" + matches + "\nReplaced Text:\n" + replaced;
    }
}
