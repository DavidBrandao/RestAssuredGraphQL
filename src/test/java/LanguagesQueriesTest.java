import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.testng.Assert.assertNull;

public class LanguagesQueriesTest extends Queries {
    Data data = new Data();
    Response res;

    @Test
    public void FilterMustBeEmpty(){
        res = ExecuteQuery(data.url, data.queryLanguagesEmpty);
        LogResponse(res);
        VerifyStatusCode(res, data.successStatusCode);
        assertNull(res.jsonPath().get(data.jsonPathFirstLanguagesCode));
    }

    @Test
    public void FieldRtlShouldBeBoolean(){
        res = ExecuteQuery(data.url, data.queryLanguages);
        LogResponse(res);
        VerifyStatusCode(res, data.successStatusCode);
        res.then().body(data.jsonPathFirstLanguagesRtl, instanceOf(Boolean.class));
    }
}
