package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOut {

    private WebDriver driver;
    private final int CLICKABLE_TIME = 15;
    private final int VISIBLE_TIME = 15;

    public TimeOut(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilClickable(WebElement webElement) {
        return new WebDriverWait(driver, CLICKABLE_TIME)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitUntilVisible(WebElement webElement) {
        return new WebDriverWait(driver, VISIBLE_TIME)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitUntilVisible(WebElement webElement, int timeOut) {
        return new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitUntilClickable(WebElement webElement, int timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
