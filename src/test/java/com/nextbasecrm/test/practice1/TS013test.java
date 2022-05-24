package com.nextbasecrm.test.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS013test {
    @Test
    public void  testTS013(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //"Given I am on nextbasecrm.com authorization page
        driver.get("https://login.nextbasecrm.com/");

        //When I enter my helpdesk user name
        WebElement userName = driver.findElement(By.cssSelector("div>input[name='USER_LOGIN']"));
        userName.sendKeys("helpdesk1@cybertekschool.com");

        //And I enter invalid password
        WebElement password = driver.findElement(By.cssSelector("div>input[name='USER_PASSWORD']"));
        password.sendKeys("asdfsadf");

        //And I click on Log In button
        WebElement loginButton = driver.findElement(By.cssSelector("div>input[class='login-btn']"));
        loginButton.click();

        //Then the user should see ""Incorrect login or password"" message"
        WebElement errorMessage = driver.findElement(By.cssSelector("div[class='errortext']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Incorrect login or password";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        driver.quit();


    }
}

/*
"Given I am on nextbasecrm.com autorization page
When I enter my helpdesk user name
And I enter invalid password
And I click on Log In button
Then the user should see "Incorrect login or password" message"

Data:
Username:
helpdesk1@cybertekschool.com
helpdesk2@cybertekschool.com

Password: asdfsadf
 */