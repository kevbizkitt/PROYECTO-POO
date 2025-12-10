package Modulo5;

import Modulo1.Proveedor;
import Modulo1.Ropa;
import Modulo2.Empleado;

import java.util.Date;
import java.util.List;

public class MainDBTest {
    public static void main(String[] args) {
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        MovimientoDAO movimientoDAO = new MovimientoDAO();
        RopaDAO ropaDAO = new RopaDAO();

        try {
            System.out.println("Probando conexión a la base de datos...");
            if (DBConexion.getConnection().isValid(2)) System.out.println("Conexión OK.");
            else System.out.println("Conexión NO válida.");

            Proveedor p = new Proveedor("Proveedor Test", "RUC-TEST-001", "999111222", "Calle Falsa 123");
            int provId = proveedorDAO.insertar(p);
            System.out.println("Proveedor insertado, id: " + provId);

            Empleado e = new Empleado("Juan", "Perez", "Gomez", "DNI123456", "Vendedor", 1200.00);
            int empId = empleadoDAO.insertar(e);
            System.out.println("Empleado insertado, id: " + empId);

            Ropa r = new Ropa();
            r.setNombreRopa("Camiseta Test");
            r.setTallaRopa("M");
            r.setMarcaRopa("MarcaX");
            r.setCategoriaRopa("Remeras");
            r.setStockRopa(10);
            r.setPrecioRopa(39.99);
            int ropaId = ropaDAO.insertar(r, provId);
            System.out.println("Ropa insertada, id: " + ropaId);

            if (ropaId > 0 && empId > 0) {
                int movId = movimientoDAO.registrarMovimiento(new Date(), ropaId, 5, empId, "ENTRADA", "Carga inicial");
                System.out.println("Movimiento ENTRADA registrado, id: " + movId);
            } else {
                System.out.println("No se pudo registrar movimiento: falta ropaId o empId.");
            }

            System.out.println("Movimientos guardados (resumen):");
            movimientoDAO.listarMovimientos().forEach(map -> System.out.println(map));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBConexion.close();
        }
    }
}