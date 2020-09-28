package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages;

import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.actions.CloudCalculatorSelect;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.model.CloudServer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPricingCalculatorPage extends Page {

    private CloudCalculatorSelect calculatorSelect;

    @FindBy(xpath = "//md-tab-item//div[text()='Compute Engine']")
    private WebElement computeEngineTab;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement inputFieldNumberOfInstances;

    @FindBy(xpath = "//iframe[contains(@name,'goog_')]")
    private WebElement firstIframe;

    @FindBy(id = "myFrame")
    private WebElement myFrame;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement checkboxAddGPU;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate' and contains(@ng-disabled,'ComputeEngineForm.$invalid')]")
    private WebElement buttonAddToEstimate;

    @FindBy(xpath = "//h2[@class='md-title']//child::b[contains(text(),'Total Estimated')]")
    private WebElement totalEstimated;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        switchToMyFrame();
    }

    public GoogleCloudPricingCalculatorPage chooseFromSelects(String selectFieldName, int whichOne, String option) {
        calculatorSelect = new CloudCalculatorSelect(selectFieldName, whichOne, driver);
        calculatorSelect.selectOption(option);
        logger.info("Choose from " + calculatorSelect.getSelectFieldName() + " ---> " + option);
        return this;
    }

    private GoogleCloudPricingCalculatorPage chooseFromSelect(String selectFieldName, String option) {
        calculatorSelect = new CloudCalculatorSelect(selectFieldName, driver);
        if (System.getProperty("browser").equals("firefox")) {
            getJsExecutor().scrollIntoView(calculatorSelect.getWebElement());
        }
        calculatorSelect.selectOption(option);
        logger.info("Choose from " + calculatorSelect.getSelectFieldName() + " ---> " + option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseCloudServerConfiguration(CloudServer cloudServer) {
        enterNumberOfInstances(cloudServer.getNumberOfInstances());
        chooseFromSelect("Operating System", cloudServer.getOperatingSystem());
        chooseFromSelect("Machine Class", cloudServer.getMachineClass());
        chooseFromSelect("Machine type", cloudServer.getMachineType());
        clickAddGPU();
        chooseFromSelect("Number of GPUs", cloudServer.getNumberOfGPUs());
        chooseFromSelect("GPU type", cloudServer.getTypeOfGPU());
        chooseFromSelects("Local SSD", 1, cloudServer.getLocalSSD());
        chooseFromSelect("Datacenter location", cloudServer.getDatacenterLocation());
        chooseFromSelect("Committed usage", cloudServer.getCommittedUsage());
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickComputeEngineTab() {
        getTimeOut().waitUntilVisible(computeEngineTab).click();
        logger.info("Click on Compute Engine");
        return this;
    }

    private GoogleCloudPricingCalculatorPage enterNumberOfInstances(String numberOfInstances) {
        getTimeOut().waitUntilClickable(inputFieldNumberOfInstances).click();
        inputFieldNumberOfInstances.sendKeys(numberOfInstances);
        logger.info("Enter number of instances");
        return this;
    }

    private void switchToMyFrame() {
        driver.switchTo().frame(firstIframe);
        driver.switchTo().frame(myFrame);
        logger.info("Switch to myFrame");
    }

    public TenMinuteMailPage openEmailGeneratorPageInNewTab(String emailGeneratorUrl) {
        openUrlInNewTab(emailGeneratorUrl);
        return new TenMinuteMailPage(driver);
    }

    public GoogleCloudPricingCalculatorPage clickAddGPU() {
        getTimeOut().waitUntilClickable(checkboxAddGPU).click();
        logger.info("Click on 'Add GPUs' checkbox");
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        getTimeOut().waitUntilClickable(buttonAddToEstimate).click();
        logger.info("Add to estimate");
        return this;
    }

    public double getTotalEstimatedCostOnPage() {
        String totalCost = getTimeOut().waitUntilVisible(totalEstimated).getText();
        logger.info(totalCost);
        return getStringOperations().getTotalCostNumber(totalCost);
    }

    public GoogleCloudPricingCalculatorPage openEmailEstimateWindow() {
        buttonEmailEstimate.click();
        logger.info("Open Email Estimate Window");
        return this;
    }

    public GoogleCloudPricingCalculatorPage pasteEmailToEmailField() {
        if (System.getProperty("browser").equals("chrome")) {
            switchToMyFrame();
        }
        getJsExecutor().scrollIntoView(fieldEmail);
        fieldEmail.click();
        pasteFromClipboard();
        logger.info("Paste email");
        return this;
    }

    public GoogleCloudPricingCalculatorPage sendEmail() {
        getJsExecutor().scrollIntoView(buttonSendEmail);
        buttonSendEmail.click();
        logger.info("Send email");
        return this;
    }
}
