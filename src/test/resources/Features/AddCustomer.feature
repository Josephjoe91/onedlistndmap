Feature: Add Customer in demo site

  Scenario: Add Customer with hard coded datas
    Given user launches demo telecom site
    And user clicks on add customer button
    When user enters all the fields
    And user clicks on the submit button
    Then user should be displayed customer ID is generated or not

  Scenario: Add Customer with hard coded datas
    Given user launches demo telecom site
    And user clicks on add customer button
    When user enters all the fields with one dimensional 
      | josef | joe | joesmith@gmail.com | tambaram | 3484833939 |
    And user clicks on the submit button
    Then user should be displayed customer ID is generated or not

 
 Scenario: Add Customer with hard coded datas
    Given user launches demo telecom site
    And user clicks on add customer button
    When user enters all the fields with one dimensional map
      | Fname   | josef              |
      | Lname   | joe                |
      | Email   | joesmith@gmail.com |
      | Address | tambaram           |
      | phno    |         3484833939 |
    And user clicks on the submit button
    Then user should be displayed customer ID is generated or not