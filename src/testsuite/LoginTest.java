package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        //find username and send keys
        sendTextToElement(By.id("user-name"), "standard_user");

        //find password and send keys
        sendTextToElement(By.id("password"), "secret_sauce");

        //find login button element and click
        clickOnElement(By.id("login-button"));

        String expectedDisplay = "PRODUCTS";
        String actualDisplay = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));

        //validate expected and actual message
        Assert.assertEquals("Not Matching", expectedDisplay, actualDisplay);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //send text to element
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        //click on element
        clickOnElement(By.id("login-button"));

        //calling method from utility class to confirm six products on web page
        verifyProducts();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
