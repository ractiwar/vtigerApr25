@ignore
Feature: Lead Operation sFeature

  Scenario: Perform Search Edit and Delete Operations on a lead
    Given User is logged in successfully
    When User enters click on  Lead Tab
    And  Enter the last name and click on Search button
    Then Available leads with entered Search criteria should be displayed

