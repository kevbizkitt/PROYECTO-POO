package Modulo4;

import java.util.*;
import Modulo1.Ropa;
import Modulo1.Proveedor;
import Modulo2.Empleado;

public class Main {

    public static void main(String[] args) {

        List<Ropa> prendas = new ArrayList<>();
        prendas.add(new Ropa("Polo Negro", "M", "Adidas"));
        prendas.add(new Ropa("Casaca Roja", "L", "Nike"));
        prendas.add(new Ropa("Pantalón Azul", "32", "Adidas"));

        System.out.println("Prendas disponibles:");
        prendas.forEach(p -> System.out.println(p.getNombreRopa()));

        System.out.println("\nPrendas de marca Adidas:");
        prendas.stream()
                .filter(p -> p.getMarcaRopa().equalsIgnoreCase("Adidas"))
                .forEach(p -> System.out.println(p.getNombreRopa()));

        System.out.println("\nNombres de prendas (map):");
        prendas.stream()
                .map(Ropa::getNombreRopa)
                .forEach(System.out::println);

        long totalPrendas = prendas.stream().count();
        System.out.println("\nTotal de prendas: " + totalPrendas);


        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Ana", "Perez", "Lopez", "45879632", "Cajera", 1600));
        empleados.add(new Empleado("Luis", "Torres", "Matos", "45879633", "Vendedor", 1400));
        empleados.add(new Empleado("Carlos", "Ramos", "Valdez", "45879634", "Supervisor", 2100));

        System.out.println("\nEmpleados registrados:");
        empleados.forEach(e ->
                System.out.println(e.getNombrePersona() + " - " + e.getCargoEmpleado())
        );

        System.out.println("\nEmpleados con sueldo mayor a 1500:");
        empleados.stream()
                .filter(e -> e.getSueldo() > 1500)
                .forEach(e -> System.out.println(e.getNombrePersona()));

        System.out.println("\nNombres de empleados:");
        empleados.stream()
                .map(Empleado::getNombrePersona)
                .forEach(System.out::println);


        List<Proveedor> proveedores = new ArrayList<>();
        proveedores.add(new Proveedor("Adidas", "4785942187"));
        proveedores.add(new Proveedor("Nike", "6547891271"));
        proveedores.add(new Proveedor("Puma", "2176596387"));

        System.out.println("\nProveedores registrados:");
        proveedores.forEach(p ->
                System.out.println(p.getNombreProveedor() + " - " + p.getRucProovedor())
        );

        System.out.println("\nProveedores que empiezan con 'A':");
        proveedores.stream()
                .filter(p -> p.getNombreProveedor().startsWith("A"))
                .forEach(p -> System.out.println(p.getNombreProveedor()));
    }
}