package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HeaderPage {
    public WebDriver driver;

    public HeaderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//b[contains(text(),\' 2025\')]")
    WebElement lbl_calanderYear;

    @FindBy(xpath = "//td[contains(text(),\'Calculator\')]")
    WebElement lbl_calculator;

    @FindBy(xpath = "//input[@type = \'text\'][1]")
    WebElement tb_searchBox;

    @FindBy(xpath = "//div[@id = 'theClockLayer']")
    WebElement ctrl_clock;

    @FindBy(xpath = "//td[contains(text(), 'My Pipeline')]")
    WebElement lbl_myPipeline;
    //Links on home screen
    @FindBy(xpath = "//a[@class = 'moduleMenu' and contains(text(), 'New Contact')]")
    WebElement link_newContact;

    @FindBy(xpath = "//a[@href='index.php?module=Leads&action=index']")
    WebElement link_newLead;

    @FindBy(xpath = "//a[@class = 'moduleMenu' and contains(text(), 'New Account')]")
    WebElement link_newAccount;

    @FindBy(xpath = "//a[@class = 'moduleMenu' and contains(text(), 'New Potential')]")
    WebElement link_newPotential;

    @FindBy(xpath = "//a[contains(@href , \"Logout\")]")
    public WebElement btn_logout;

    @FindBy(xpath = "//a[contains(@href, 'Leads&action')]")
    WebElement tab_lead;


    public boolean navigatedToHomePage(){

        ArrayList<WebElement> elements = new  ArrayList<>();
        //elements.add(pendingAndActiveActivity);
        elements.add(lbl_calanderYear);
        elements.add(lbl_calculator);
        elements.add(tb_searchBox);
        elements.add(ctrl_clock);
        boolean ctrlVisible = true;
        for (int i =0;i<elements.size();i++){
            if (elements.get(i).isDisplayed()){
                System.out.println("Element is available on Home page"+ elements.get(i));

            }
            else {
                ctrlVisible =false;
                System.out.println("Element is not available on Home page"+ elements.get(i));
            }
        }
        return ctrlVisible;
    }

    public void verifyLogoutButton(){
        boolean ispresent =  btn_logout.isDisplayed();
        if (ispresent == true)
        {
            System.out.println("Logout button is displayed");
        }

    }

    public void navigateToLead(){

        link_newLead.click();
    }

    public void clickLogout(){
        btn_logout.click();
    }




}
