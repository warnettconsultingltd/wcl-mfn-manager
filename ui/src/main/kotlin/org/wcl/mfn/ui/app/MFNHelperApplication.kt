package org.wcl.mfn.ui.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication(scanBasePackages = ["org.wcl.mfn"])
@EnableWebMvc
open class MFNHelperApplication {
    fun main(args: Array<String>) {
        SpringApplication.run(MFNHelperApplication::class.java, *args)
    }
}