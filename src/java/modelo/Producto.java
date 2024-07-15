/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.InputStream;

/**
 *
 * @author user
 */
public class Producto {


   private int idProducto;	
   private String nombre;
    private InputStream foto;
    private Double precio;	
    private int stock; 
    private String Descripcion;

 
    public Producto() {
    }

    public Producto(int idProducto, String nombre, InputStream foto,String Descripcion ,Double precio, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.foto = foto;
        this.precio = precio;
        this.stock = stock;
         this.Descripcion = Descripcion;
    }
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
