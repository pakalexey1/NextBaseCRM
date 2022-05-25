package com.nextbasecrm.test.practice2;

import com.nextbasecrm.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ID_TS02_1 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login.nextbasecrm.com/");

        String emailAddress = "helpdesk1@cybertekschool.com";
        //1- Locate Forgot Password Button
        WebElement forgotPassButton = driver.findElement(By.cssSelector("a.login-link-forgot-pass"));
        forgotPassButton.click();
        //2- Locate Email Address Box
        WebElement emailAddressBox = driver.findElement(By.cssSelector("input[name='USER_EMAIL']"));
        emailAddressBox.sendKeys(emailAddress);
        //3- Locate Reset Password button
        WebElement resetPassButton = driver.findElement(By.cssSelector("button.login-btn"));
        resetPassButton.click();
        //4- Locate Notice Msg
        WebElement noteTextMsg = driver.findElement(By.cssSelector("div[class='notetext']"));

        String expectedNoteText = "A code to reset your password and your registration information has just been sent to your e-mail address. Please check your e-mail. Note that the reset code is re-generated on each request.";
        String actualNoteText = noteTextMsg.getText();

        System.out.println(actualNoteText.equals(expectedNoteText)? "Reset Password Test has successfully passed": "Reset Password Test has failed");


        driver.quit();

/*
Given I am on nextbasecrm.com authorization page
When I click on "Forgot Your Password" button
And I enter a valid email address
And I click on Reset Password button
Then I should see "A code to reset your password and your registration information has just been sent to your e-mail address. Please check your e-mail. Note that the reset code is re-generated on each request." message
 */
    }

}
