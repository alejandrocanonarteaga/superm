/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermercadoconcurrencia;

/**
 *
 * @author alejc
 */
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Producto> productosComprados;

    public Cliente(String nombre, List<Producto> productosComprados) {
        this.nombre = nombre;
        this.productosComprados = productosComprados;
    }
    public Cliente(String nombre) {
        this.nombre = nombre;
        
    }
    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductosComprados() {
        return productosComprados;
    }

    

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", productosComprados=" + productosComprados +
                '}';
    }

    String getTiempoDeAtencion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

