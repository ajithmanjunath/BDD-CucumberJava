Feature: Login feature verification using valid credentials

Scenario: User is able to login to the application with correct credentials

Given User2 navigates to the web site
When User2 enter valid username
When User2 enter valid password 
And User2 clicks on login button
Then User2 should be login successfully and landed in home page  

