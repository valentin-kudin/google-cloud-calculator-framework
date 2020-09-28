package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.util;

import java.util.Arrays;
import java.util.List;

public class StringOperations {

    public String[] getTotalEstimatedCost(String string) {
        List<String> stringList = Arrays.asList(string.split(" "));
        String[] finalArray = new String[2];
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).equals("USD")) {
                for (int j = 0; j < finalArray.length; j++) {
                    finalArray[j] = stringList.get(i);
                    i++;
                }
                break;
            }
        }
        return finalArray;
    }

    public double getTotalCostNumber(String string) {
        return Double.parseDouble(getTotalEstimatedCost(string)[1].replace(",", ""));
    }

    public String getTotalCostCurrency(String string) {
        return getTotalEstimatedCost(string)[0];
    }
}
