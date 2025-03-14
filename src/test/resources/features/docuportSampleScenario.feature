Feature: Docuport Sample Scenario

  @sampleDocuport @hw
  Scenario: Practice click buttons on different pages as a client
    Given user is on Docuport login page
    When user inserts "b1g1_client@gmail.com" to "username" field on "Login" page
    When user inserts "Group1" to "password" field on "Login" page
    And user clicks "login" button on "Login" page
    And user clicks "continue" button on "Choose account" page
    Then user should be able to see the home for client
    And user clicks "Received Doc" button on "Left Navigate" page
    And user clicks "Search" button on "Received Doc" page
    And user inserts "tax document" to "Document name" field on "Received Doc" page
    And user clicks "Tags" button on "Received Doc" page
    And user inserts "License" to "Tags" field on "Received Doc" page
    And user clicks "Upload date" button on "Received Doc" page
    And user inserts "7" to "Uploaded by" field on "Received Doc" page
    And user clicks "Uploaded by" button on "Received Doc" page
    And user inserts "Advisor No lastname" to "Uploaded by" field on "Received Doc" page
    And user clicks "search2" button on "Received Doc" page
    And user should see "Your search returned no results. Make sure you search properly" message "Received Doc" page

  And user clicks "My uploads" button on "Left Navigate" page
  And user clicks "Upload documents" button on "My uploads" page
    #if input type works you do not need below step
    And user clicks "Upload file" button on "My uploads" page
  And user uploads document

#  And user inserts "C:\Users\udasc\Desktop\testUpload.txt" to "upload file" field on "My uploads" page
#  And user clicks "Upload" button on "My uploads" page
#  Then user clicks "Search" button on "My uploads" page
#  And user should see "There are no items to display" message "My upload" page
  #    validate message - There are no items to display