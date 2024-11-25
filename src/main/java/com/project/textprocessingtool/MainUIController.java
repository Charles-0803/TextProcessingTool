package com.project.textprocessingtool;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.project.textprocessingtool.CustomData;

    public class MainUIController {
        @FXML
        private TextField inputField, patternField, replaceField, dataNameField, dataIdField;
        @FXML
        private TextArea resultArea, dataArea;

        private final RegexController regexController = new RegexController();


        @FXML
        private ListView<CustomData> dataListView;

        private final ObservableList<CustomData> dataList = FXCollections.observableArrayList();

        @FXML
        public void initialize() {
            // Initialize the ListView with the ObservableList
            dataListView.setItems(dataList);

            // Set listener for selection changes
            dataListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    dataNameField.setText(newValue.getName());
                    dataIdField.setText(String.valueOf(newValue.getId()));
                }
            });
        }


        @FXML
        public void handleMatch() {
            String text = inputField.getText();
            String pattern = patternField.getText();
            String result = regexController.findMatches(text, pattern);
            resultArea.setText(result);
        }

        @FXML
        public void handleReplace() {
            String text = inputField.getText();
            String pattern = patternField.getText();
            String replacement = replaceField.getText();
            String result = regexController.replaceText(text, pattern, replacement);
            resultArea.setText(result);
        }
        @FXML
        public void handleSearchIndex() {
            String text = inputField.getText();
            String pattern = patternField.getText();
            int index = text.indexOf(pattern);

            if (index != -1) {
                resultArea.setText("Pattern found at index: " + index);
            } else {
                resultArea.setText("Pattern not found in the input text.");
            }
        }

        @FXML
        public void handleClearAll() {
            inputField.clear();
            patternField.clear();
            replaceField.clear();
            resultArea.clear();

        }


        @FXML
        public void handleAddData() {
            String name = dataNameField.getText();
            int id;

            try {
                id = Integer.parseInt(dataIdField.getText());
            } catch (NumberFormatException e) {
                dataNameField.setText("Invalid ID");
                return;
            }

            CustomData newData = new CustomData(name, id);
            if (!dataList.contains(newData)) {
                dataList.add(newData);
                clearDataFields();
            } else {
                dataNameField.setText("Duplicate entry");
            }
        }

        @FXML
        public void handleUpdateData() {
            CustomData selectedData = dataListView.getSelectionModel().getSelectedItem();
            if (selectedData != null) {
                String name = dataNameField.getText();
                int id;

                try {
                    id = Integer.parseInt(dataIdField.getText());
                } catch (NumberFormatException e) {
                    dataNameField.setText("Invalid ID");
                    return;
                }

                int selectedIndex = dataList.indexOf(selectedData);
                dataList.set(selectedIndex, new CustomData(name, id));
                clearDataFields();
            } else {
                dataNameField.setText("No item selected");
            }
        }

        @FXML
        public void handleDeleteData() {
            CustomData selectedData = dataListView.getSelectionModel().getSelectedItem();
            if (selectedData != null) {
                dataList.remove(selectedData);
                clearDataFields();
            } else {
                dataNameField.setText("No item selected");
            }
        }

        private void clearDataFields() {
            dataNameField.clear();
            dataIdField.clear();
        }
    }

