package org.wcl.mfn.api.testutils

object URIFactory {
    private const val BASE_URL = "http://localhost:%d%s"
    private const val DEFAULT_PORT = 8080

    fun testURI(port: Int, endpoint: String?): String {
        return String.format(BASE_URL, port, endpoint)
    }

    fun testURI(endpoint: String?): String {
        return testURI(DEFAULT_PORT, endpoint)
    }
}
