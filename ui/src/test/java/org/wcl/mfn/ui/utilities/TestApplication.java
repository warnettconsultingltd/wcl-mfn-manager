package org.wcl.mfn.ui.utilities;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages = "org.wcl.mfn")
@EnableWebMvc
public class TestApplication {

    public static void main(String... args) {
        SpringApplication.run(TestApplication.class, args);
    }
}