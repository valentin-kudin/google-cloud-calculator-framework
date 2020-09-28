package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutor {

    private JavascriptExecutor javascriptExecutor;

    public JSExecutor(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void scrollIntoView(WebElement webElement) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({\n" +
                "            behavior: 'auto',\n" +
                "            block: 'center',\n" +
                "            inline: 'center'\n" +
                "        });", webElement);
    }

    public void scrollPage(int x, int y) {
        javascriptExecutor.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void openNewTab() {
        javascriptExecutor.executeScript("window.open()");
    }
}
