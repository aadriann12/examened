/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comercioelectronico1;

public class lineapedido {

    public String articulo;
    public double precio;
    public int cantidad;

    public lineapedido(String articulo, double precio, int cantidad) {
        this.articulo = articulo;
        this.precio = precio;
        this.cantidad = cantidad;

    }

    @Override
    public String toString() {
        return "Artículo: " + articulo + ", precio: " + precio + ", cantidad: " + cantidad;
    }

}
