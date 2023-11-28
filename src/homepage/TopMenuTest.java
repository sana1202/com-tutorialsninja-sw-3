package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/*
create method with name "selectMenu" it has one parameter name "menu" of type
string
1.2 This method should click on the menu whatever name is passed as parameter.
Write the following Test:
1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
1.1 Mouse hover on “Desktops” Tab and click
1.2 call selectMenu method and pass the menu = “Show All Desktops”
1.3 Verify the text ‘Desktops’
2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
2.1 Mouse hover on “Laptops & Notebooks” Tab and click
2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
2.3 Verify the text ‘Laptops & Notebooks’
3. verifyUserShouldNavigateToComponentsPageSuccessfully()
3.1 Mouse hover on “Components” Tab and click
3.2 call selectMenu method and pass the menu = “Show All Components”
3.3 Verify the text ‘Components
 */
public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals("Desktops", getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']")));

    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){

        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals("Laptops & Notebooks",getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")));

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Components']"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals("Components",getTextFromElement(By.xpath("//h2[normalize-space()='Components']")));


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
    }

