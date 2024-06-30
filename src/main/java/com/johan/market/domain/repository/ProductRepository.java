package com.johan.market.domain.repository;

import com.johan.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Optional <List<Product>> getByIdCatagoryOrderByNamaASC(int categoryId);
    Product save(Product product);
    void delete(int productId);



}
