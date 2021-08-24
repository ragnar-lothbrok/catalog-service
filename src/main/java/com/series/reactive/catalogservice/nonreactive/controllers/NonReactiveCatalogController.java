package com.series.reactive.catalogservice.nonreactive.controllers;

import com.series.reactive.catalogservice.dtos.ProductCatalog;
import com.series.reactive.catalogservice.nonreactive.service.NonReactiveCatalogService;
import com.series.reactive.catalogservice.reactive.service.ReactiveCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/nonreactive/catalog")
public class NonReactiveCatalogController {

    @Autowired
    private NonReactiveCatalogService nonReactiveCatalogService;

    @Autowired
    private ReactiveCatalogService reactiveCatalogService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductCatalog createProductInCatalog(@RequestBody ProductCatalog productCatalog) {
        return nonReactiveCatalogService.createProductInCatalog(productCatalog);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductCatalog> getProducts() {
        return nonReactiveCatalogService.getProducts();
    }

    @GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductCatalog getProductsById(@PathVariable String productId) {
        return nonReactiveCatalogService.getProductsById(productId);
    }

    @DeleteMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProductsById(@PathVariable String productId) throws URISyntaxException {
        nonReactiveCatalogService.deleteProductsById(productId);
    }

    @PutMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductCatalog updateProductsById(@PathVariable String productId, @RequestBody ProductCatalog productCatalog) {
        return nonReactiveCatalogService.updateProductsById(productId, productCatalog);
    }
}
