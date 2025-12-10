package Modulo3;

import java.util.List;

// Interfaz genérica del módulo 3
public interface Repositorio<T> {

    void agregar(T elemento);

    boolean eliminar(T elemento);

    T buscarPorId(String id);

    List<T> listar();
}
