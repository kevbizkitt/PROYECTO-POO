package Modulo2;

public class Gerente extends Empleado {
    private String areaResponsable;

    public Gerente() {}

    public Gerente(String nombrePersona, String apellidoPaternoPersona, String apellidoMaternoPersona,
                   String dniPersona, String cargoEmpleado, double sueldo, String areaResponsable) {
        super(nombrePersona, apellidoPaternoPersona, apellidoMaternoPersona, dniPersona, cargoEmpleado, sueldo);
        this.areaResponsable = areaResponsable;
    }

    public String getAreaResponsable() { return areaResponsable; }
    public void setAreaResponsable(String areaResponsable) { this.areaResponsable = areaResponsable; }

    @Override
    public void personaInformacion() {
        System.out.println("-----------------------------------------------------");
        System.out.println("-------------- INFORMACION DE GERENTE --------------");
        System.out.println("| * CARGO --> " + getCargoEmpleado());
        System.out.println("| * AREA A CARGO --> " + getAreaResponsable());
        System.out.println("| * APELLIDO PATERNO: " + getApellidoPaternoPersona());
        System.out.println("| * APELLIDO MATERNO: " + getApellidoMaternoPersona());
        System.out.println("| * NOMBRE: " + getNombrePersona());
        System.out.println("| * DNI: " + getDniPersona());
        System.out.println("| * SUELDO: " + getSueldo());
        System.out.println("-----------------------------------------------------");
    }
}
