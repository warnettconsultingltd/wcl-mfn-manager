package org.wcl.mfn.ui.integration.selenium.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-test.properties")
public class HtmlAttributes {
    private final String link;

    public HtmlAttributes(@Value("${attribute.link}") String link) {
        this.link = link;
    }

    public String link() {
        return link;
    }
}
