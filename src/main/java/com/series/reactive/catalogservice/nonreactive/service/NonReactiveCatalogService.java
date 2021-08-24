package com.series.reactive.catalogservice.nonreactive.service;

import com.series.reactive.catalogservice.dtos.ProductCatalog;

import java.net.URISyntaxException;
import java.util.List;

public interface NonReactiveCatalogService {

    ProductCatalog createProductInCatalog(ProductCatalog productCatalog);

    List<ProductCatalog> getProducts();

    ProductCatalog getProductsById(String productId);

    void deleteProductsById(String productId) throws URISyntaxException;

    ProductCatalog updateProductsById(String productId, ProductCatalog productCatalog);

}
