Feature: Dashboard feature 
Background: 
	Given the user is logged in the application 
		|username|password|
		|Admin|admin123|
		
Scenario: Dashboard page Title 
	Given user is on Dashboard page 
	Then page dashboardtitle should be "OrangeHRM" 
	
Scenario: Dashboard quicklanch section 
	Given user is on Dashboard page 
	Then user gets quicklanch section 
		|Assign Leave|
		|Leave List|
		|Timesheets|
		|Apply Leave|
		|My Leave|
		|My Timesheet|
	And quicklauch section should be 6 
	
	
	
	
	