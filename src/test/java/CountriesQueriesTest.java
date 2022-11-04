import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;


public class CountriesQueriesTest extends Queries {

    Data data = new Data();
    Response res;


    @Test
    public void ValidateIfAllGhanaCountriesHaveIcon(){
        res = ExecuteQuery(data.url, data.queryCountriesGhana);
        LogResponse(res);
        VerifyStatusCode(res, data.successStatusCode);
        assert(res.jsonPath().get(data.jsonPathFirstCountryName).toString().equals(data.expectedNameGhana));
        assertNotNull(res.jsonPath().get(data.jsonPathCountryEmoji));
    }

    @Test
    public void VerifyErrorStatusCode(){
        Response resError = ExecuteQuery(data.url, data.queryCountriesWrong);
        LogResponse(resError);
        VerifyStatusCode(resError, data.errorStatusCode);
    }

}
