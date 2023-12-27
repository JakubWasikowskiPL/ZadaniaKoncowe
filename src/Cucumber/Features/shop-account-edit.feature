@shop
Feature: User account edit

  @task1
  Scenario Outline: User adds first address to the account
    Given I'm on the shop authentication page
    When I login using <login> and <passwd>
    And I go to my addresses page
    Then I can see there is no addresses
    When I add new address
    And I enter new address <alias>,<address>,<city>,<postalCode>,<country>,<phoneNumber>
    Then I can see new address
    And I verify created address <alias>,<address>,<city>,<postalCode>,<country>,<phoneNumber>
    And I remove the address
    And I close the browser
    Examples:
      | login             | passwd          | alias    | address     | city     | postalCode | phoneNumber | country          |
      | "jakub@gmail.com" | "admin1234!@#$" | "Home"   | "Street 32" | "City"   | "62-400"   | "123456789" | "United Kingdom" |
      | "jakub@gmail.com" | "admin1234!@#$" | "Office" | "XYZ 12"    | "Geneva" | "55-321"   | "123456789" | "United Kingdom" |
