package Modulo5;

import Modulo1.Proveedor;
import Modulo1.Ropa;
import Modulo2.Empleado;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProveedorDAO proveedorDAO = new ProveedorDAO();
    private static final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private static final RopaDAO ropaDAO = new RopaDAO();
    private static final MovimientoDAO movimientoDAO = new MovimientoDAO();

    public static void main(String[] args) {
        try {
            if (!DBConexion.getConnection().isValid(2)) {
                System.err.println("No se puede conectar a la BD. Revisa DBConexion.");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            System.out.println("---------- GESTOR INTENTARIO: NATY STORE ----------");
            System.out.println("--> SELECCIONE LA ACCION A REALIZAR:");
            System.out.println("--> (1) Agregar proveedor");
            System.out.println(" -->(2) Agregar empleado");
            System.out.println("  -->(3) Agregar ropa");
            System.out.println("   -->(4) Registrar movimiento (ENTRADA/SALIDA)");
            System.out.println("    -->(5) Lista de ropa");
            System.out.println("     -->(6) Listar de empleados");
            System.out.println("      -->(7) Listar de proveedores");
            System.out.println("       -->(8) Listar de movimientos");
            System.out.println("        -->(9) Salir");
            System.out.print("Elige una opción: ");
            String opt = sc.nextLine().trim();
            try {
                switch (opt) {
                    case "1": agregarProveedor(); break;
                    case "2": agregarEmpleado(); break;
                    case "3": agregarRopa(); break;
                    case "4": registrarMovimiento(); break;
                    case "5": listarRopa(); break;
                    case "6": listarEmpleados(); break;
                    case "7": listarProveedores(); break;
                    case "8": listarMovimientos(); break;
                    case "9": System.out.println("Saliendo..."); DBConexion.close(); return;
                    default: System.out.println("Opcion inexistente"); break;
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    private static void agregarProveedor() throws Exception {
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("RUC: "); String ruc = sc.nextLine();
        System.out.print("Teléfono: "); String tel = sc.nextLine();
        System.out.print("Dirección: "); String dir = sc.nextLine();
        Proveedor p = new Proveedor(nombre, ruc, tel, dir);
        int id = proveedorDAO.insertar(p);
        System.out.println("Proveedor insertado con id = " + id);
    }

    private static void agregarEmpleado() throws Exception {
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Apellido paterno: "); String ap = sc.nextLine();
        System.out.print("Apellido materno: "); String am = sc.nextLine();
        System.out.print("DNI: "); String dni = sc.nextLine();
        System.out.print("Cargo: "); String cargo = sc.nextLine();
        System.out.print("Sueldo: "); double sueldo = Double.parseDouble(sc.nextLine());
        Empleado e = new Empleado(nombre, ap, am, dni, cargo, sueldo);
        int id = empleadoDAO.insertar(e);
        System.out.println("Empleado insertado con id = " + id);
    }

    private static void agregarRopa() throws Exception {
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Talla: "); String talla = sc.nextLine();
        System.out.print("Marca: "); String marca = sc.nextLine();
        System.out.print("Categoria: "); String categoria = sc.nextLine();
        System.out.print("Stock inicial: "); int stock = Integer.parseInt(sc.nextLine());
        System.out.print("Precio: "); double precio = Double.parseDouble(sc.nextLine());

        System.out.println("Proveedores disponibles:");
        List<Proveedor> provs = proveedorDAO.listarTodos();
        for (Proveedor p : provs) {
            System.out.println(" - id=" + p.getId() + "  " + p.getNombreProveedor() + " (RUC: " + p.getRucProovedor() + ")");
        }
        System.out.print("Proveedor id (enter para ninguno): ");
        String provIdStr = sc.nextLine().trim();
        Integer provId = null;
        if (!provIdStr.isEmpty()) provId = Integer.parseInt(provIdStr);

        Ropa r = new Ropa();
        r.setNombreRopa(nombre);
        r.setTallaRopa(talla);
        r.setMarcaRopa(marca);
        r.setCategoriaRopa(categoria);
        r.setStockRopa(stock);
        r.setPrecioRopa(precio);

        int ropaId = ropaDAO.insertar(r, provId);
        System.out.println("Ropa insertada con id = " + ropaId);
    }

    private static void registrarMovimiento() throws Exception {
        System.out.print("Tipo (ENTRADA/SALIDA): "); String tipo = sc.nextLine().toUpperCase();
        listarRopa();
        System.out.print("Ropa id: "); int ropaId = Integer.parseInt(sc.nextLine());
        System.out.print("Cantidad: "); int cantidad = Integer.parseInt(sc.nextLine());

        System.out.println("Empleados disponibles:");
        List<Empleado> emps = empleadoDAO.listarTodos();
        for (Empleado e : emps) {
            System.out.println(" - id=" + e.getId() + "  " + e.getNombrePersona() + " " + e.getApellidoPaternoPersona());
        }
        System.out.print("Empleado id (enter para ninguno): ");
        String empIdStr = sc.nextLine().trim();
        Integer empId = null;
        if (!empIdStr.isEmpty()) empId = Integer.parseInt(empIdStr);

        System.out.print("Descripcion: "); String desc = sc.nextLine();

        int movId = movimientoDAO.registrarMovimiento(new Date(), ropaId, cantidad, empId, tipo, desc);
        System.out.println("Movimiento registrado id = " + movId);
    }

    private static void listarRopa() throws Exception {
        List<Ropa> list = ropaDAO.listarTodas();
        System.out.println("Ropa en sistema:");
        for (Ropa r : list) {
            System.out.println(" - id=" + r.getId() + " Nombre=" + r.getNombreRopa() + " Talla=" + r.getTallaRopa()
                    + " Marca=" + r.getMarcaRopa() + " Stock=" + r.getStockRopa() + " Precio=" + r.getPrecioRopa());
        }
    }

    private static void listarEmpleados() throws Exception {
        List<Empleado> list = empleadoDAO.listarTodos();
        System.out.println("Empleados:");
        for (Empleado e : list) {
            System.out.println(" - id=" + e.getId() + " " + e.getNombrePersona() + " " + e.getApellidoPaternoPersona() + " DNI=" + e.getDniPersona());
        }
    }

    private static void listarProveedores() throws Exception {
        List<Proveedor> list = proveedorDAO.listarTodos();
        System.out.println("Proveedores:");
        for (Proveedor p : list) {
            System.out.println(" - id=" + p.getId() + " " + p.getNombreProveedor() + " RUC=" + p.getRucProovedor());
        }
    }

    private static void listarMovimientos() throws Exception {
        List<HashMap<String,Object>> movs = movimientoDAO.listarMovimientos();
        System.out.println("Movimientos:");
        for (Map<String,Object> m : movs) {
            System.out.println(m);
        }
    }
}
