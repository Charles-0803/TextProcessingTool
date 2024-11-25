package com.project.textprocessingtool;

import com.project.textprocessingtool.RegexProcessor;

public class RegexController {
    public String findMatches(String text, String pattern) {
        return RegexProcessor.findMatches(text, pattern);
    }

    public String replaceText(String text, String pattern, String replacement) {
        return RegexProcessor.replaceText(text, pattern, replacement);
    }
}
