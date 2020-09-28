package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {

    private Actions actions;
    private WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(this.driver);
    }

    public void pasteWin() {
        actions.keyDown(Keys.LEFT_CONTROL).sendKeys("v").keyUp(Keys.LEFT_CONTROL).build().perform();
    }

    public void pasteMacOnChromedriver() {
        actions.keyDown(Keys.SHIFT).sendKeys(Keys.INSERT).keyUp(Keys.SHIFT).build().perform();
    }

    public void pasteMacOnGeckodriver() {
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build().perform();
    }
}
