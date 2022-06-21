/*

Guia 8 Colecciones Ejercicio 6

Se necesita una aplicación para una tienda en la cual queremos almacenar los
distintos productos que venderemos y el precio que tendrán. Además, se necesita
que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.

 */
package Servicios;

import Entidades.Producto;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServicioProducto {

    Scanner Leer;

    //Entre <> Primer termino, digo que tipo de dato es la llave, segundo termino tipo de dato que es el OBJETO a guardar
    private HashMap<String, Producto> nuevoMapa; // Creo EL MAPA

    public ServicioProducto() {
        this.Leer = new Scanner(System.in).useDelimiter("\n");
        this.nuevoMapa = new HashMap<>();// Creo el espacio en memoria del MAPA
    }

    public void menuProducto() {
        boolean Sal = true;
        do {

            String opcion = "";
            int cont = 0;
            System.out.println("========================== Menu ==========================");
            do {
                if (cont > 0) {
                    System.out.println("Opcion invalida.");
                }
                cont +=1;
                System.out.println("Elija alguna de las siguientes opciones:");
                System.out.println("'a' crear un nuevo producto");
                System.out.println("'b' modificar el precio de un producto");
                System.out.println("'c' eliminar un producto");
                System.out.println("'d' mostrar los productos");
                System.out.println("'e' Salir");
                opcion = Leer.next();
                opcion = opcion.toLowerCase();
            } while (opcion.equals("a") && opcion.equals("b") && opcion.equals("c") && opcion.equals("d") && opcion.equals("e"));
//            cont = 0;
            switch (opcion) {
                case "a":   // crearNuevoProducto
                    crearNuevoProducto();
                    break;
                case "b":   // modificarPrecioProducto
                    modificarPrecioProducto();
                    break;
                case "c":   // eliminarProducto
                    eliminarProducto();
                    break;
                case "d":   // mostrarProductos
                    titulosMostrarProductos();
                    break;
                case "e":   // Salir
                    Sal = deseaSalirSoN();
                    break;
            }
        } while (Sal);

    }

    public void crearNuevoProducto() /* a */ {
        System.out.println("========================== Crear un nuevo producto ==========================");
        System.out.println("¿Cual es el nombre del producto?");
        String noombre = Leer.next().toUpperCase();
        System.out.println("¿Cual es el precio del producto?");
        Double precio = Leer.nextDouble();
        // De este modo agrego elementos a un mapa. Observar que el primer termino se corresponde a la KEY
        nuevoMapa.put(noombre, new Producto(noombre, precio));
    }

    public void modificarPrecioProducto() /* b */ {
        System.out.println("========================== Modificar el precio de un producto ==========================");
        mostrarProductos();
        System.out.println("¿Cual es el producto que desea modificar?");
        String Modificar = Leer.next().toUpperCase();
        System.out.println("¿Cual es el nuevo precio del producto?");
        Double precio = Leer.nextDouble();
        if (nuevoMapa.containsKey(Modificar)) {
            Producto p = nuevoMapa.get(Modificar);
            p.setPrecio(precio);
            nuevoMapa.replace(Modificar, p);
        }
    }

    public void eliminarProducto() /* c */ {
        System.out.println("========================== Eliminar un producto ==========================");
        mostrarProductos();
        System.out.println("Inserte el nombre del producto que desea eliminar.");
        String Eliminar = Leer.next().toUpperCase();
        nuevoMapa.remove(Eliminar);
    }

    public void titulosMostrarProductos() /* d */ {
        System.out.println("========================== Mostrar los productos ==========================");
        mostrarProductos();
    }

    public void mostrarProductos() {
        // Afecta el funcionamiento de: *modificarPrecioProducto() *eliminarProducto()

        // entry.getKey trae la llave y entry.getValue trae los valores del mapa, Es decir todos sus atributos
        for (Map.Entry<String, Producto> entry : nuevoMapa.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public boolean deseaSalirSoN() /* e */ {
//        La estructura que se debe utilizar con este metodo es la siguiente:
//        do {
//            codigo que desea usar;
//        } while (metodo => deseaSalirSoN());
        boolean Salir = true;
        String salir = "";
        do {
            System.out.println("=========== 's' ¿Desea salir? 'r'¿O regresar al menu? ===========");
            salir = Leer.next().toLowerCase();
        } while (salir.equals("s") == false && salir.equals("r") == false);
        if (salir.equals("s")) {
            Salir = false;
        }
        if (salir.equals("r")) {
            Salir = true;
        }
        return Salir;
    }

}
