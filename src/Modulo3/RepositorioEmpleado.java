package Modulo3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Modulo2.Empleado;

public class RepositorioEmpleado implements Repositorio<Empleado> {

    private Set<Empleado> empleados = new HashSet<>();

    @Override
    public void agregar(Empleado empleado) {
        empleados.add(empleado);   // Set evita duplicados lógicos si has definido bien equals/hashCode
    }

    @Override
    public boolean eliminar(Empleado empleado) {
        return empleados.remove(empleado);
    }

    @Override
    public Empleado buscarPorId(String dni) {
        for (Empleado e : empleados) {
            // necesitas un getDniPersona() en Empleado (o en Persona)
            if (e.getDniPersona().equals(dni)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Empleado> listar() {
        return new ArrayList<>(empleados);
    }
}