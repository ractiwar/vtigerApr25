package com.vtiger.stepidentification;


import com.vtiger.Pages.HomePage;
import com.vtiger.Pages.LoginPage;
import com.vtiger.utilities.CommonActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class loginSteps extends BaseSteps {



    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("http://localhost:100");
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);


    }

    @When("user enters valid user id and password")
    public void user_enters_valid_user_id_and_password() {
        loginpage.login("admin","admin");

    }

    @When("click on Log in button")
    public void click_on_log_in_button() {

        //loginpage.clickLogin();
    }

    @Then("user should be navigated to home page")
    public void user_should_be_navigated_to_home_page() {

        homepage.navigatedToHomePage();
        System.out.println("Navigated On Home page");

    }
    @Then("user is able to see the logout button")
    public void user_is_able_to_see_the_logout_button() throws InterruptedException {
        homepage.verifyLogoutButton();
        driver.quit();

    }

    @When("user enters invalid user id and password")
    public void user_enters_invalid_user_id_and_password() {
        loginpage.login("admin12", "admin123");
    }
    @Then("user should not be navigated to home page")
    public void user_should_not_be_navigated_to_home_page() {
        loginpage.tb_pwd.isDisplayed();
        System.out.println("User is not navigated to Home screen");




    }
    @Then("user is able to see the error message")
    public void user_is_able_to_see_the_error_message() {
         loginpage.verifyErrormsg();
         System.out.println("Error message is displayed");
    }

}
