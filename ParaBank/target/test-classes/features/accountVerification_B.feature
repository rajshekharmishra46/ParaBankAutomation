Feature: Account details verification
Scenario:  Verification of the account details page for both the new accounts created

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
    
     #user verify the "SAVINGS" account details
     Given user navigates to created account details page
     When user finds the created account details page is open
     Then user verify account number
     And user verify account type as "SAVINGS"
     And user verify the balance in the account
     And user verify the available amount in the account  
     
     #user opens a "CHECKING" account
    Given user navigates to account opening section
    When user selects account type as "CHECKING"
    And user select an existing account to transfer fund into new account
    And user proceed for account opening 
    Then user verify the account is created
    And user verify the new account number is generated
    
    #user verify the "CHECKING" account details
     Given user navigates to created account details page
     When user finds the created account details page is open
     Then user verify account number
     And user verify account type as "CHECKING"
     And user verify the balance in the account
     And user verify the available amount in the account 