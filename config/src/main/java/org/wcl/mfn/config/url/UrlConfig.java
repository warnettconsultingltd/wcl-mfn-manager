package org.wcl.mfn.config.url;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:url/url.properties")
public class UrlConfig {
    @Value("${url.home}")
    private String homeUrl;

    @Value("${url.tools.contract-calculator}")
    private String contractCalculatorUrl;

    public String homeUrl() {
        return homeUrl;
    }

    public String contractCalculatorUrl() {
        return contractCalculatorUrl;
    }
}
