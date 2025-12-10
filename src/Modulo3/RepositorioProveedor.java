package Modulo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modulo1.Proveedor;

public class RepositorioProveedor implements Repositorio<Proveedor> {

    // clave = RUC, valor = Proveedor
    private Map<String, Proveedor> proveedores = new HashMap<>();

    @Override
    public void agregar(Proveedor proveedor) {
        String ruc = proveedor.getRucProovedor(); // usa el getter que tienes en tu UML
        proveedores.put(ruc, proveedor);
    }

    @Override
    public boolean eliminar(Proveedor proveedor) {
        String ruc = proveedor.getRucProovedor();
        if (proveedores.containsKey(ruc)) {
            proveedores.remove(ruc);
            return true;
        }
        return false;
    }

    @Override
    public Proveedor buscarPorId(String ruc) {
        return proveedores.get(ruc); // si no existe, devuelve null
    }

    @Override
    public List<Proveedor> listar() {
        return new ArrayList<>(proveedores.values());
    }
}