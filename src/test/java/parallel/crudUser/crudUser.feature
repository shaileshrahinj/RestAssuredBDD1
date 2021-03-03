Feature: Validating user CRUD operations

@usersInfoAPI
Scenario Outline: Verify if user is successfully added using usersInfoAPI
   Given users info Payload with "<name>" "<job>"
   When user calls "usersInfoAPI" with "post" http request
   Then the API call is successfull with status code 201
   And "name" in response is "<name>"
   And "job" in response is "<job>"
    
    #to make things data driven
    Examples:
  |name  | job     |
  |ramiz | hindi   |
  |Bhouse| espinol | 

@deleteUserAPI
Scenario: Verify if delete user api is working

Given Users api
When user calls "deleteUserAPI" with "delete" http request
Then for delete api the API call is successfull with status code 204

@UpdateUserAPI
Scenario Outline: Verify if user is successfully Updated using usersInfoAPI
    Given users update Payload with "<name>" "<job>"
    When user calls "UpdateUserAPI" with "update" http request
    Then for update api the API call is successfull with status code 202
    And "name" in response is "<name>"
    And "job" in response is "<job>"
    
 Examples: 
  |name  | job            |
  |ramiz | hindiTeacher   |
  |Bhouse| espinolTeacher |
 