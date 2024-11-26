package org.wcl.mfn.integration.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class JsonTestUtils {
    private JsonTestUtils(){}

    public static <E> Collection<E> deserializeJsonAsList(final JsonPath jsonAsText, Class<E> clazz) {
        try {
            final var mapper = new ObjectMapper();

            return mapper.readValue(
                    jsonAsText.prettify(),
                    mapper.getTypeFactory().constructCollectionLikeType(Collection.class, clazz));

        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}

