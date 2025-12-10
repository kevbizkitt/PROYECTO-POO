package Modulo2;

public class Empleado extends Persona {
    private String cargoEmpleado;
    private double sueldo;
    private int id;

    public Empleado() {}

    public Empleado(String nombrePersona, String apellidoPaternoPersona,
                    String apellidoMaternoPersona, String dniPersona, String cargoEmpleado,
                    double sueldo) {
        super(nombrePersona, apellidoPaternoPersona, apellidoMaternoPersona, dniPersona);
        this.cargoEmpleado = cargoEmpleado;
        setSueldo(sueldo);
    }

    public String getCargoEmpleado() { return cargoEmpleado; }
    public void setCargoEmpleado(String cargoEmpleado) { this.cargoEmpleado = cargoEmpleado; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { if (sueldo >= 0) this.sueldo = sueldo; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public void personaInformacion() {
        System.out.println("-----------------------------------------------------");
        System.out.println("-------------- INFORMACION DE EMPLEADO --------------");
        System.out.println("| * CARGO --> " + getCargoEmpleado());
        System.out.println("| * APELLIDO PATERNO: " + getApellidoPaternoPersona());
        System.out.println("| * APELLIDO MATERNO: " + getApellidoMaternoPersona());
        System.out.println("| * NOMBRE: " + getNombrePersona());
        System.out.println("| * DNI: " + getDniPersona());
        System.out.println("| * SUELDO: " + getSueldo());
        System.out.println("-----------------------------------------------------");
    }
}
