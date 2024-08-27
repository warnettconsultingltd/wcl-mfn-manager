package org.wcl.mfn.api.testutils;

import io.restassured.path.json.JsonPath;
import org.hamcrest.Matcher;

import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;

public class JsonValidatingMatcher {
    private JsonValidatingMatcher() {}

    public static <T> Matcher<Collection<T>> matchFullJsonCollection(final JsonPath expectedResponseJson) {
        return equalTo(expectedResponseJson.getList(""));
    }
}
