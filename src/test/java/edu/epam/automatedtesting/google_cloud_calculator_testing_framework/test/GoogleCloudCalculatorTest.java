package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.test;

import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.model.CloudServer;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.GoogleCloudHomePage;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.service.CloudServerCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudCalculatorTest extends BaseTest {

    private final String MAIN_PAGE_URL = "https://cloud.google.com";
    private final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";
    private final String EMAIL_GENERATOR_URL = "https://10minutemail.com";
    private final CloudServer CLOUD_SERVER = CloudServerCreator.getCloudServer();

    @Test
    public void testIsCostFromPageEqualToCostFromMessage() {
        googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage.loadMainPage(MAIN_PAGE_URL)
                .enterSearchQuery(SEARCH_QUERY);
        calculatorPage = googleCloudHomePage.clickOnPricingCalculatorLink();
        calculatorPage.clickComputeEngineTab()
                .chooseCloudServerConfiguration(CLOUD_SERVER)
                .addToEstimate();
        double totalCostOnPage = calculatorPage.getTotalEstimatedCostOnPage();
        calculatorPage.openEmailEstimateWindow();
        tenMinuteMailPage = calculatorPage.openEmailGeneratorPageInNewTab(EMAIL_GENERATOR_URL);
        tenMinuteMailPage.copyEmailAddress()
                .goOneTabBackward();
        calculatorPage.pasteEmailToEmailField()
                .sendEmail()
                .goOneTabForward();
        tenMinuteMailPage.openTopMessage();
        double totalCostInMessage = tenMinuteMailPage.getTotalEstimatedCostFromMessage();
        Assert.assertEquals(totalCostOnPage, totalCostInMessage);
    }
}
