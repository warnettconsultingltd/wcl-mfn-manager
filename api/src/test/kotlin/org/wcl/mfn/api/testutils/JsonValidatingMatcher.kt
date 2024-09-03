package org.wcl.mfn.api.testutils

import io.restassured.path.json.JsonPath
import org.hamcrest.*

object JsonValidatingMatcher {
    fun <T> matchFullJsonCollection(expectedResponseJson: JsonPath): Matcher<Collection<T>> {
        return Matchers.equalTo(expectedResponseJson.getList(""))
    }
}
