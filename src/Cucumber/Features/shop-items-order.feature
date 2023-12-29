@shop
Feature: User order an item

  @task2
  Scenario Outline: User order an item
    Given I'm on the shop authentication page
    When I login using <login> and <passwd>
    And I go to clothes page
    And I can see there is no items in the cart
    And I select new item
    And I check if the discount is equal to <discount>
    And I enter select <size>
    And I enter <quantity>
    And I check if the <size> is corret
    And I click add to cart
    And I click Proceed to checkout
    And I click Proceed on Shopping Cart page
    And I click Confirm Address
    And I select shipping method
    And I select payment method
    And I check conditions to approve
    And I click place order button
    Then I Take a Screenshot
    And I close the browser

    Examples:
      | login             | passwd          | discount | size | quantity |
      | "jakub@gmail.com" | "admin1234!@#$" | "20%"    | "S"  | "5"      |