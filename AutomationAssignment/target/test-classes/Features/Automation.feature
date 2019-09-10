Feature: Test Order a Product and Updation of Personal Information.

  Background: 
    Given the url of the application under test
	
	@ProductPurchase
  Scenario: Order a Product
    In this Scenario we will Order a T-Shirt and verify the purchase in Order History

    Given user is on the website, login with the following credentials
      | johndoe@email.com | password |
    When user is on My Store click on T-Shirts Menu and Order a T-Shirt
    Then verify order is placed successfully in Order History

	@UpdateInformation
  Scenario: Update Personal Information (First Name) in My Account
    In this Scenario we will navigate to My Account and Update First Name with a New String value

    Given user is on the website, navigate to My Personal Information Page
    When user is on Your Personal Information Page, update First Name
