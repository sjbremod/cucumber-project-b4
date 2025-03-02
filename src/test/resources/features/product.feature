Feature: product data table practice

  @listOfMap
  Scenario: verify each product price
    # practice List<Map<String, String>>
    Given User is on the HomePage

    Then User should be able to see expected prices in the following products
      | Category | Product           | expectedPrice |
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |

    #List Element 1 (Map)
    # {Catagory=Phone, product=Samsung galaxy s6, expectedPrice=360}


  @listofList @smoke
      # practice List<List<String>>
  Scenario: verify each product price listOfList
    Given User is on the HomePage
    Then  user should be able toi see expected price in teh following products with listOfLists
      | Phones   | Samsung galaxy s6 | 360 |
      | Phones   | Nokia lumia 1520  | 820 |
      | Phones   | Nexus 6           | 650 |
      | Laptops  | Sony vaio i5      | 790 |
      | Laptops  | Sony vaio i7      | 790 |
      | Laptops  | MacBook air       | 700 |
      | Monitors | Apple monitor 24  | 400 |
      | Monitors | ASUS Full HD      | 230 |

  @mapList @smoke
        #practice Map<String,List<String>>
  Scenario: verify students names on discord
    Then user should be able to see the following names in their groups
      | Group 1 | Nadir | Feyruz | Shakir  |
      | Group 2 | Yulia | Roma   | Nazarii |