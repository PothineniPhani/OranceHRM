Feature: login page feature
Scenario: login page title
    Given user is on login page 
    When user gets title of the page
    Then page title should be "OrangeHRM"
    
    Scenario: forget password link is
        Given user is on login page 
        Then forget password link should be displayed
        
    Scenario: login with correct credentials
        Given user is on login page
        When user enters username "Admin"
        And user enters password "admin123"
        And user clicks on login button
       And page title should be "OrangeHRM"
       
       Scenario: logo is displayed        
           Given user is on login page
           Then Logo should be displayed