package Modulo3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // LISTA (agregar y recorrer)

        List<String> prendas = new ArrayList<>();
        prendas.add("Polo Negro");
        prendas.add("Casaca Roja");

        System.out.println("Prendas registradas:");
        for (String p : prendas) {
            System.out.println(p);
        }

        // CONJUNTO (evita duplicados)

        Set<String> empleados = new HashSet<>();
        empleados.add("Ana");
        empleados.add("Luis");
        empleados.add("Ana"); // duplicado → no se agrega

        System.out.println("\nEmpleados registrados:");
        Iterator<String> iter = empleados.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // MAPA (clave → valor)

        Map<Integer, String> proveedores = new HashMap<>();
        proveedores.put(1, "Proveedor Adidas");
        proveedores.put(2, "Proveedor Nike");

        System.out.println("\nLista de proveedores:");
        proveedores.forEach((id, nombre) -> System.out.println(id + ": " + nombre));

        // LISTA ENLAZADA (historial)

        List<String> movimientos = new LinkedList<>();
        movimientos.add("Entrada de 10 unidades");
        movimientos.add("Salida de 3 unidades");

        System.out.println("\nMovimientos del día:");
        for (String mov : movimientos) {
            System.out.println(mov);
        }
    }
}