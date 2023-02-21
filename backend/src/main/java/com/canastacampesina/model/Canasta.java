package com.canastacampesina.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Canasta {
    @Id
    @Column(name="id_producto")
    private int idProducto;
    @Column(name="nombre")
    private String nombreProducto;
    @Column(name="categoria")
    private String categoriaProducto;
    @Column(name="precio")
    private float precioProducto;
    @Column(name="cantidad")
    private int cantidadProducto;


    public Canasta(){
    }

    public Canasta(int idProducto, String nombreProducto, String categoriaProducto, float precioProducto,
            int cantidadProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }

    @Override
    public String toString() {
        String info = "\n-------------------------------------------\n";
        info += "----------- ID:" + idProducto + "------------\n";
        info += "Nombre del prodecto: " + nombreProducto;
        info += "\nCategoria: " + categoriaProducto;
        info += "\nPrecio: " + precioProducto;
        info += "\nCantidad disponible: " + cantidadProducto;
        info +="\n--------------------------------------------------------\n";
        return info;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }    
}
