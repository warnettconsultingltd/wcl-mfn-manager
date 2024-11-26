package org.wcl.mfn.integration.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class FileTestUtils {
    private static final ClassLoader CLASSLOADER = FileTestUtils.class.getClassLoader();

    private FileTestUtils() {}

    public static File testResourceFile(final String path) {
//        try {
//            System.out.println(FileUtils.readFileToString(new File(String.valueOf(CLASSLOADER.getResource(path).getFile())), Charset.defaultCharset()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        return new File(Objects.requireNonNull(CLASSLOADER.getResource(path).getFile()));
    }

    public static JsonPath testResourceFileAsJson(final String path) {
        System.out.println(path);

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
