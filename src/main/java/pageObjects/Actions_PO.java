package pageObjects;

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


    public  Actions_PO(){
        super();
    }

    public void navigateTo_Page (){
        navigateTo_URL(Global_Vars.URL + "/Actions/index.html");
    }

    public void DragAndDrop(){
        (new Actions(getDriver())).dragAndDrop(drag_me, drop_me).perform();
    }

    public void validateConfirmationMessage(){
      waitForDragResult(drop_me, "Dropped!");
    }

    public void doubleClickYellowBox(){
        (new Actions(getDriver())).doubleClick(double_click).perform();
    }

    public void colorResult(){
        String defaultColor = double_click.getAttribute("class");
        Assert.assertEquals(defaultColor,"div-double-click double");
        System.out.println(defaultColor);
    }

}

