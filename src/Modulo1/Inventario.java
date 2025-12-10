package Modulo1;

import java.util.*;

public class Inventario {
    private ArrayList<Ropa> prendasEnGeneral = new ArrayList<>();

    // Acá no hay constuctores ni nada, defrente a lo que vamos :v
    // Metodo para agregar Modulo1.Ropa al arraylist
    public void agregarRopa(Ropa prenda) {
        if (prenda != null) {
            prendasEnGeneral.add(prenda);
        }
    }

    // Metodo para buscar una prenda por su nombre
    public Ropa encontrarPrendaNombre(String nombrePrenda) {
        for (Ropa r : prendasEnGeneral) {
            if (r.getNombreRopa().equalsIgnoreCase(nombrePrenda)) {
                return r;
            }
        }
        return null;
    }

    // Por talla
    public Ropa encontrarPrendaTalla(String tallaPrenda) {
        for (Ropa r : prendasEnGeneral) {
            if (r.getTallaRopa().equalsIgnoreCase(tallaPrenda)) {
                return r;
            }
        }
        return null;
    }

    // Por marca
    public Ropa encontrarPrendaMarca(String marcaPrenda) {
        for (Ropa r : prendasEnGeneral) {
            if (r.getMarcaRopa().equalsIgnoreCase(marcaPrenda)) {
                return r;
            }
        }
        return null;
    }

    // Por categoria
    public Ropa encontrarPrendaCategoria(String categoriaPrenda) {
        for (Ropa r : prendasEnGeneral) {
            if (r.getCategoriaRopa().equalsIgnoreCase(categoriaPrenda)) {
                return r;
            }
        }
        return null;
    }

    // Para ver la cantidad de prendas en total
    public void cantidadPrendas() {
        prendasEnGeneral.size();
    }

    // Para mostrar todas estas prendas que hay
    public void mostrarInventario() {
        for (Ropa r : prendasEnGeneral) {
            r.Descripcion();
        }
    }

    public ArrayList<Ropa> getPrendasEnGeneral() {
        return prendasEnGeneral;
    }
}
