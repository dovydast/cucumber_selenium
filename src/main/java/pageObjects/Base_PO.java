package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }


    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitDrag(WebElement source, WebElement target){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(source));


    }

    public void waitClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public void waitForAlert_And_ValitdateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_message_text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_message_text, text);
    }

    public void waitForTextToBeVisible(By by, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForTextToBeVisible_String(WebElement element, String expected) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        String ActualMessage = element.getText();
        System.out.println(ActualMessage);
        Assert.assertEquals(ActualMessage, expected);
    }

    public void waitForTextToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementVisability(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitForDragResult(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        String resultMessage = element.getText();
        Assert.assertEquals(resultMessage,text);
    }



}
