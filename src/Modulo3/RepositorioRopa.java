package Modulo3;

import java.util.ArrayList;
import java.util.List;

import Modulo1.Ropa;   // importa tu clase del Módulo 1

public class RepositorioRopa implements Repositorio<Ropa> {

    private List<Ropa> prendas = new ArrayList<>();

    @Override
    public void agregar(Ropa prenda) {
        prendas.add(prenda);
    }

    @Override
    public boolean eliminar(Ropa prenda) {
        return prendas.remove(prenda);
    }

    @Override
    public Ropa buscarPorId(String nombreRopa) {
        for (Ropa r : prendas) {     // uso de for-each
            if (r.getNombreRopa().equalsIgnoreCase(nombreRopa)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Ropa> listar() {
        return prendas;
    }
}