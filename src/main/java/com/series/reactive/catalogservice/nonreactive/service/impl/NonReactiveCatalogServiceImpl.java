package com.series.reactive.catalogservice.nonreactive.service.impl;

import com.series.reactive.catalogservice.dtos.ProductCatalog;
import com.series.reactive.catalogservice.nonreactive.service.NonReactiveCatalogService;
import com.series.reactive.catalogservice.props.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service("NonReactiveCatalogService")
public class NonReactiveCatalogServiceImpl implements NonReactiveCatalogService {

    Logger LOGGER = LoggerFactory.getLogger(NonReactiveCatalogServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public ProductCatalog createProductInCatalog(ProductCatalog productCatalog) {
        HttpEntity httpEntity = new HttpEntity(productCatalog);
        return restTemplate.postForObject(applicationProperties.getCatalogEndpoint(), httpEntity, ProductCatalog.class);
    }

    public List<ProductCatalog> getProducts() {
        List<ProductCatalog> productCatalogList = new ArrayList<>();
        return restTemplate.getForEntity(applicationProperties.getCatalogEndpoint(), productCatalogList.getClass()).getBody();
    }

    @Override
    public ProductCatalog getProductsById(String productId) {
        return restTemplate.getForEntity(applicationProperties.getCatalogEndpoint() + "/" + productId, ProductCatalog.class).getBody();
    }

    @Override
    public void deleteProductsById(String productId) throws URISyntaxException {
        restTemplate.delete(new URI(applicationProperties.getCatalogEndpoint() + "/" + productId));
    }

    @Override
    public ProductCatalog updateProductsById(String productId, ProductCatalog productCatalog) {
        HttpEntity httpEntity = new HttpEntity(productCatalog);
        return restTemplate.postForObject(applicationProperties.getCatalogEndpoint() + "/" + productId, httpEntity, ProductCatalog.class);
    }
}
