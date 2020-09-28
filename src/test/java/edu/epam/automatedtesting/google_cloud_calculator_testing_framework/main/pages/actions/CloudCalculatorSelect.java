package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloudCalculatorSelect {

    private WebElement webElement;
    private WebElement label;
    private String selectFieldName;
    private WebDriver driver;
    private TimeOut timeOut;

    public CloudCalculatorSelect(String selectFieldName, WebDriver driver) {
        this.driver = driver;
        timeOut = new TimeOut(this.driver);
        this.selectFieldName = selectFieldName;
        label = this.driver.findElement(By.xpath("//label[contains(text(),'" + this.selectFieldName + "')]"));
        webElement = this.driver.findElement(By.id(label.getAttribute("for")));
    }

    public CloudCalculatorSelect(String selectFieldName, int whichOne, WebDriver driver) {
        this.driver = driver;
        timeOut = new TimeOut(this.driver);
        this.selectFieldName = selectFieldName;
        label = this.driver.findElements(By.xpath("//label[contains(text(),'" + this.selectFieldName + "')]"))
                .get(whichOne - 1);
        webElement = this.driver.findElement(By.id(label.getAttribute("for")));
    }

    public String getSelectFieldName() {
        return label.getText();
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void selectOption(String option) {
        webElement.click();
        String mdSelectContainerId = webElement.getAttribute("aria-owns");
        timeOut.waitUntilClickable(driver.findElement(By.xpath("//div[@id='" +
                mdSelectContainerId + "']//child::div[contains(text(),'" + option + "')]"))).click();
    }
}
