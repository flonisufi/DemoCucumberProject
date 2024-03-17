@Test
  @end2end

  Feature: End to End Test

    Background:
      Given When user is on the Demo Blaze Page

    Scenario: Validate that Categories option work on Dashboard
      When User click a Categories option on Dashboard
      Then Validate that Categories option work

      Scenario: Add to Cart a Phone and a Laptop and Place Order
        When User click on a Phone and Add to Cart
        When User back Home and Click on A Laptop and Add to Cart
        When User click on Cart and Place Order
        When User enter all personal informations and Purchase
        | Element     | Information |
        | Name        | ******      |
        | Country     | ******      |
        | City        | ******      |
        | Credit Cart | Teb         |
        | Month       | May         |
        | Year        | 2024        |
        Then Validate that the order has been sent successfully

        Scenario: Delete an item from Cart
          When User click on a Phone and Add to Cart
          When User click on Cart
          When User delete the item from Cart and Place Order
          When User enter all personal informations and Purchase
            | Element     | Information |
            | Name        | ******      |
            | Country     | ******      |
            | City        | ******      |
            | Credit Cart | Teb         |
            | Month       | May         |
            | Year        | 2024        |
          Then Validate that item is deleted

          Scenario: Validate Calculations when you add multiple products on Cart work
            When User click on a Phone and Add to Cart
            When User back Home and Click on A Laptop and Add to Cart
            When User click on Cart
            When User grab the prices of Products
            Then User validate that Calculations of prices are the same as Total price

            Scenario: Verify Price shown on Dashboard is same as when you open the product
              When User grab the price of a Product on Dashboard
              When User click on that Product
              Then User validate that the price is same on Dashboard and inside the product

              Scenario: Send a Message
                When User click on Contact
                When User enter email "valid" and name "valid"
                When User send a message "message" and Submit the message
                Then User validate the message has been sent




