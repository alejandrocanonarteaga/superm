/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermercadoconcurrencia;

/**
 *
 * @author alejc
 */
public class Producto {
    private String nombre;
    private double precio;

    // Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getter para el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Getter para el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Setter para el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Setter para el precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

