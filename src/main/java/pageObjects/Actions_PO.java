package pageObjects;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;

public class Actions_PO extends Base_PO{

    @FindBy(xpath = "//div[@id='draggable']")
    WebElement drag_me;
    @FindBy(xpath = "//div[@id='droppable']")
    WebElement drop_me;
    @FindBy(xpath = "//div[@id='double-click']")
    WebElement double_click;
    @FindBy (xpath = "//div[@id='div-hover']/div[3]")
    WebElement ThirdBox;
    @FindBy (xpath = "//div[@id='div-hover']/div[3]/div/a[2]")
    WebElement option2;
    @FindBy (xpath = "/html//div[@id='click-box']")
    WebElement HoldOrangeBox;


    public  Actions_PO(){
        super();
    }

    public void navigateTo_Page (){
        navigateTo_URL(Global_Vars.URL + "/Actions/index.html");
    }

    public void DragAndDrop(){
        (new Actions(getDriver())).dragAndDrop(drag_me, drop_me).perform();
    }

    public void validateDragConfirmationMessage(){
      waitForDragResult(drop_me, "Dropped!");
    }
    public void validateHoldConfirmMessage(String text){
    waitForTextToBeVisible_String(HoldOrangeBox, text);;
    }


    public void doubleClickYellowBox(){
        (new Actions(getDriver())).doubleClick(double_click).perform();
    }

    public void colorResult(){
        String defaultColor = double_click.getAttribute("class");
        Assert.assertEquals(defaultColor,"div-double-click double");
        System.out.println(defaultColor);
    }

    public void HoverThirdBox(){
        Actions action = new Actions(getDriver());
        action.moveToElement(ThirdBox).perform();
    }

    public void selectSecondOption(){
        waitClick(option2);
    }

    public void AlertMessage(String text){
      waitForAlert_And_ValitdateText(text);
    }

    public void HoldLeftMouseClick(){
        (new Actions(getDriver())).clickAndHold(HoldOrangeBox).perform();
    }

}

