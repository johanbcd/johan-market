package com.johan.market.persistence;

import com.johan.market.domain.Product;
import com.johan.market.domain.repository.ProductRepository;
import com.johan.market.persistence.crud.ProductoCrudRepostiory;
import com.johan.market.persistence.entity.Producto;
import com.johan.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepostiory productoCrudRepository;
    private ProductMapper mapper;
    @Override
    public List<Product> getAll(){
        List<Producto> productos=(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
    @Override
    public Optional<List<Product>>getByCategory(int idCategoria){
        List<Producto> productos= productoCrudRepository.findByIdCategoria(idCategoria);
        return Optional.of(mapper.toProducts(productos));
    }
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
       Optional <List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(productos1 -> mapper.toProducts(productos1));
    }
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Optional<List<Product>> getByIdCatagoryOrderByNamaASC(int categoryId) {
        Optional<List<Producto>> productos =productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return productos.map(productos1 -> mapper.toProducts(productos1));
    }

    @Override
    public Product save(Product product) {
        Producto producto= mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
