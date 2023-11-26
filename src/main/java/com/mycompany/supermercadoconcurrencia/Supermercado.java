/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermercadoconcurrencia;

/**
 *
 * @author alejc
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Supermercado {

    private List<Cajera> cajeras;
    private List<Cliente> clientes;

    public Supermercado() {
        this.cajeras = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregarCajera(Cajera cajera) {
        if (!this.cajeras.contains(cajera)) {
            this.cajeras.add(cajera);
            System.out.println("Cajera " + cajera.getNombre() + " agregada al supermercado.");
        } else {
            System.out.println("Error: La cajera " + cajera.getNombre() + " ya está presente en el supermercado.");
        }
    }

    public void agregarCliente(Cliente cliente) {
        if (!this.clientes.contains(cliente)) {
            this.clientes.add(cliente);
            System.out.println("Cliente " + cliente.getNombre() + " agregado al supermercado correctamente.");
        } else {
            System.out.println("¡Error! El cliente " + cliente.getNombre() + " ya existe en el supermercado.");
        }
    }

    public void simularCobro() {
        ExecutorService executor = Executors.newFixedThreadPool(this.cajeras.size());

        for (Cliente cliente : this.clientes) {
            Cajera cajera = this.seleccionarCajeraDisponible();
            executor.submit(new Cajera(cajera.getNombre(), cliente));
        }

        executor.shutdown();

        // Registra el tiempo que tarda cada cliente en ser atendido
        for (Cliente cliente : this.clientes) {
            System.out.println(
                "El cliente " + cliente.getNombre() + " tardó " + cliente.getTiempoDeAtencion() + " segundos en ser atendido.");
        }
    }

    private Cajera seleccionarCajeraDisponible() {
      // Itera a través de la lista de cajeras
      for (Cajera cajera : this.cajeras) {
          // Si la cajera está disponible, la devuelve
          if (cajera.isDisponible()) {
              return cajera;
          }
      }

      // Si no hay cajeras disponibles, devuelve null
      return null;
    }

    Iterable<Cliente> getClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getCajeras() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}