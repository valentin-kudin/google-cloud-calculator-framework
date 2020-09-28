package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.service;

import java.util.ResourceBundle;

public class TestDataReader {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("properties.testdata." +
            System.getProperty("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
