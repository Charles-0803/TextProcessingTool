package com.project.textprocessingtool;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.project.textprocessingtool.RegexProcessor;

public class MainUIController {
    @FXML
    private TextField inputField;
    @FXML
    private TextField patternField;
    @FXML
    private TextField replaceField;
    @FXML
    private TextArea resultArea;

    private final RegexProcessor regexProcessor = new RegexProcessor();

    @FXML
    public void handleMatch() {
        String text = inputField.getText();
        String pattern = patternField.getText();

        String result = RegexProcessor.findMatches(text, pattern);
        resultArea.setText(result);
    }

    @FXML
    public void handleReplace() {
        String text = inputField.getText();
        String pattern = patternField.getText();
        String replacement = replaceField.getText();

        String result = RegexProcessor.replaceText(text, pattern, replacement);
        resultArea.setText(result);
    }
}
