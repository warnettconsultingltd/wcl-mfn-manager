package org.wcl.mfn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "org.wcl.mfn")
@EnableWebMvc
public class MFNHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MFNHelperApplication.class, args);
    }
}