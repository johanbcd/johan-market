package com.johan.market.web.controller;

import com.johan.market.domain.Product;
import com.johan.market.domain.service.ProdutcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProdutcService produtcService;

    public List<Product> getAll(){
        return  produtcService.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return produtcService.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return produtcService.getByCategory( categoryId);
    }
    public Product save (Product product){
        return produtcService.save(product);
    }
    public boolean delete(int productId){
        return produtcService.delete(productId);
    }
}
