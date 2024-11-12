package org.wcl.mfn.api.testutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Objects;

public class FileTestUtils {
    private static final ClassLoader CLASSLOADER = FileTestUtils.class.getClassLoader();

    private FileTestUtils(){}

    public static File testResourceFile(final String path) {
        return new File(String.valueOf(Objects.requireNonNull(CLASSLOADER.getResource(path))));
    }


    public static String testResourceFileAsString(final String path) throws IOException {
        return IOUtils.resourceToString(path, Charset.defaultCharset(), FileTestUtils.CLASSLOADER);
    }

    public static JsonPath testResourceFileAsJson(final String path) {
        return new JsonPath(testResourceFile(path));
    }

    public static <E> Collection<E> testResourceFileAsDeserialisedCollection(String path, Class<E> clazz) {
        final var file = testResourceFile(path);
        try {
            final var data = FileUtils.readFileToString(file, "UTF-8");
            final var mapper = new ObjectMapper();

            return mapper.readValue(
                    data,
                    mapper.getTypeFactory().constructCollectionLikeType(Collection.class, clazz));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
