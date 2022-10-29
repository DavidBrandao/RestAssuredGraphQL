import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Queries {

    public Response ExecuteQuery(String URL, String query){
        return given().header("Content-Type", "application/json").
               and().body(query).
               when().post(URL);
    }

    public void VerifyStatusCode(Response response, int statusCode){
        response.then().statusCode(statusCode);
    }

    public void LogResponse(Response response){
        response.then().log().body();
    }
}
