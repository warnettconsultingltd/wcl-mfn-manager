package org.wcl.mfn.api.testutils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.apache.commons.io.FileUtils;
import org.wcl.mfn.entities.contract.calculator.SuggestedContract;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class FileTestUtils {
    private static final ClassLoader CLASSLOADER = FileTestUtils.class.getClassLoader();

    private FileTestUtils() {}

    public static File testResourceFile(final String path) {
        return new File(Objects.requireNonNull(CLASSLOADER.getResource(path)).getFile());
    }

    public static JsonPath testResourceFileAsJson(final String path) {
        return new JsonPath(testResourceFile(path));
    }

    public static <E> Collection<E> testResourceFileAsDeserialisedCollection(final String path, final Class<E> clazz) {
        final var file = testResourceFile(path);
        try {
            final String data = FileUtils.readFileToString(file, "UTF-8");
            final var mapper = new ObjectMapper();

            return mapper.readValue(data,
                                    mapper.getTypeFactory().constructCollectionLikeType(Collection.class,clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
