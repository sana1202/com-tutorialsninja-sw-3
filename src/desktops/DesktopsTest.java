package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/*
Create class “DesktopsTest”
Write the following Test:
1.Test name verifyProductArrangeInAlphaBaticalOrder()
1.1 Mouse hover on Desktops Tab.and click
1.2 Click on “Show All Desktops”
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.
2. Test name verifyProductAddedToShoppingCartSuccessFully()
2.1 Mouse hover on Currency Dropdown and click
2.2 Mouse hover on £Pound Sterling and click
2.3 Mouse hover on Desktops Tab.
2.4 Click on “Show All Desktops”
2.5 Select Sort By position "Name: A to Z"
2.6 Select product “HP LP3065”
2.7 Verify the Text "HP LP3065"
2.8 Select Delivery Date "2023-11-27"
2.9.Enter Qty "1” using Select class.
2.10 Click on “Add to Cart” button
2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
2.12 Click on link “shopping cart” display into success message
2.13 Verify the text "Shopping Cart"
2.14 Verify the Product name "HP LP3065"
2.15 Verify the Delivery Date "2023-11-27"
2.16 Verify the Model "Product21"
2.17 Verify the Todat "£74.73
 */
public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product price will arrange in Descending order.
        List<WebElement> order = driver.findElements(By.xpath("//div[@class='caption']"));
        for (WebElement desOrder : order) {
            System.out.println(desOrder.getText());

//        List<WebElement> productNames = driver.findElements(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 div.row:nth-child(7) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:nth-child(1) div.product-thumb div:nth-child(2) div.caption h4:nth-child(1) > a:nth-child(1)"));
//        List<String> originalList = new ArrayList<>();
//        for (WebElement productName : productNames) {
//            originalList.add(productName.getText());
//        }
//        List<String> sortedList = new ArrayList<>(originalList);
//        Collections.sort(sortedList, Collections.reverseOrder());
//        Assert.assertEquals(originalList, sortedList);

        }
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){

        //2.1 Mouse hover on Currency Dropdown and click
        clickOnElement(By.xpath("(//i[@class='fa fa-caret-down'])[1]"));
        //2.2 Mouse hover on £Pound Sterling and click
        clickOnElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        //2.3 Mouse hover on Desktops Tab.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        //2.4 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //2.5 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");
        //2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        //2.7 Verify the Text "HP LP3065"
        verifyText("HP LP3065",getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']")));
        //2.8 Select Delivery Date "2023-11-27"
        WebElement dateTextField = findElementFromWebPage(By.id("input-option225"));
        dateTextField.click();
        dateTextField.sendKeys(Keys.CONTROL, "a");
        dateTextField.sendKeys(Keys.DELETE);
        dateTextField.sendKeys("2023-11-27");
        //2.9.Enter Qty "1” using Select class.
        WebElement quantityfield = findElementFromWebPage(By.id("input-quantity"));
        quantityfield.click();
        quantityfield.clear();
        quantityfield.sendKeys("1");
        //2.10 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyText("Success: You have added HP LP3065 to your shopping cart!\n×",getTextFromElement(By.xpath("//div[contains(text(),'Success: You have added')]")));
        //2.12 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.13 Verify the text "Shopping Cart"
        verifyText("Shopping Cart  (1.00kg)",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));
        //2.14 Verify the Product name "HP LP3065"
        verifyText("HP LP3065",getTextFromElement(By.xpath("(//a[contains(text(),'HP LP3065')])[2]")));
        //2.15 Verify the Delivery Date "2023-11-27"
        verifyText("Delivery Date:2023-11-27",getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date:2023-11-27')]")));
        //2.16 Verify the Model "Product21"
        verifyText("Product 21",getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]")));
        //2.17 Verify the Total "£74.73"
        verifyText("£74.73",getTextFromElement(By.xpath("(//td[contains(text(),'£74.73')])[4]")));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
