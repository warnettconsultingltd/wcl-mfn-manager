package org.wcl.mfn.ui.utilities

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["org.wcl.mfn"])
@EnableWebMvc
open class TestApplication
    fun main(args: Array<String>) {
        runApplication<TestApplication>(*args)
    }