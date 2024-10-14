Feature: API Regression Testing for GET Request

  Background:
    Given the API is accessible and running

  @HappyPath
  Scenario: Verify successful response of the GET request
    When i send a GET request to "/api/todos"
    Then the response status code should be 200
    And the response should contain expected data

  @InvalidParameter
  Scenario: Verify GET request with missing/invalid parameters
    When i send a GET request to "/api/todos?invalidParam=value"
    Then the response status code should be 400
    And the response should contain error message "Invalid parameters"
#
#  @UnauthorizedAccess
#  Scenario: Verify GET request with unauthorized access
#    When I send a GET request to "/api/secureData" without authorization
#    Then the response status code should be 401
#    And the response should contain error message "Unauthorized access"
#
#  @ResourceNotFound
#  Scenario: Verify GET request for a resource that doesn’t exist
#    When I send a GET request to "/api/users/99999"
#    Then the response status code should be 404
#    And the response should contain error message "Not Found"
#
#  @Performance
#  Scenario: Verify response time for GET request
#    When I send a GET request to "/api/users"
#    Then the response time should be less than 500 ms
#
#  @ResponseStructure
#  Scenario: Verify response structure for GET request
#    When I send a GET request to "/api/users"
#    Then the response should match the expected JSON schema
#
#  @Pagination
#  Scenario: Verify GET request for large dataset and pagination
#    When I send a GET request to "/api/users?page=2&limit=50"
#    Then the response status code should be 200
#    And the response should return 50 users in the list
#
#  @QueryParameters
#  Scenario: Verify GET request with filters or query parameters
#    When I send a GET request to "/api/users?status=active"
#    Then the response should contain only active users
#
#  @Headers
#  Scenario: Verify headers in response
#    When I send a GET request to "/api/users"
#    Then the response header "Content-Type" should be "application/json"
#    And the response header "Cache-Control" should not be null
#
#  @Concurrency
#  Scenario: Verify API with concurrency
#    When I send 10 concurrent GET requests to "/api/users"
#    Then all responses should return status code 200
