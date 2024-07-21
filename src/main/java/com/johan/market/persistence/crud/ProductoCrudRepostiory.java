package com.johan.market.persistence.crud;

import com.johan.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepostiory extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoria(int idCategoria);
    Optional<List<Producto>> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
