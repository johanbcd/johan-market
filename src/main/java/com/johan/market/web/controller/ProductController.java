package com.johan.market.web.controller;

import com.johan.market.domain.Product;
import com.johan.market.domain.service.ProdutcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProdutcService produtcService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return  new ResponseEntity<>(produtcService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer productId){
        return produtcService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") Integer categoryId){
        List<Product> products = produtcService.getByCategory(categoryId).orElse(null);

        return products != null && !products.isEmpty() ?
                new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/save")
    public ResponseEntity<Product> save (@RequestBody Product product){
        return new ResponseEntity<>(produtcService.save(product), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer productId){
        if (produtcService.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
