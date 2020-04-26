package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {
    static WebDriver BrowserDriver;

    public static void main(String[] args) {
        System.out.println("Selenium is running");
    }

    //Firefox browser driver
    static public void setupFireFox() {
        WebDriverManager.firefoxdriver().setup();
        BrowserDriver = new FirefoxDriver();
    }

    //Chrome browser driver
    static public void setupChrome() {
        WebDriverManager.chromedriver().setup();
        BrowserDriver = new ChromeDriver();
    }

    static public void enterUrl(String url) {
        BrowserDriver.get(url);
    }

    static public void getTwitchValorantInfo() {

        waitForElementByXpath("//div[@class='tw-flex tw-justify-content-between tw-relative']//h1[@class='tw-c-text-base tw-font-size-2 tw-strong']");
        WebElement gameTag = BrowserDriver.findElement(By.xpath("//div[@class='tw-flex tw-justify-content-between tw-relative']//h1[@class='tw-c-text-base tw-font-size-2 tw-strong']"));
        WebElement viewCount = BrowserDriver.findElement(By.xpath("//p[@class='tw-c-text-alt tw-font-size-4']/strong"));
        gameTag.getText();
        viewCount.getText();
        System.out.println("Game section: " + gameTag.getText() + "\n Viewer count: " + viewCount.getText());
    }

    //Clickin first most viewed stream
    static public void openFirstValorantStream() {
        waitForElementByXpath("//div[@data-target='directory-first-item']//div[@class='tw-mg-b-2 tw-relative']");
        WebElement firstStream = BrowserDriver.findElement(By.xpath("//div[@data-target='directory-first-item']//div[@class='tw-mg-b-2 tw-relative']"));
        firstStream.click();
    }

    //How many viewers watching on selected stream
    static public void openFirstValorantStreamViewCount() {
        waitForEelementByXpathVisibility("//div[@class='channel-info-bar__viewers-wrapper tw-c-text-live tw-inline-flex']");
        WebElement viewCount = BrowserDriver.findElement(By.xpath("//div[@class='channel-info-bar__viewers-wrapper tw-c-text-live tw-inline-flex']"));
        viewCount.getText();
        System.out.println("Viewers: " + viewCount.getText());
    }


    //ElementsToBeClicked
    static private void waitForElementByName(String name) {
        WebDriverWait waitas = new WebDriverWait(BrowserDriver, 2);
        waitas.until(ExpectedConditions.elementToBeClickable(By.name(name)));
    }

    static private void waitForElementByClassName(String name) {
        WebDriverWait waitas = new WebDriverWait(BrowserDriver, 2);
        waitas.until(ExpectedConditions.elementToBeClickable(By.className(name)));
    }

    static private void waitForElementById(String name) {
        WebDriverWait waitas = new WebDriverWait(BrowserDriver, 2);
        waitas.until(ExpectedConditions.elementToBeClickable(By.id(name)));
    }

    static private void waitForElementByXpath(String name) {
        WebDriverWait waitas = new WebDriverWait(BrowserDriver, 2);
        waitas.until(ExpectedConditions.elementToBeClickable(By.xpath(name)));
    }

    static private void waitForEelementByXpathVisibility(String name) {
        WebDriverWait wait = new WebDriverWait(BrowserDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(name)));
    }

    static private void waitForElementPresenceByClass(String name) {
        WebDriverWait wait = new WebDriverWait(BrowserDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(name)));
    }

    public static void close() {
        BrowserDriver.close();
    }

    public static void quit() {
        BrowserDriver.quit();
    }

}
