package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages;

import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.actions.Action;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.actions.JSExecutor;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.actions.TimeOut;
import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.util.StringOperations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public abstract class Page {

    WebDriver driver;
    Logger logger = LogManager.getLogger(this.getClass());
    final String OS = System.getProperty("os");
    final String BROWSER = System.getProperty("browser");
    private TimeOut timeOut;
    private StringOperations stringOperations;
    private JSExecutor jsExecutor;
    private Action action;

    TimeOut getTimeOut() {
        if (timeOut == null) {
            timeOut = new TimeOut(driver);
        }
        return timeOut;
    }

    StringOperations getStringOperations() {
        if (stringOperations == null) {
            stringOperations = new StringOperations();
        }
        return stringOperations;
    }

    JSExecutor getJsExecutor() {
        if (jsExecutor == null) {
            jsExecutor = new JSExecutor(driver);
        }
        return jsExecutor;
    }

    Action getAction() {
        if (action == null) {
            action = new Action(driver);
        }
        return action;
    }

    public Page loadPageInNewBrowser(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        logger.info("Open " + url);
        return this;
    }

    public void openUrlInNewTab(String url) {
        getJsExecutor().openNewTab();
        goOneTabForward();
        logger.info("Open a new tab");
        driver.get(url);
        logger.info("Open " + url);
    }

    private void goOneTab(int movement) {
        String currentTab = driver.getWindowHandle();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        int indexOfCurrentTab = tabs.indexOf(currentTab);
        driver.switchTo().window(tabs.get(indexOfCurrentTab + movement));
    }

    public void goOneTabBackward() {
        goOneTab(-1);
        logger.info("Go one tab backward");
    }

    public void goOneTabForward() {
        goOneTab(1);
        logger.info("Go one tab forward");
    }

    public void pasteFromClipboard() {
        if (OS.equals("mac")) {
            if (BROWSER.equals("chrome")) {
                getAction().pasteMacOnChromedriver();
            } else if (BROWSER.equals("firefox")) {
                getAction().pasteMacOnGeckodriver();
            }
        } else if (OS.equals("win")) {
            getAction().pasteWin();
        }
        logger.info("Paste from clipboard");
    }
}