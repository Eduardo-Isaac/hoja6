package com.hoja6;

import java.util.*;
import java.io.*;

public class Inventario {

    public static void leerArchivo(Map<String, String> inventario) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("ListadoProducto.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                String categoria = partes[0].trim();
                String producto = partes[1].trim();

                inventario.put(producto, categoria);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void buscarCategoria(Map<String, String> inventario, String producto) {
        if (inventario.containsKey(producto)) {
            System.out.println("categoria: " + inventario.get(producto));
        } else {
            System.out.println("no encontrado");
        }
    }

    // Operación 5
    public static void mostrarInventario(Map<String, String> inventario) {

        long inicio = System.nanoTime();

        for (String producto : inventario.keySet()) {
            System.out.println(producto + " - " + inventario.get(producto));
        }

        long fin = System.nanoTime();

        System.out.println("tiempo: " + (fin - inicio));
    }

    public static void mostrarInventarioOrdenado(Map<String, String> inventario) {

        long inicio = System.nanoTime();

        TreeMap<String, String> ordenado = new TreeMap<>(inventario);

        for (String producto : ordenado.keySet()) {
            System.out.println(producto + " - " + ordenado.get(producto));
        }

        long fin = System.nanoTime();

        System.out.println("tiempo: " + (fin - inicio));
    }
}