package com.nextbasecrm.test.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS026test {

    @Test
    public void testTS026() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://login.nextbasecrm.com/");

        WebElement forgotPasswordButton = driver.findElement(By.xpath("//div[@class='log-popup-footer']/a[@class='login-link-forgot-pass']"));
        forgotPasswordButton.click();


        String expectedTitle = "Get Password";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        loginBox.sendKeys("helpdesk1@cybertekschool.com");

        WebElement emailBox = driver.findElement(By.name("USER_EMAIL"));
        emailBox.sendKeys("asdfas@cybertekschool.com");

        WebElement resetButton = driver.findElement(By.xpath("//div[@class='log-popup-footer']/button[@class='login-btn']"));
        resetButton.click();
        WebElement noteMessage = driver.findElement(By.className("notetext"));

        String expectedResult1 = "Login or E-mail not found";
        String actualResult1 = noteMessage.getText();
        Assert.assertEquals(expectedResult1, actualResult1);



        driver.quit();
        /*
        "Given I am on nextbasecrm.com autorization page
When I clik on ""Forgot Your Password"" button
And I enter a valid login and an invalid e-mail address
And I click on Reset Password button
Then I should not be able to click on Reset Password button"
         */

    }

}
