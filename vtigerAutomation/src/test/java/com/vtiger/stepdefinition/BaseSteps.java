package com.vtiger.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewLeadPage;

import java.time.Duration;

public class BaseSteps {
    public static WebDriver driver = new ChromeDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static LoginPage lp;
    public  static HomePage hp;
    public  static NewLeadPage nlp;
    public static HeaderPage headerpage;


}
