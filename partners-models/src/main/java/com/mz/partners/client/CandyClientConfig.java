
package com.mz.partners.client;


import com.mz.partners.api.CandyApi;

import com.mz.core.jersey.ws.client.RestClient;
import com.mz.core.jersey.ws.client.RestClientConfig;
import com.mz.core.jersey.ws.client.impl.ApacheRestClient;
import com.mz.core.jersey.ws.client.proxy.SimpleProxyClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CandyClientConfig {

    @Value("${candy.api.url}")
    private String url;

    @Value("${candy.http.maxConnections:100}")
    private Integer maxConnections;

    @Value("${candy.http.readTimeout:2000}")
    private Integer readTimeout;

    @Value("${candy.http.connectTimeout:1000}")
    private Integer connectTimeout;

    @Value("${candy.request.logging.enabled:true}")
    private Boolean loggingEnabled;

    @Bean
    public RestClient candyHttpRestClient() {
        RestClientConfig config = new RestClientConfig.Builder()
            .name("candy")
            .baseUri(url)
            .maxConnections(maxConnections)
            .connectTimeout(connectTimeout)
            .readTimeout(readTimeout)
            .loggingEnabled(loggingEnabled)
            .build();

        return new ApacheRestClient(config);
    }

    @Bean
    public CandyApi candyRestClient() {
        return SimpleProxyClient.newResource(CandyApi.class, candyHttpRestClient());
    }
}
