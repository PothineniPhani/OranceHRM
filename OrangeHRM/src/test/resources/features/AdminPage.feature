Feature: checking adminpage details 

Background: 
	Given user is logged into Application 
		|username|password|
		|Admin|admin123|
		
Scenario: scenario description 
	Given user is on Adminpanel 
	When user clicks on userslink 
	Then verify select btn is enabled or not 
	And verify reset btn is enabled or not 
	And verify Add btn is enabled or not 
	
	
	
Scenario Outline: scenario description 
	Given user is on Adminpanel 
	And  user clicks on userslink 
	And user enters "<username>" in username fields 
	And user selects userRole 
	And user enters "<EmployeeName>" in EmployeeName field 
	And user selects Status of the employee 
	And user clicks on search botton 
	Then verify user is "Alice Duval" 
	
	Examples: 
		| username | EmployeeName|
		|Alice.Duval|Alice Duval|
		
		
Scenario Outline: adding users to 
	Given user is on Adminpanel 
	And  user clicks on userslink 
	And user clicks on Add button 
	When user fills form from given "<sheetName>" and <rownumber> 
	And user clicks on save button 
	Then it shows successfull message "Successfully Saved" 
	Examples: 
		|sheetName|rownumber|
		|DataAdding|1|
		
		
        