Feature: Searching by Product Name

In order to find items that I would like to purchase
As a potential buyer
I want to be able to search for items containing certain words

  Scenario: Should list items related to a specified productName
    Given I want to buy 'hat'
    When I search for items containing 'hat'
    Then I should only see items related to 'hat'

  Scenario Outline: Should list items related to a specified productName.
    Given I want to buy a <productName>
    When I search for items containing <productName>
    Then I should only see items related to <productName>

    Examples:
    |productName |
    |godzilla|
    |Tablet  |
    |Guitar  |

