/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comercioelectronico1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class pedido {




public class Pedido {

    private int numeroPedido;
    private LocalDate fechaPedido;
    private List<LineaPedido> lineasPedido;
    private boolean descuento;
    private String numeroCliente;
    private String cliente;
    private String direccion;
    private Tasas tasa;
    private String tipo;

    public Pedido(int numeroPedido, LocalDate fechaPedido, String numeroCliente, String cliente, String direccion, Tasas tasa, String tipo) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.descuento = false;
        this.lineasPedido = new ArrayList<>();
        this.numeroCliente = numeroCliente;
        this.cliente = cliente;
        this.direccion = direccion;
        this.tasa = tasa;
        this.tipo = tipo;
    }

    public boolean insertarLinea(LineaPedido lineaPedido) {
        return lineasPedido.add(lineaPedido);
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public double calcularTotalPedido() {
        return descuento ? calcularTotalLineasPedido() - calcularDescuento() : calcularTotalLineasPedido();
    }

    private double calcularTotalLineasPedido() {
        double total = 0;
        for (LineaPedido lineap : lineasPedido) {
            total += lineap.cantidad * lineap.precio;
        }
        total += aplicarTasa(total);
        return total;
    }

    private double aplicarTasa(double total) {
        if (tasa.equals(Tasas.EU)) {
            return total * 0.08d; // Impuesto sobre la venta de EUA
        } else if (tasa.equals(Tasas.US)) {
            return total * 0.21d; // IVA europeo
        }
        return 0;
    }

    private double calcularDescuento() {
        double totalLineas = calcularTotalLineasPedido();
        switch (tipo) {
            case "ORO":
                return totalLineas * 0.15d;
            case "PLATA":
                return totalLineas * 0.125d;
            case "BRONCE":
                return totalLineas * 0.10d;
            default:
                return 0;
        }
    }

    public void imprimePedido() {
        imprimeCabecera();
        imprimeDetallePedido();
        System.out.println(String.format("Total Pedido: %,.2f", calcularTotalPedido()));
    }

    private void imprimeCabecera() {
        System.out.println("Cliente: " + cliente);
        System.out.println("\tNúmero Cliente: " + numeroCliente);
        System.out.println("\tDirección: " + direccion);
        if (tasa.equals(Tasas.EU)) {
            System.out.println("\tTasa: 0,08%"); // Impuesto sobre la venta de EUA
        } else if (tasa.equals(Tasas.US)) {
            System.out.println("\tTasa: 0,21%"); // IVA europeo
        }
    }

    private void imprimeDetallePedido() {
        System.out.println("Número Pedido: " + numeroPedido);
        for (LineaPedido lineap : lineasPedido) {
            System.out.println("\tArtículo: " + lineap.toString());
        }
    }
}
