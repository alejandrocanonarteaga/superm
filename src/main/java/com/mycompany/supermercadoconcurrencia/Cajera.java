/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermercadoconcurrencia;

/**
 *
 * @author alejc
 */
import java.util.concurrent.TimeUnit;

public class Cajera implements Runnable {
    private String nombre;
    private Cliente cliente;

    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }
    
       public Cajera(String nombre) {
        this.nombre = nombre;
      
    }

    @Override
    public void run() {
        System.out.println("Cajera " + nombre + " procesando la compra de " + cliente.getNombre());

        for (Producto producto : cliente.getProductosComprados()) {
            procesarProducto(producto);
        }

        System.out.println("Compra de " + cliente.getNombre() + " procesada por Cajera " + nombre);
    }

    private void procesarProducto(Producto producto) {
        System.out.println("Cajera " + nombre + " procesando producto: " + producto.getNombre());
        // Lógica de procesamiento de producto (puede incluir cálculos, etc.)
        try {
            TimeUnit.SECONDS.sleep(1);  // Simula el tiempo de procesamiento del producto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producto " + producto.getNombre() + " procesado por Cajera " + nombre);
    }

    boolean isDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
