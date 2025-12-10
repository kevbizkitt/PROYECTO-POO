package Modulo2;
import Modulo1.*;
import java.util.Date;
public class Main {
    public static void main (String args[]){
        // Proovedor
        Proveedor P1 = new Proveedor("Polos inc", "12172631723123", "951 900 943", "WASHINGON #401");
        // Prenda
        Ropa polo = new Ropa("Polo", "L","ADIDAS", "Ropa Hombre", 15, 29.90, P1);
        // Inventario
        Inventario inventario = new Inventario();
        inventario.agregarRopa(polo);

        // Empleado
        Empleado empleado = new Empleado(
                "Carlos", "Perez", "Lopez", "12345678",
                "Almacenero", 1500
        );
        Empleado empleado2 = new Empleado(
                "Manuel", "Pardo", "Lopez", "12345678",
                "Almacenero", 1500
        );

        // Movimiento: Entrada
        Entrada entrada = new Entrada(
                new Date(), polo, 5, empleado
        );
        System.out.println("STOCK ACTUAL: "+polo.getStockRopa());
        entrada.procesoMovimiento();
        entrada.generarReporte();
        // Movimiento: Salida
        Salida salida = new Salida(
                new Date(), polo, 3, empleado2
        );
        System.out.println("STOCK ACTUAL: "+polo.getStockRopa());
        salida.procesoMovimiento();
        salida.generarReporte();

        // Inventario final
        System.out.println("Stock final de " + polo.getNombreRopa() + ": " + polo.getStockRopa());
    }
}
