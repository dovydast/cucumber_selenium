package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;

public class Ajax_loader_PO extends Base_PO {

    @FindBy(id = "button3")
    WebElement button3;
    @FindBy(id = "button1")
    WebElement greenButton;
    @FindBy(xpath = "/html//div[@id='myModalClick']//div[@class='modal-footer']/button[@type='button']")
    WebElement modal;
    @FindBy(className = "modal-title")
    WebElement title;


    public Ajax_loader_PO(){
        super();
    }


    public void NavigateToPage(){
        navigateTo_URL(Global_Vars.URL + "/Popup-Alerts/index.html");
    }

    public void waitForPresence(){
        waitForElementVisability(greenButton);
    }

    public void ClickButton(){
        waitClick(button3);
    }

    public void ClickGreenButton(){
        waitClick(greenButton);
    }

    public void Verify_Modal_title(){
        waitForTextToBeVisible_String(title,"Well Done For Waiting....!!!");
    }

   public void CloseModal(){
        waitClick(modal);
   }




}

