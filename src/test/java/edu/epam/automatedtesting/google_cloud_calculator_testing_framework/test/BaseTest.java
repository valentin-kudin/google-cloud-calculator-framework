package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.test;

import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.util.TestListener;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.webdrivermanager.WebDriverSingleton;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.GoogleCloudHomePage;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.GoogleCloudPricingCalculatorPage;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.TenMinuteMailPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public abstract class BaseTest {

    GoogleCloudHomePage googleCloudHomePage;
    GoogleCloudPricingCalculatorPage calculatorPage;
    TenMinuteMailPage tenMinuteMailPage;

    WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = WebDriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void killDriver() {
        WebDriverSingleton.killDriver();
    }
}
