package com.fanyfahmi.idraggregator.config;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;


@Component
public class ExternalClientFactory implements FactoryBean<WebClient> {

    @Value("${frankfurter.api.base-url}")
    private String baseUrl;

    @Override
    public WebClient getObject() throws Exception {

        try {
            SslContext sslContext = SslContextBuilder
                    .forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .build();

            HttpClient httpClient = HttpClient.create()
                    .followRedirect(true)
                    .resolver(io.netty.resolver.DefaultAddressResolverGroup.INSTANCE)
                    .secure(t -> t.sslContext(sslContext))
                    .compress(true);

            return WebClient.builder()
                    .clientConnector(new ReactorClientHttpConnector(httpClient))
                    .baseUrl(baseUrl)
                    .build();
        } catch (SSLException e) {

            System.err.println("Gagal menginisialisasi SSL Context: " + e.getMessage());
            return WebClient.builder().baseUrl(baseUrl).build();
        }
    }

    @Override
    public Class<?> getObjectType() {
        return WebClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
