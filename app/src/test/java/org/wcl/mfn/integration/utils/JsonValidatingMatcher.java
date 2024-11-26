package org.wcl.mfn.integration.utils;

import com.thoughtworks.xstream.core.JVM;
import io.restassured.path.json.JsonPath;
import org.hamcrest.*;

import java.util.Collection;

public class JsonValidatingMatcher {
    private JsonValidatingMatcher() {}

    public static Matcher<Collection<String>> matchFullJsonCollection(final JsonPath expectedJson) {
        return Matchers.equalTo(expectedJson.getList(""));
    }
}
//
//
//import io.restassured.path.json.JsonPath
//import org.hamcrest.*
//
//object JsonValidatingMatcher {
//fun <T> matchFullJsonCollection(expectedResponseJson: JsonPath): Matcher<Collection<T>> {
//        return Matchers.equalTo(expectedResponseJson.getList(""))
//        }
//        }