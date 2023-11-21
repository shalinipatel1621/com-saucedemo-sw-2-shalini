package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        //verify the text products
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        //verify the text products
        int productCount = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals(productCount, 6);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
