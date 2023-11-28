package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    public void selectMenu(String menu){
        //This method should click on the menu
        List<WebElement> elementList = driver.findElements(By.id("menu"));
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(menu)){
                element.click();
                break;
            }
        }
    }


    // This method will click on element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    // This method will send text to element
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys();
    }

    //This Method will get text from element
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    // This method will find  element
    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    public void clearTextFromElement(By by){
        driver.findElement(by).clear();
    }

    //This method will verify the element
    public void verifyElements( String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals( expectedMessage, actualMessage);
    }

    //*******************************************  Select class Method   *********************************************

    // Select By Value from DropDown
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    //Select By index from dropDown
    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    //Select by Visible text from DropDown
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    //********************************************  Action method Mouse Hoover  *******************************************

    //This method will mouse hover on element
    public void mouseHoverToElement(By by){
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    // This method will have click action on mouseHover element
    public void clickMouseHoverOnElements(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
//************************************************* Assertion Method *********************************************************

    //This method will verify the text
    public void verifyText( String expectedText, String actualText) {
        Assert.assertEquals(expectedText,actualText);

    }

    //This method will find an element from WebPage

    public WebElement findElementFromWebPage(By by) {
        return driver.findElement(by);
    }

    //This method will find the list of elements

    public List<WebElement> findElementsFromWebPage(By by) {
        return driver.findElements(by);

    }
}
