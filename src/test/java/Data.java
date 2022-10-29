public class Data {

    String url = "https://countries.trevorblades.com/";

    String queryContinents = "{\"query\":\"query{\\r\\n  continents(filter:\\r\\n  {\\r\\n    code:\\r\\n    {\\r\\n      in: [\\\"AF\\\", \\\"EU\\\"]\\r\\n    }\\r\\n  })\\r\\n  {\\r\\n    code\\r\\n    name\\r\\n  }\\r\\n}\",\"variables\":{}}";
    String queryContinentsWrong = "{\"query\":\"quey{\\r\\n  continents(filter:\\r\\n  {\\r\\n    code:\\r\\n    {\\r\\n      in: [\\\"AF\\\", \\\"EU\\\"]\\r\\n    }\\r\\n  })\\r\\n  {\\r\\n    code\\r\\n    name\\r\\n  }\\r\\n}\",\"variables\":{}}";

    int successStatusCode = 200;
    int errorStatusCode = 400;

    String jsonPathFirstCode = "data.continents[0].code";
    String jsonPathFirstName = "data.continents[0].name";
    String expectedFirstCode = "AF";
    String expectedFirstName = "Africa";

    String jsonPathSecondCode = "data.continents[1].code";
    String jsonPathSecondName = "data.continents[1].name";
    String expectedSecondCode = "EU";
    String expectedSecondName = "Europe";
}
