package com.vtiger.stepidentification;


import com.vtiger.Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CreateLead extends BaseSteps {

    @When("User enters valid user id and password")

    public void user_enters_valid_user_id_and_password() {

        driver = new ChromeDriver();
        driver.get("http://localhost:100");
        loginpage = new LoginPage(driver);
        loginpage.login("admin","admin");

    }
    @When("user click on New Lead and fill mandatory form")
    public void user_click_on_new_lead_and_fill_mandatory_form()
    {
        System.out.println("Lead Creation");
        newleadpage.createLead("Rohit", "Suroj Buildcon");

    }
    @Then("Lead should be created successfully")
    public void lead_should_be_created_successfully() {
        newleadpage.verifyLead("Rohit", "Suroj Buildcon");
    }

    @When("user click on New Lead and fill last name and company and save it")
    public void user_click_on_new_lead_and_fill_last_name_and_company_and_save_it(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> lst= dataTable.asLists();
        for(int i = 0;i<lst.size();i++){
            homepage.navigateToLead();
            newleadpage.createLead(lst.get(i).get(0).toString(),lst.get(i).get(1).toString() );
            newleadpage.verifyLead(lst.get(i).toString(), lst.get(1).toString());

        }
    }

}
