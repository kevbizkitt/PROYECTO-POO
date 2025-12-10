package Modulo3;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Modulo2.MovimientosInventarioo;

public class RegistroMovimientos {

    private LinkedList<MovimientosInventarioo> movimientos = new LinkedList<>();

    public void registrarMovimiento(MovimientosInventarioo mov) {
        movimientos.add(mov);
    }

    public boolean eliminarMovimiento(MovimientosInventarioo mov) {
        return movimientos.remove(mov);
    }

    public List<MovimientosInventarioo> listarMovimientos() {
        return movimientos;
    }

    public List<MovimientosInventarioo> buscarPorFecha(Date fecha) {
        List<MovimientosInventarioo> resultado = new LinkedList<>();
        for (MovimientosInventarioo m : movimientos) {
            if (m.getFechaMovimiento().equals(fecha)) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}