package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/*
Create the class LaptopsAndNotebooksTest
Write the following test
1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
1.1 Mouse hover on Laptops & Notebooks Tab.and click
1.2 Click on “Show All Laptops & Notebooks”
1.3 Select Sort By "Price (High > Low)"
1.4 Verify the Product price will arrange in High to Low order.
2. Test name verifyThatUserPlaceOrderSuccessfully()
2.1 Mouse hover on Laptops & Notebooks Tab and click
2.2 Click on “Show All Laptops & Notebooks”
2.3 Select Sort By "Price (High > Low)"
2.4 Select Product “MacBook”
2.5 Verify the text “MacBook”
2.6 Click on ‘Add To Cart’ button
2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
2.8 Click on link “shopping cart” display into success message
2.9 Verify the text "Shopping Cart"
2.10 Verify the Product name "MacBook"
2.11 Change Quantity "2"
2.12 Click on “Update” Tab
2.13 Verify the message “Success: You have modified your shopping cart!”
2.14 Verify the Total £737.45
2.15 Click on “Checkout” button
2.16 Verify the text “Checkout”
2.17 Verify the Text “New Customer”
2.18 Click on “Guest Checkout” radio button
2.19 Click on “Continue” tab
2.20 Fill the mandatory fields
2.21 Click on “Continue” Button
2.22 Add Comments About your order into text area
2.23 Check the Terms & Conditions check box
2.24 Click on “Continue” button
2.25 Verify the message “Warning: Payment method required!”

 */
public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        clickMouseHoverOnElements(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"),"Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        List<WebElement> productPrices = driver.findElements(By.xpath("//p[@class='price']"));
        for (WebElement prices : productPrices) {
            System.out.println(prices.getText());
        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        clickMouseHoverOnElements(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"),"Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[contains(text(),'MacBook Pro')]"));
        //2.5 Verify the text “MacBook”
        verifyText("MacBook Pro",getTextFromElement(By.xpath("//h1[contains(text(),'MacBook Pro')]")));
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyText("Success: You have added MacBook Pro to your shopping cart!\n×",getTextFromElement(By.xpath("//div[contains(text(),'Success: You have added')] ")));
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));
        //2.9 Verify the text "Shopping Cart"
        verifyText("Shopping Cart  (0.00kg)",getTextFromElement(By.xpath("(//h1)[2]")));
        //2.10 Verify the Product name "MacBook"
        verifyText("MacBook Pro",getTextFromElement(By.linkText("MacBook Pro")));
        //2.11 Change Quantity "2"
//        driver.findElement(By.xpath("//input[@class='form-control']")).clear();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //sendTextToElement(By.xpath("//input[@class='form-control']"),"2");
        WebElement quantityfield = findElementFromWebPage(By.xpath("//div[@class='input-group btn-block']"));
        quantityfield.click();
        quantityfield.clear();
        quantityfield.sendKeys("2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals("Success: You have modified your shopping cart!\n" + "×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        //2.14 Verify the Total £2,450.00
        verifyText("£2,450.00",getTextFromElement(By.xpath("(//td[contains(text(),'£2,450.00')])[6]")));
        //2.15 Click on “Checkout” button
        clickOnElement(By.linkText("Checkout"));
        //2.16 Verify the text “Checkout”
        verifyText("Checkout",getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]")));
        //2.17 Verify the Text “New Customer”
        verifyText("",getTextFromElement(By.xpath("(//h2)[1]")));
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Pinki");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Sheth");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "Prish123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "0776859453");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "St Johns Parade");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "Crawley");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "RH10 4ED");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"),"United Kingdom");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"),"Greater London");
        //2.21 Click on “Continue”Button
        clickOnElement(By.id("button-guest"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Please Drop in Backyard");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));
        //2.25 Verify the message “Warning: Payment method required!”

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
