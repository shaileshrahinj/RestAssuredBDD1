Feature: No of users


Scenario: Verify user info page

Given Users api
When user calls "usersInfoAPI" with "get" http request and queryParam
Then for update api the API call is successfull with status code 200
And  "data[0].first_name" in response is "Michael"


Scenario: Verify single user info

Given Users api
When user calls "singleuserAPI" with "get" http request
Then for update api the API call is successfull with status code 200
#And  "data.first_name" in response is "Janet"
And verify first_name in reponse maps to "Michael" using "usersInfoAPI"

