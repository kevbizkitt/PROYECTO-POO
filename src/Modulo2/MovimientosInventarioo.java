package Modulo2;

import java.util.Date;
import Modulo1.Ropa;

public abstract class MovimientosInventarioo implements Reportable {
    protected Date fechaMovimiento;
    protected Ropa prendaRopa;
    protected int cantidadMovimiento;
    protected Empleado empleado;

    public MovimientosInventarioo(Date fechaMovimiento, Ropa prendaRopa, int cantidadMovimiento, Empleado empleado) {
        if (cantidadMovimiento <= 0) throw new IllegalArgumentException("Cantidad de movimiento debe ser mayor a 0");
        this.fechaMovimiento = fechaMovimiento;
        this.prendaRopa = prendaRopa;
        this.cantidadMovimiento = cantidadMovimiento;
        this.empleado = empleado;
    }

    public Date getFechaMovimiento() { return fechaMovimiento; }
    public void setFechaMovimiento(Date fechaMovimiento) { this.fechaMovimiento = fechaMovimiento; }

    public Ropa getPrendaRopa() { return prendaRopa; }
    public void setPrendaRopa(Ropa prendaRopa) { this.prendaRopa = prendaRopa; }

    public int getCantidadMovimiento() { return cantidadMovimiento; }
    public void setCantidadMovimiento(int cantidadMovimiento) { this.cantidadMovimiento = cantidadMovimiento; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public abstract void procesoMovimiento();
}
