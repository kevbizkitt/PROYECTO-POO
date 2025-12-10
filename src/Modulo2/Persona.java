package Modulo2;

public class Persona {
    private String nombrePersona;
    private String apellidoPaternoPersona;
    private String apellidoMaternoPersona;
    private String dniPersona;

    public Persona() {}

    public Persona(String nombrePersona, String apellidoPaternoPersona, String apellidoMaternoPersona, String dniPersona) {
        this.nombrePersona = nombrePersona;
        this.apellidoPaternoPersona = apellidoPaternoPersona;
        this.apellidoMaternoPersona = apellidoMaternoPersona;
        this.dniPersona = dniPersona;
    }

    public String getNombrePersona() { return nombrePersona; }
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }

    public String getApellidoPaternoPersona() { return apellidoPaternoPersona; }
    public void setApellidoPaternoPersona(String apellidoPaternoPersona) { this.apellidoPaternoPersona = apellidoPaternoPersona; }

    public String getApellidoMaternoPersona() { return apellidoMaternoPersona; }
    public void setApellidoMaternoPersona(String apellidoMaternoPersona) { this.apellidoMaternoPersona = apellidoMaternoPersona; }

    public String getDniPersona() { return dniPersona; }
    public void setDniPersona(String dniPersona) { this.dniPersona = dniPersona; }

    public void personaInformacion() {
        System.out.println("-----------------------------------------------------");
        System.out.println("-------------- INFORMACION DE PERSONA --------------");
        System.out.println("| * APELLIDO PATERNO: " + getApellidoPaternoPersona());
        System.out.println("| * APELLIDO MATERNO: " + getApellidoMaternoPersona());
        System.out.println("| * NOMBRE: " + getNombrePersona());
        System.out.println("| * DNI: " + getDniPersona());
        System.out.println("-----------------------------------------------------");
    }
}
