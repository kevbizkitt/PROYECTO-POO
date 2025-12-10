package Modulo2;

import java.util.Date;
import Modulo1.Ropa;

public class Entrada extends MovimientosInventarioo {
    public Entrada(Date fechaMovimiento, Ropa prendaRopa, int cantidadMovimiento, Empleado empleado) {
        super(fechaMovimiento, prendaRopa, cantidadMovimiento, empleado);
    }

    @Override
    public void procesoMovimiento() {
        prendaRopa.aumentoStock(cantidadMovimiento);
        System.out.println("--------------------- ENTRADA ----------------------");
        System.out.println("--> PRENDA: " + getPrendaRopa().getNombreRopa());
        System.out.println("--> ENTRADA AL INVENTARIO: " + getCantidadMovimiento());
        System.out.println("--> STOCK ACTUAL: " + prendaRopa.getStockRopa());
    }

    @Override
    public void generarReporte() {
        System.out.println("-----------------------------------------------------");
        System.out.println("-------------- DETALLES DEL MOVIMIENTO --------------");
        System.out.println("| * FECHA: " + getFechaMovimiento());
        System.out.println("| * PRENDA: " + getPrendaRopa().getNombreRopa());
        System.out.println("| * CANTIDAD DE ENTRADA: " + getCantidadMovimiento());
        System.out.println("| * EMPLEADO: " + getEmpleado().getNombrePersona());
        System.out.println("-----------------------------------------------------");
    }
}

