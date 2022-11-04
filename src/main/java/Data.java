public class Data {

    String url = "https://countries.trevorblades.com/";

    int successStatusCode = 200;
    int errorStatusCode = 400;

    //----------------------------------- EndPoint Data Continents ----------------------------------- //

    String queryContinents = "{\"query\":\"query{\\r\\n  continents(filter:\\r\\n  {\\r\\n    code:\\r\\n    {\\r\\n      in: [\\\"AF\\\", \\\"EU\\\"]\\r\\n    }\\r\\n  })\\r\\n  {\\r\\n    code\\r\\n    name\\r\\n  }\\r\\n}\",\"variables\":{}}";
    String queryCountriesSouthAmerica = "{\"query\":\"query {\\r\\n    continents(filter:\\r\\n    {\\r\\n        code:\\r\\n        {\\r\\n            in: [\\\"SA\\\"]\\r\\n        }\\r\\n    })\\r\\n    {\\r\\n        code\\r\\n      \\tname\\r\\n      \\tcountries{\\r\\n          code\\r\\n        \\tname\\r\\n        }\\r\\n    }\\r\\n}\",\"variables\":{}}";

    String jsonPathContinentsCode = "data.continents.code";
    String jsonPathCountriesName = "data.countries.name";
    String jsonPathFirstCode = "data.continents[0].code";
    String jsonPathSecondCode = "data.continents[1].code";

    String expectedCodeSouthAmerica = "SA";
    String expectedFirstCode = "AF";
    String expectedSecondCode = "EU";

    //----------------------------------- EndPoint Data Countries ----------------------------------- //

    String queryCountriesWrong = "{\"query\":\"query {\\r\\n    Country{\\r\\n        name\\r\\n        emoji\\r\\n    }\\r\\n}\",\"variables\":{}}";

    String queryCountriesGhana = "{\"query\":\"query country{\\r\\n    country(code:\\\"GH\\\"){\\r\\n    name\\r\\n    continent{\\r\\n        code\\r\\n        name\\r\\n        countries{\\r\\n            name\\r\\n            code\\r\\n            emoji\\r\\n        }\\r\\n    }\\r\\n    }\\r\\n}\",\"variables\":{}}";

    String jsonPathFirstCountryName = "data.country.name";
    String jsonPathCountryEmoji = "data.country.continent.countries.emoji";

    String expectedNameGhana = "Ghana";

    //----------------------------------- EndPoint Data Languages ----------------------------------- //
    String queryLanguagesEmpty = "{\"query\":\"query {\\r\\n    languages(filter:\\r\\n    {\\r\\n        code:\\r\\n        {\\r\\n            in: [\\\"br\\\"]\\r\\n        }\\r\\n    })\\r\\n    {\\r\\n        code\\r\\n        native\\r\\n        rtl\\r\\n    }\\r\\n}\",\"variables\":{}}";
    String queryLanguages = "{\"query\":\"query {\\r\\n    languages\\r\\n    {\\r\\n        name\\r\\n        code\\r\\n        rtl\\r\\n    }\\r\\n}\",\"variables\":{}}";

    String jsonPathFirstLanguagesRtl = "data.languages[0].rtl";
    String jsonPathFirstLanguagesCode = "data.languages[0].code";
}
