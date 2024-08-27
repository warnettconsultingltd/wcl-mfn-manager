package org.wcl.mfn.api.testutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.util.Collection;

public class JsonTestUtils {
    private JsonTestUtils() {}

    public static <E> Collection<E> deserializeJson(final JsonPath jsonAsText, final Class<E> clazz) {
        try {

            final var mapper = new ObjectMapper();

            return mapper.readValue(jsonAsText.prettify(),
                    mapper.getTypeFactory().constructCollectionLikeType(Collection.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
