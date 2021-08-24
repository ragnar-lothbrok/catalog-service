package com.series.reactive.catalogservice.reactive.service;

import com.series.reactive.catalogservice.dtos.ProductCatalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;

public interface ReactiveCatalogService {

    Mono<ProductCatalog> createProductInCatalog(ProductCatalog productCatalog);

    Flux<ProductCatalog> getProducts();

    Mono<ProductCatalog> getProductsById(String productId);

    Mono<Void> deleteProductsById(String productId) throws URISyntaxException;

    Mono<ProductCatalog> updateProductsById(String productId, ProductCatalog productCatalog);

}
