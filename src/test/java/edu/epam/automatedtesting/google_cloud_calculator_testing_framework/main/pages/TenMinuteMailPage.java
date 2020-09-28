package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenMinuteMailPage extends Page {

    @FindBy(xpath = "//span[@class='copy_icon']")
    private WebElement copyIcon;

    @FindBy(xpath = "//div[@id='counter_sec_two']//child::span[text()='6' or text()='5' or text()='4' or text()='3']")
    private WebElement counterSeconds;

    @FindBy(xpath = "//span[@id='inbox_count_number' and text()='1'];")
    private WebElement inboxNumberCounter;

    @FindBy(className = "message_top")
    private WebElement topMessage;

    @FindBy(xpath = "//table[@class='quote']//child::h3[contains(text(),'USD')]")
    private WebElement totalCostInMessage;

    public TenMinuteMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public TenMinuteMailPage copyEmailAddress() {
        getTimeOut().waitUntilVisible(counterSeconds, 25);
        copyIcon.click();
        logger.info("Copy email address");
        return this;
    }

    public TenMinuteMailPage openTopMessage() {
        getTimeOut().waitUntilClickable(topMessage, 50).click();
        logger.info("Open top message");
        return this;
    }

    public double getTotalEstimatedCostFromMessage() {
        String totalCost = getTimeOut().waitUntilVisible(totalCostInMessage).getText();
        logger.info("Total cost in message: " + totalCost);
        return getStringOperations().getTotalCostNumber(totalCost);
    }
}
