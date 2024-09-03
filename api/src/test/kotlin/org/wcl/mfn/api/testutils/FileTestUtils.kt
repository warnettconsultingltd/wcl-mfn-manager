package org.wcl.mfn.api.testutils

import com.fasterxml.jackson.databind.ObjectMapper
import io.restassured.path.json.JsonPath
import org.apache.commons.io.FileUtils
import java.io.*
import java.util.*

object FileTestUtils {
    private val CLASSLOADER: ClassLoader = FileTestUtils::class.java.classLoader

    fun testResourceFile(path: String?): File {
        return File(Objects.requireNonNull(CLASSLOADER.getResource(path)).file)
    }

    fun testResourceFileAsJson(path: String?): JsonPath {
        return JsonPath(testResourceFile(path))
    }

    fun <E> testResourceFileAsDeserialisedCollection(path: String?, clazz: Class<E>?): Collection<E> {
        val file = testResourceFile(path)
        try {
            val data = FileUtils.readFileToString(file, "UTF-8")
            val mapper = ObjectMapper()

            return mapper.readValue(
                data,
                mapper.typeFactory.constructCollectionLikeType(MutableCollection::class.java, clazz)
            )
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}
