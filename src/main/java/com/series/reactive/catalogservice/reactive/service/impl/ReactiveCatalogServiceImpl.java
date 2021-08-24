package com.series.reactive.catalogservice.reactive.service.impl;

import com.series.reactive.catalogservice.dtos.ProductCatalog;
import com.series.reactive.catalogservice.reactive.ProductCatalogClient;
import com.series.reactive.catalogservice.reactive.service.ReactiveCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;

@Service("ReactiveCatalogService")
public class ReactiveCatalogServiceImpl implements ReactiveCatalogService {

    public static Logger LOGGER = LoggerFactory.getLogger(ReactiveCatalogServiceImpl.class);

    @Autowired
    private ProductCatalogClient productCatalogClient;

    @Override
    public Mono<ProductCatalog> createProductInCatalog(ProductCatalog productCatalog) {
        return productCatalogClient.createProductInCatalog(productCatalog);
    }

    @Override
    public Flux<ProductCatalog> getProducts() {
        return productCatalogClient.getProducts();
    }

    @Override
    public Mono<ProductCatalog> getProductsById(String productId) {
        return productCatalogClient.getProductsById(productId);
    }

    @Override
    public Mono<Void> deleteProductsById(String productId) throws URISyntaxException {
        return productCatalogClient.deleteProductsById(productId);
    }

    @Override
    public Mono<ProductCatalog> updateProductsById(String productId, ProductCatalog productCatalog) {
        return productCatalogClient.updateProductsById(productId, productCatalog);
    }
}
