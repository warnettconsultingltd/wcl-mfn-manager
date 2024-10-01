package org.wcl.mfn.ui.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["org.wcl.mfn"])
@EnableWebMvc
open class MFNHelperApplication
    fun main(args: Array<String>) {
        runApplication<MFNHelperApplication>(*args)
    }
