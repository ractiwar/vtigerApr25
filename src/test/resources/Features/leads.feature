Feature: Lead feature


  Scenario: Create Lead data driven
    Given User is on login page
    When User enters valid user id and password
    And  click on Log in button
    When user click on New Lead and fill last name and company and save it
          |Shailesh|Dasaault |
          |Shalini |Dtech   |
          |Shailesh|ML       |
    Then Lead should be created successfully

