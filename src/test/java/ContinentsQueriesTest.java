import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class ContinentsQueriesTest extends Queries {

    Data data = new Data();
    Response res;

    @Test
    public void ShouldReturnStatusCode200(){
        res = ExecuteQuery(data.url, data.queryContinents);
        LogResponse(res);
        VerifyStatusCode(res, data.successStatusCode);
        res.then().body(data.jsonPathFirstCode, equalTo(data.expectedFirstCode));
        res.then().body(data.jsonPathSecondCode, equalTo(data.expectedSecondCode));
    }

    @Test
    public void MustReturnMoreThanOneCountryName(){
        res = ExecuteQuery(data.url, data.queryCountriesSouthAmerica);
        LogResponse(res);
        VerifyStatusCode(res, data.successStatusCode);
        res.then().body(data.jsonPathContinentsCode, contains(data.expectedCodeSouthAmerica));
        assertTrue(data.jsonPathCountriesName.length() > 0);
    }
}
