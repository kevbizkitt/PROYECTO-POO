package Modulo2;

import java.util.Date;
import Modulo1.Ropa;

public class Salida extends MovimientosInventarioo {
    public Salida(Date fechaMovimiento, Ropa prendaRopa, int cantidadMovimiento, Empleado empleado) {
        super(fechaMovimiento, prendaRopa, cantidadMovimiento, empleado);
    }

    @Override
    public void procesoMovimiento() {
        prendaRopa.disminuirStock(cantidadMovimiento);
        System.out.println("--------------------- SALIDA -----------------------");
        System.out.println("--> PRENDA: " + getPrendaRopa().getNombreRopa());
        System.out.println("--> SALIDA DEL INVENTARIO: " + getCantidadMovimiento());
        System.out.println("--> STOCK ACTUAL: " + prendaRopa.getStockRopa());
    }

    @Override
    public void generarReporte() {
        System.out.println("-----------------------------------------------------");
        System.out.println("-------------- DETALLES DEL MOVIMIENTO --------------");
        System.out.println("| * FECHA: " + getFechaMovimiento());
        System.out.println("| * PRENDA: " + getPrendaRopa().getNombreRopa());
        System.out.println("| * CANTIDAD DE SALIDA: " + getCantidadMovimiento());
        System.out.println("| * EMPLEADO: " + getEmpleado().getNombrePersona());
        System.out.println("-----------------------------------------------------");
    }
}
