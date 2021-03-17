Feature: Order_Form

@test
Scenario Outline: Delivery details given by user displayed in Payment page
Given User navigates to the web site "<TestData>"
When search for the product "<TestData>"
And checkout selected product as guest "<TestData>"
And select next or named day delivery option "<TestData>"
Then I validate the delivery date and time on Review and pay page

Examples:
|TestData|
|validaddress|
#|invalidaddress|