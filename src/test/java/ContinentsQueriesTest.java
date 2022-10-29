import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class ContinentsQueriesTest extends Queries {

    Data data = new Data();
    Response res;

    @BeforeTest
    public void ExecuteQueryBeforeTests(){
        res = ExecuteQuery(data.url, data.queryContinents);
        LogResponse(res);
    }

    @Test
    public void ShouldReturnStatusCode200(){
        VerifyStatusCode(res, data.successStatusCode);
    }

    @Test
    public void FirstCodeShouldBeAF(){
        res.then().body(data.jsonPathFirstCode, equalTo(data.expectedFirstCode));
    }

    @Test
    public void FirstNameShouldBeAfrica(){
        res.then().body(data.jsonPathFirstName, equalTo(data.expectedFirstName));
    }

    @Test
    public void FirstCodeShouldBeEU(){
        res.then().body(data.jsonPathSecondCode, equalTo(data.expectedSecondCode));
    }

    @Test
    public void FirstNameShouldBeEurope(){
        res.then().body(data.jsonPathSecondName, equalTo(data.expectedSecondName));
    }

    @Test
    public void FirstCodeShouldBeString(){
        res.then().body(data.jsonPathFirstCode, instanceOf(String.class));
    }

    @Test
    public void FirstCodeShouldBeAFValidationWithAssert(){
        assert(res.jsonPath().get(data.jsonPathFirstCode).toString().equals(data.expectedFirstCode));
    }

    @Test
    public void FirstNameShouldBeAFValidationWithAssert(){
        assert(res.jsonPath().get(data.jsonPathFirstName).toString().equals(data.expectedFirstName));
    }

    @Test
    public void VerifyErrorStatusCode(){
        Response resError = ExecuteQuery(data.url, data.queryContinentsWrong);
        LogResponse(resError);
        VerifyStatusCode(resError, data.errorStatusCode);
    }
}
