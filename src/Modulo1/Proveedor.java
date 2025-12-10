package Modulo1;

public class Proveedor {
    // Atributos de proovedor
    private String nombreProveedor;
    private String rucProovedor;
    private String telefonoProovedor;
    private String direccionProovedor;
    private int id;

    // Constructor
    // Vacio
    public Proveedor() {
    }
    // Masomenos, con algunos atributos
    public Proveedor(String nombreProveedor, String rucProovedor) {
        this.nombreProveedor = nombreProveedor;
        this.rucProovedor = rucProovedor;
    }
    // Completo
    public Proveedor(String nombreProveedor, String rucProovedor, String telefonoProovedor, String direccionProovedor) {
        this.nombreProveedor = nombreProveedor;
        this.rucProovedor = rucProovedor;
        this.telefonoProovedor = telefonoProovedor;
        this.direccionProovedor = direccionProovedor;
    }

    // Getters y Setters, acá ya si no hay validadores porque no es necesario pe
    public String getNombreProveedor() {return nombreProveedor;}
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getRucProovedor() {return rucProovedor;}
    public void setRucProovedor(String rucProovedor) {
        this.rucProovedor = rucProovedor;
    }

    public String getTelefonoProovedor() {return telefonoProovedor;}
    public void setTelefonoProovedor(String telefonoProovedor) {
        this.telefonoProovedor = telefonoProovedor;
    }

    public String getDireccionProovedor() {return direccionProovedor;}
    public void setDireccionProovedor(String direccionProovedor) {
        this.direccionProovedor = direccionProovedor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Descripcion
    public void descripcionProovedor(){
        System.out.println("-----------------------------------------------------");
        System.out.println("----------- INFORMACION DEL PROOVEDOR ---------------");
        System.out.println("| * Nombre: "+getNombreProveedor());
        System.out.println("| * RUC: "+getRucProovedor());
        System.out.println("| * TELEFONO: "+getTelefonoProovedor());
        System.out.println("| * DIRECCION: "+getDireccionProovedor());
        System.out.println("-----------------------------------------------------");
    }
}
