package org.wcl.mfn.api.testutils

import com.fasterxml.jackson.databind.ObjectMapper
import io.restassured.path.json.JsonPath
import java.io.IOException

object JsonTestUtils {
    fun <E> deserializeJson(jsonAsText: JsonPath, clazz: Class<E>?): Collection<E> {
        try {
            val mapper = ObjectMapper()

            return mapper.readValue(
                jsonAsText.prettify(),
                mapper.typeFactory.constructCollectionLikeType(MutableCollection::class.java, clazz)
            )
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}
