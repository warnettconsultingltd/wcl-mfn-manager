package org.wcl.mfn.config.ui.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource({"ui/mvc/view/view.properties"})
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
