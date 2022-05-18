package com.nextbasecrm.test.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS012test {
    @Test
    public void testTS012() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        final String USERNAME = "asdfas@cybertekschool.com";
        final String PASSWORD = "UserUser";

        driver.get("https://login.nextbasecrm.com/");
        WebElement usernameBox = driver.findElement(By.name("USER_LOGIN"));
        usernameBox.sendKeys(USERNAME);

        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        String expectedMessage1 = "Incorrect login or password";
        //String expectedMessage2 = "24";

        WebElement errorMsg = driver.findElement(By.className("errortext"));

        System.out.println(errorMsg.getText());

        String actualMessage1 = errorMsg.getText();

        //System.out.println(expectedMessage1.equals(expectedMessage1) ? "Test passed": "Test failed");

        Assert.assertEquals(expectedMessage1, actualMessage1);

        driver.quit();
    }
}
