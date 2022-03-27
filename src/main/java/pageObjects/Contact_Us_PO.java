package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;


public class Contact_Us_PO extends Base_PO {

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement first_name;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement last_name;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement comment;

    @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@id='contact_reply']/h1" )
    WebElement result;


    public Contact_Us_PO(){
        super();
    }
    public void navigateTo_ContactUs_Page(){
        navigateTo_URL(Global_Vars.URL +"/Contact-Us/contactus.html");
    }

    public void setUnique_name(){
        sendKeys(first_name, "AutoGen_" + generateRandomNumber(5));
    }

    public void setLast_name(){
        sendKeys(last_name, "AutoGen_" + generateRandomString(5));
    }

    public void setEmail(){
        sendKeys(email, "AutoEmail_" + generateRandomNumber(7) + "@mail.com");
    }

    public void setComment(){
        sendKeys(comment, generateRandomString(14));
    }

    public void click_submit_button(){
        waitClick(submitButton);
    }

    public void setSpecific_FirstName(String firstName){
        sendKeys(first_name, firstName);
    }
    public void setSpecific_LastName(String LastName){
        sendKeys(last_name, LastName);
    }

    public void setSpecific_Email(String emailAdress){
        sendKeys(email, emailAdress);
    }

    public void setSpecific_Comment(String commentText){
        sendKeys(comment, commentText);
    }

    public void validateSuccessMessage(){
        waitForTextToBeVisible(result);
        Assert.assertEquals(result.getText(), "Thank You for your Message!");
    }




}
