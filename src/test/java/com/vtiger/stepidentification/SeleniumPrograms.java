package com.vtiger.stepidentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumPrograms {

    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.findElement(By.xpath("//textarea[@name = 'q']")).sendKeys("Automation");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.UUbT9.EyBRub")));


        List<WebElement> suggestions = driver.findElements(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.UUbT9.EyBRub"));
        for(WebElement suggestion: suggestions){
            System.out.println(suggestion.getText());

        }

        driver.quit();
    }
}
