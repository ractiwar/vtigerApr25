package com.vtiger.stepidentification;

import com.vtiger.Pages.HomePage;
import com.vtiger.Pages.LoginPage;
import com.vtiger.utilities.CommonActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeadOperations extends BaseSteps {

    @Given("User is logged in successfully")
    public void user_is_logged_in_successfully() {
        driver = new ChromeDriver();
        driver.get("http://localhost:100");
        loginpage = new LoginPage(driver);
        loginpage.login("Admin", "admin");
    }

    @When("User enters click on  Lead Tab")
    public void user_enters_click_on_lead_tab() {
        homepage.navigateToLead();
    }
    @When("Enter the last name and click on Search button")
    public void enter_the_last_name_and_click_on_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Available leads with entered Search criteria should be displayed")
    public void available_leads_with_entered_search_criteria_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
