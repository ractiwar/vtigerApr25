package com.vtiger.stepdefinition;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;
import com.vtiger.pages.NewLeadPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

public class BaseSteps {
    public static WebDriver driver;
    public static Properties prop;
    Map<String,Map<String,String>> dt;
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static LoginPage lp;
    public  static HomePage hp;
    public  static NewLeadPage nlp;
    public static HeaderPage headerpage;

    public void initiation() throws FileNotFoundException, FilloException {


        if (prop == null){
            readProperties();
        }
        if (dt == null){
            readExlsData();
        }
        if (driver == null)
        {
            System.out.println("Launching app");
         launchApp();
        }
    }

    public void launchApp(){
        System.out.println("Launching browser: " + prop.getProperty("browser"));

        if (prop.getProperty("browser").equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver();
        }else if (prop.getProperty("browser").equalsIgnoreCase("FireFox"))
        {
            driver = new FirefoxDriver();
        }else if (prop.getProperty("browser").equalsIgnoreCase("Edge"))
        {
            driver = new EdgeDriver();
        }else if (prop.getProperty("browser").equalsIgnoreCase("headless"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }else{
            driver = new ChromeDriver();
        }
        System.out.println(prop.getProperty("appurl"));

        driver.get(prop.getProperty("appurl"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        headerpage = new HeaderPage(driver);
        nlp = new NewLeadPage(driver);
    }
    public void readProperties(){
        try {
            prop = new Properties();
            Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "Configuration", "settings.properties");
            FileInputStream fis = new FileInputStream(path.toFile());

            //FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Configuration\\settings.properties");
            prop.load(fis);
            System.out.println("FIS Loaded");
            System.out.println("Browser: " + prop.getProperty("browser"));
            System.out.println("App URL: " + prop.getProperty("appurl"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void readExlsData() throws FilloException, FileNotFoundException {
        Fillo fillo=new Fillo();
        Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "TestData", "data.xlsx");
        String filePath = path.toString();
        Connection connection=fillo.getConnection(filePath);
        String strQuery="Select * from Sheet1";
        dt = new HashMap<>();
        Recordset recordset=connection.executeQuery(strQuery);
        List<String> lst  = recordset.getFieldNames();
        System.out.println(lst);
        System.out.println(lst.size());
        while(recordset.next()){
            Map<String,String> map = new HashMap<>();
            for (int i = 1; i< lst.size();i++){
                map.put(lst.get(i).trim(),recordset.getField(lst.get(i)).trim());
                System.out.println(lst.get(i));
                System.out.println(recordset.getField(lst.get(i)));
                System.out.println(i);

            }
            try {

                dt.put(recordset.getField("ScanerioName"), map);
            } catch (FilloException e) {
                throw new RuntimeException(e.getMessage());
            }

        }
        recordset.close();
        connection.close();
            }



}
