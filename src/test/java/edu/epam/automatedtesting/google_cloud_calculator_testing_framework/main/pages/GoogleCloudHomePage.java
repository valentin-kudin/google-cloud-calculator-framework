package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudHomePage extends Page {

    @FindBy(name = "q")
    private WebElement searchButton;

    @FindBy(xpath = "(//a/b[text()='Google Cloud Platform Pricing Calculator'])[1]")
    private WebElement pricingCalculatorLink;

    public GoogleCloudHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudHomePage loadMainPage(String mainPageURL) {
        loadPageInNewBrowser(mainPageURL);
        return this;
    }

    public GoogleCloudHomePage enterSearchQuery(String query) {
        getTimeOut().waitUntilClickable(searchButton).click();
        logger.info("Click on search button");
        searchButton.sendKeys(query);
        searchButton.submit();
        logger.info("Enter the query");
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickOnPricingCalculatorLink() {
        getTimeOut().waitUntilClickable(pricingCalculatorLink).click();
        logger.info("Click on Google Cloud Platform Pricing Calculator link");
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
