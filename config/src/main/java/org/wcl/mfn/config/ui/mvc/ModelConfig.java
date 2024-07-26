package org.wcl.mfn.config.ui.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:ui/mvc/model.properties")
public class ModelConfig {
    @Value("${common.view.attribute.page-title}")
    private String pageTitle;

    public String pageTitle() {
        return pageTitle;
    }
}
