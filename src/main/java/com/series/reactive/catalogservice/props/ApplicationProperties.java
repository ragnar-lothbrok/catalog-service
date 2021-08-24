package com.series.reactive.catalogservice.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("com.series.reactive.catalogservice")
public class ApplicationProperties {

    private String catalogEndpoint;

    private Integer timeout;

    public String getCatalogEndpoint() {
        return catalogEndpoint;
    }

    public void setCatalogEndpoint(String catalogEndpoint) {
        this.catalogEndpoint = catalogEndpoint;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
