package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.HeaderPage;

import javax.xml.xpath.XPath;

public class NewLeadPage extends HeaderPage {

    public NewLeadPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    WebElement txtbox_lastName;

    @FindBy(xpath = "//input[@name=\"company\"]")
    WebElement txtbox_company;

    @FindBy(xpath = "//input[@title='Save [Alt+S]' and @name = 'button']")
    WebElement btn_save;

    @FindBy(xpath = "//input[@type = 'radio' and @value = \"U\"]")
    WebElement radioBtn_User;

    @FindBy(xpath = "//input[@type = 'radio' and @value = \"T\"]")
    WebElement radioBtn_Team;

    @FindBy(xpath = "//td[contains(text(),\"Last Name\")]/following::*[1]")
    WebElement lstnamevaluelbl;

    public void verifyLead(String lstName, String company)
    {
        lstnamevaluelbl.isDisplayed();

    }

    public void createLead(String lstName, String company){
        txtbox_lastName.sendKeys(lstName);
        txtbox_company.sendKeys(company);
        btn_save.click();
    }
}
