/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comercioelectronico1;

import java.time.LocalDate;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Pedido miPedido = crearPedidoEjemplo();
        agregarLineasPedido(miPedido);
        mostrarPedido(miPedido);
        aplicarDescuentoSiEsOro(miPedido);
    }

    private static Pedido crearPedidoEjemplo() {
        int numPedido = 1;
        LocalDate fechaPedido = LocalDate.of(2023, 5, 19);
        String numCliente = "AD35";
        String cliente = "Grupo Armando Alvarez";
        String direccion = "Avda. Pablo Garnica, 20 39300 Torrelavega - Cantabria";
        Tasas tasa = Tasas.EU;
        String tipo = "ORO";
        return new Pedido(numPedido, fechaPedido, numCliente, cliente, direccion, tasa, tipo);
    }

    private static void agregarLineasPedido(Pedido pedido) {
        LineaPedido linea1 = new LineaPedido("Pigmento azul 10K", 215.25d, 200);
        LineaPedido linea2 = new LineaPedido("Pigmento verde 10K", 125.85d, 50);
        LineaPedido linea3 = new LineaPedido("Pigmento negro 10K", 60.99d, 600);
        
        insertarLineaPedido(pedido, linea1);
        insertarLineaPedido(pedido, linea2);
        insertarLineaPedido(pedido, linea3);
    }

    private static void insertarLineaPedido(Pedido pedido, LineaPedido linea) {
        if (pedido.insertarLinea(linea)) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error en la inserción");
        }
    }

    private static void mostrarPedido(Pedido pedido) {
        pedido.imprimePedido();
    }

    private static void aplicarDescuentoSiEsOro(Pedido pedido) {
        pedido.setDescuento(true);
        if (pedido.isDescuento()) {
            System.out.println("El cliente es un cliente Oro y en este pedido se aplica el descuento");
            pedido.imprimePedido();
        }
    }
}
