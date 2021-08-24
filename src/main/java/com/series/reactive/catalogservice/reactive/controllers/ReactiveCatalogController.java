package com.series.reactive.catalogservice.reactive.controllers;

import com.series.reactive.catalogservice.dtos.ProductCatalog;
import com.series.reactive.catalogservice.reactive.service.ReactiveCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/reactive/catalog")
public class ReactiveCatalogController {

    @Autowired
    private ReactiveCatalogService reactiveCatalogService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductCatalog> createProductInCatalog(@RequestBody ProductCatalog productCatalog) {
        return reactiveCatalogService.createProductInCatalog(productCatalog);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductCatalog> getProducts() {
        return reactiveCatalogService.getProducts();
    }

    @GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductCatalog> getProductsById(@PathVariable String productId) {
        return reactiveCatalogService.getProductsById(productId);
    }

    @DeleteMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> deleteProductsById(@PathVariable String productId) throws URISyntaxException {
        return reactiveCatalogService.deleteProductsById(productId);
    }

    @PutMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductCatalog> updateProductsById(@PathVariable String productId, @RequestBody ProductCatalog productCatalog) {
        return reactiveCatalogService.updateProductsById(productId, productCatalog);
    }
}
