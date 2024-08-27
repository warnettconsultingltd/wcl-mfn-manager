package org.wcl.mfn.api.testutils;

public class URIFactory {
    private static final String BASE_URL = "http://localhost:%d%s";
    private static final int DEFAULT_PORT = 8080;

    private URIFactory() {}

    public static String testURI(final int port, final String endpoint) {
        return String.format(BASE_URL, port, endpoint);
    }

    public static String testURI(final String endpoint) {
        return testURI(DEFAULT_PORT, endpoint);
    }
}
