package com.johan.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer IdProducto;
    public String nombre;
    @Column(name = "id_categoria")
    public Integer idCategoria;
    @Column(name = "codigo_barras")
    public String codigoBarras;
    @Column(name = "precio_venta")
    public Double precioVenta;
    @Column(name = "cantidad_stock")
    public Integer cantidadStock;
    public boolean estado;

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer idProducto) {
        IdProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
