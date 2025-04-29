package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    @FindBy(xpath = "//input[@name = 'user_name' and @type='text']")
    public WebElement tb_userid;

    @FindBy(xpath = "//input[@name = 'user_password' and @type='password']")
    public WebElement tb_pwd;

    @FindBy(xpath = "//select[@name = 'login_theme']")
    public WebElement dropdwntheme;

    @FindBy(xpath = "//input[@name='Login']")
    public WebElement btn_login;

    @FindBy(xpath = "//td[contains(text() , \"valid username and password\")]")
    public WebElement loginError;


    public void login(String uid, String pwd){
        setUsername(uid);
        setPassword(pwd);

    }

    public void setUsername(String userName){
        tb_userid.clear();
        tb_userid.sendKeys( userName);
    }

    public void setPassword(String password) {
        tb_pwd.clear();
        tb_pwd.sendKeys(password);

    }

    public void clickLogin(){
        btn_login.click();
    }

    public  void verifyErrormsg(){
        loginError.isDisplayed();
    }
    }

