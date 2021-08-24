package com.series.reactive.catalogservice.reactive;

import com.series.reactive.catalogservice.dtos.ProductCatalog;
import com.series.reactive.catalogservice.props.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;

@Component
public class ProductCatalogClient {

    @Autowired
    private WebClient catalogWebClient;

    @Autowired
    private ApplicationProperties applicationProperties;

    public Mono<ProductCatalog> createProductInCatalog(ProductCatalog productCatalog) {
        return catalogWebClient.post().contentType(MediaType.APPLICATION_JSON).body(Mono.just(productCatalog), ProductCatalog.class).retrieve()
                .bodyToMono(ProductCatalog.class);
    }

    public Flux<ProductCatalog> getProducts() {
        return catalogWebClient.get().retrieve()
                .bodyToFlux(ProductCatalog.class);
    }

    public Mono<ProductCatalog> getProductsById(String productId) {
        return catalogWebClient.get().uri("/" + productId).retrieve()
                .bodyToMono(ProductCatalog.class);
    }

    public Mono<Void> deleteProductsById(String productId) throws URISyntaxException {
        return catalogWebClient.delete().uri("/" + productId).retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<ProductCatalog> updateProductsById(String productId, ProductCatalog productCatalog) {
        return catalogWebClient.post().uri("/" + productId).contentType(MediaType.APPLICATION_JSON).body(Mono.just(productCatalog), ProductCatalog.class).retrieve()
                .bodyToMono(ProductCatalog.class);
    }
}
