package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {

    @FindBy(xpath = "/html//input[@id='text']")
    WebElement loginName_TextField;

    @FindBy(xpath = "/html//input[@id='password']")
    WebElement password_TextField;

    @FindBy(xpath = "/html//button[@id='login-button']")
    WebElement login_Button;

    public  Login_PO(){
        super();
    }

    public void navigateTo_Login_Page (){
        navigateTo_URL("http://www.webdriveruniversity.com/Login-Portal/run.html");
    }

    public void setLoginName(String login_name){
        sendKeys(loginName_TextField, login_name);
    }

    public void setPassword(String password){
        sendKeys(password_TextField, password);
    }

    public void clickOn_Login_Button(){
        waitClick(login_Button);
    }




}

