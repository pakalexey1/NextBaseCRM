package com.nextbasecrm.test.practice1;

import com.nextbasecrm.test.utilities.ConfigurationReader;
import com.nextbasecrm.test.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS021test {
    @Test
    public void testTS021() {

        final String emailAddress = "helpdesk1@cybertekschool.com";

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Driver.getDriver().findElement(By.className("login-link-forgot-pass")).click();

        WebElement emailAddressBox = Driver.getDriver().findElement(By.name("USER_EMAIL"));
        emailAddressBox.sendKeys(emailAddress);
        Driver.getDriver().findElement(By.className("login-btn")).click();
        WebElement noteTextMsg = Driver.getDriver().findElement(By.className("notetext"));

        String actualNoteTextMsg = noteTextMsg.getText();
        String expectedNoteTextMsg = "A code to reset your password and your registration information has just been " +
                "sent to your e-mail address. Please check your e-mail. Note that the reset code is re-generated on each request.";
        Assert.assertEquals(actualNoteTextMsg, expectedNoteTextMsg);

        Driver.closeDriver();

    }
}
/*
"Given I am on nextbasecrm.com authorization page
When I click on ""Forgot Your Password"" button
And I enter a valid email address
And I click on Reset Password button
Then I should see ""A code to reset your password and your registration information has just been sent to your e-mail address. Please check your e-mail. Note that the reset code is re-generated on each request."" message"
 */