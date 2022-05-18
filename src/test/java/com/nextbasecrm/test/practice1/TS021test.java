package com.nextbasecrm.test.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS021test {
    @Test
    public void testTS021() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        final String emailAddress = "helpdesk1@cybertekschool.com";

        driver.get("https://login.nextbasecrm.com/");
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        forgotPassword.click();

        WebElement emailAddressBox = driver.findElement(By.name("USER_EMAIL"));
        emailAddressBox.sendKeys(emailAddress);

        WebElement resetPasswordButton = driver.findElement(By.className("login-btn"));
        resetPasswordButton.click();

        WebElement noteTextMsg = driver.findElement(By.className("notetext"));


        String actualNoteTextMsg = noteTextMsg.getText();
        String expectedNoteTextMsg = "A code to reset your password and your registration information has just been " +
                "sent to your e-mail address. Please check your e-mail. Note that the reset code is re-generated on each request.";
        Assert.assertEquals(actualNoteTextMsg,expectedNoteTextMsg);


//        driver.quit();

    }
}
/*
"Given I am on nextbasecrm.com authorization page
When I click on ""Forgot Your Password"" button
And I enter a valid email address
And I click on Reset Password button
Then I should see ""A code to reset your password and your registration information has just been sent to your e-mail address. Please check your e-mail. Note that the reset code is re-generated on each request."" message"
 */