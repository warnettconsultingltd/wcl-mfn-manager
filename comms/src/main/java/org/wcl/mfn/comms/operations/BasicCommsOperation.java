package org.wcl.mfn.comms.operations;

import org.springframework.web.client.RestTemplate;

public abstract class BasicCommsOperation<T> {
    private final RestTemplate template;

    BasicCommsOperation(RestTemplate template) {
        this.template = template;
    }

    public T performGet(String url) {
        return convert(template.getForObject(url,String.class));
    }

    protected abstract T convert(String htmlText);

}