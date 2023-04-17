package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * Write down the following test into ‘ForgotPasswordTest’
     * class
     * 1. userShouldNavigateToForgotPasswordPageSuccessfully *
     * click on the ‘Forgot your password’ link
     * Verify the text ‘
     * Reset Password’
     */

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        WebElement clickForgotPassword = driver.findElement(By.cssSelector("p.oxd-text.oxd-text--p.orangehrm-login-forgot-header"));
        clickForgotPassword.click();

        WebElement resetPasswordTitle = driver.findElement(By.cssSelector("h6.oxd-text.oxd-text--h6.orangehrm-forgot-password-title"));
        //Actual
        String actualTitle = resetPasswordTitle.getText();
        //Expected
        String expectedTitle = "Reset Password";
        //Assert using JUnit

        Assert.assertEquals("Reset Password message is not displayed", expectedTitle, actualTitle);

    }
    @After
    public void tearDown() {
        closeDriver();

    }


}
