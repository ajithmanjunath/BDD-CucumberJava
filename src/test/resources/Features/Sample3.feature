Feature: Login function

Scenario Outline: Verify the login functionality is successfull with credentials provided 

Given I navigate to website url - "<url>" 
When I click on login portal link
When I enter the username - "<username>" 
When I enter the password - "<password>"
When I click on login 
Then Alert message is displayed and is verified with the displayed and with - "<message>"

Examples: 
		|				url						|		username		|	password	|	message							|
		|http://www.webdriveruniversity.com/	|webdriver				|webdriver123	|validation succeeded				|
		|http://www.webdriveruniversity.com/	|webdriver2				|webdriver458	|validation failed					|
		|http://www.webdriveruniversity.com/	|webdriver				|webdriver123	|validation failed 					|