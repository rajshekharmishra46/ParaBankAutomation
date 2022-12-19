Feature: Opening account

  Scenario: Verification of opening two new accounts for both account types - CHECKING and SAVINGS.
   
    #user login
    Given user land on the correct page
    When user login with username "john" and password "demo"
    Then user verify login is successful
    
    #user opens a "SAVINGS" account
    Given user navigates to account opening section
    When user selects account type as "SAVINGS"
    And user select an existing account to transfer fund into new account
    And user proceed for account opening 
    Then user verify the account is created
    And user verify the new account number is generated
    
    #user opens a "CHECKING" account
    Given user navigates to account opening section
    When user selects account type as "CHECKING"
    And user select an existing account to transfer fund into new account
    And user proceed for account opening 
    Then user verify the account is created
    And user verify the new account number is generated
