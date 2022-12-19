Feature: Bill Pay
Scenario: Verify that the Balance and transaction table details are correct in each of the accounts

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
    #sleep
    And user verify the new account number is generated
    
    #user opens a "CHECKING" account
    Given user navigates to account opening section
    When user selects account type as "CHECKING"
    And user select an existing account to transfer fund into new account
    And user proceed for account opening 
    Then user verify the account is created
    And user verify the new account number is generated
    
    #user proceeds for fund transfer (Bill Payment)
    Given user navigates to bill payment section
    When user finds the bill payment page is open
    Then user fill the form with required details
    |Payee Name|Address|City|State|Zip Code|Phone|Amount|
    |Raj|Ds colony|Dhanbad|Jharkhand|826001|7004027535|50.00|
    
    And user selects created "CHECKING" account to receive payment
    And user selects created "SAVINGS" account to disburse payment
    
    #user confirms the payment and verify transaction details for credit account
    Given user confirms the payment
    And bill payment is successful 
    And user navigates to account overwiew section
    When user navigates to "CHECKING" account which is credited 
    Then user verify the transaction - "credit" details
    |Amount|
    |50.00|
    
    #user verify transaction details for debit account
    Given user navigates to account overwiew section
    When user navigates to "SAVINGS" account which is debit
    Then user verify the transaction - "debit" details
    |Amount|
    |50.00|