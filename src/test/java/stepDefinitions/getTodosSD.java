package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class getTodosSD {

    private RequestSpecification request;
    private Response response;

    //HappyPath
    @Given("the API is accessible and running")
    public void the_API_is_accessible_and_running(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todo";
        request = given();
    }


    @When("i send a GET request to {string}")
    public void i_send_a_get_request_to(String endPoint) {
        response = request.when().get(endPoint);

    }

    @Then("the response status code should be {int}")
    public void responseCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("the response should contain expected data")
    public void responseShouldContainData() {
        response.then().body("data", notNullValue());
    }

    //InvalidParameter
    @When("i send a GET request to \"{string}\"")
    public void i_send_a_GET_request_to_api_todos_invalidParam_value(String url) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todos";
        Response response = RestAssured.given().get(url);
        // Store the response for later assertions
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be_400(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @And("the response should contain error message \"Invalid parameters\"")
    public void the_response_should_contain_error_message_Invalid_parameters() {
        String errorMessage = response.getBody().asString();
        Assert.assertTrue(errorMessage.contains("Invalid parameters"));
    }
}
