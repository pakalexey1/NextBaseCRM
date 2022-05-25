package com.nextbasecrm.test.practice2;

import com.nextbasecrm.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ID_TS01_2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login.nextbasecrm.com/");

        String userName = "asdfas@cybertekschool.com";
        String password = "UserUser";

        //1- Locate username box
        WebElement userNameBox = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        userNameBox.sendKeys(userName);
        //2- Locate password box
        WebElement passwordBox = driver.findElement(By.cssSelector("input[name='USER_PASSWORD']"));
        passwordBox.sendKeys(password);
        //3- Locate login button
        WebElement loginButton = driver.findElement(By.cssSelector("input.login-btn"));
        loginButton.click();
        //4- Locate error msg
        WebElement errorMsg = driver.findElement(By.cssSelector("div.errortext"));

        String expectedMsg = "Incorrect login or password";
        String actualMsg = errorMsg.getText();

        System.out.println(actualMsg.equals(expectedMsg)? "LogIn button functionality test has successfully passed": "LogIn button functionality test has failed");

        driver.quit();

/*
Given I am on nextbasecrm.com authorization page
When I enter invalid username
And I enter my helpdesk password
And I click on Log In button
Then the user should see "Incorrect login or password" message
 */



    }
}
