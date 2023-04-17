package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }
    /*** Enter “Admin” username
     * Enter “admin123“ password
     * Click on ‘LOGIN’ button
     * Verify the ‘Dashboard’ text is display*/
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “Admin” username
        WebElement userName = driver.findElement(By.xpath("//input[@name = 'username']"));
        userName.sendKeys("Admin");
        // Enter “admin123“ password
        WebElement passWord = driver.findElement(By.xpath("//input[@name = 'password']"));
        passWord.sendKeys("admin123");
        //Click on ‘LOGIN’ button
        // WebElement clickLogin = driver.findElement(By.xpath("//input[@type = 'submit']"));
        WebElement clickLogin = driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));
        clickLogin.click();

        //WebElement clickDashboardElement = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        WebElement clickDashboardElement = driver.findElement(By.linkText("Dashboard"));
        clickDashboardElement.click();

        //Verify the ‘Dashboard’ text is display
        String expectedTitle = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"));
        //System.out.println("Expected result = " + actualTextElement.getText());

        String actualTitle = actualTextElement.getText();
        Assert.assertEquals("DashBoard text is not displayed", expectedTitle, actualTitle);

    }

    @After
    public void tearDown() {
        closeDriver();

    }


}
