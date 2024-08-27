package org.wcl.mfn.api.testutils;

import io.restassured.config.RestAssuredConfig;
import io.restassured.internal.ResponseParserRegistrar;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.internal.log.LogRepository;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.Argument;
import org.hamcrest.Matcher;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class JsonValidatingMatcher {
    private JsonValidatingMatcher() {}

//    public Matcher matchFullJson(final JsonPath expectedJson) {
//        return equalTo
//    }
//    equalTo(expectedResponseJson.getList(""))

    public static <T> Matcher<Collection<T>> matchFullJsonCollection(final JsonPath expectedResponseJson) {
        return equalTo(expectedResponseJson.getList(""));
    }
}
