package org.wcl.mfn.ui.config.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:ui/mvc/view.properties")
public class ViewConfig {
    @Value("${view.home}")
    private String homeView;

    @Value("${view.tools.contract-calculator}")
    private String contractCalculatorView;

    public String homeView() {
        return homeView;
    }

    public String contractCalculatorView() {
        return contractCalculatorView;
    }
}