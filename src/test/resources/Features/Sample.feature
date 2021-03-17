Feature: Login feature verification using valid credentials

@test
Scenario: User is able to login to the application with correct credentials
Given User navigates to the web site
When User enter valid username
When User enter valid password 
And User clicks on login button
Then User should be login successfully and landed in home page 


