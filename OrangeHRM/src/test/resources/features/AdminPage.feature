Feature: checking adminpage details 

Background: 
	Given user is logged into Application 
		|username|password|
		|Admin|admin123|
		
Scenario: scenario description
    Given user is on Adminpanel
    When user clicks on userslink
    Then verify select btn is enabled or not 