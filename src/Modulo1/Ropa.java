package Modulo1;

public class Ropa {

    private String nombreRopa;
    private String tallaRopa;
    private String marcaRopa;
    private String categoriaRopa;
    private int stockRopa;
    private double precioRopa;
    private Proveedor proveedorRopa;
    private int id; 

    public Ropa() {}

    public Ropa(String nombreRopa, String tallaRopa, String marcaRopa) {
        this.nombreRopa = nombreRopa;
        this.tallaRopa = tallaRopa;
        this.marcaRopa = marcaRopa;
    }

    public Ropa(String nombreRopa, String tallaRopa, String marcaRopa, String categoriaRopa,
                int stockRopa, double precioRopa, Proveedor proveedorRopa) {
        this.nombreRopa = nombreRopa;
        this.tallaRopa = tallaRopa;
        this.marcaRopa = marcaRopa;
        this.categoriaRopa = categoriaRopa;
        setStockRopa(stockRopa);
        setPrecioRopa(precioRopa);
        this.proveedorRopa = proveedorRopa;
    }

    public String getNombreRopa() { return nombreRopa; }
    public void setNombreRopa(String nombreRopa) { this.nombreRopa = nombreRopa; }

    public String getTallaRopa() { return tallaRopa; }
    public void setTallaRopa(String tallaRopa) { this.tallaRopa = tallaRopa; }

    public String getMarcaRopa() { return marcaRopa; }
    public void setMarcaRopa(String marcaRopa) { this.marcaRopa = marcaRopa; }

    public String getCategoriaRopa() { return categoriaRopa; }
    public void setCategoriaRopa(String categoriaRopa) { this.categoriaRopa = categoriaRopa; }

    public int getStockRopa() { return stockRopa; }
    public void setStockRopa(int stockRopa) {
        if (stockRopa >= 0) this.stockRopa = stockRopa;
    }

    public double getPrecioRopa() { return precioRopa; }
    public void setPrecioRopa(double precioRopa) {
        if (precioRopa > 0) this.precioRopa = precioRopa;
    }

    public Proveedor getProveedorRopa() { return proveedorRopa; }
    public void setProveedorRopa(Proveedor proveedorRopa) { this.proveedorRopa = proveedorRopa; }

    public int getId() { return id; } // getter
    public void setId(int id) { this.id = id; } // setter

    public void aumentoStock(int aumento) {
        if (aumento > 0) stockRopa += aumento;
    }

    public void disminuirStock(int disminucion) {
        if (disminucion > 0 && stockRopa - disminucion >= 0) stockRopa -= disminucion;
    }

    public void descuentoPrecio(double porcentajeDescuento) {
        if (porcentajeDescuento > 0 && porcentajeDescuento < 100) {
            double descuento = precioRopa * (porcentajeDescuento / 100);
            precioRopa -= descuento;
        }
    }

    public void Descripcion() {
        System.out.println("-----------------------------------------------------");
        System.out.println("------------ INFORMACION DE LA PRENDA ---------------");
        System.out.println("| * NOMBRE: " + getNombreRopa());
        System.out.println("| * TALLA: " + getTallaRopa());
        System.out.println("| * MARCA: " + getMarcaRopa());
        System.out.println("| * CATEGORIA: " + getCategoriaRopa());
        System.out.println("| * PRECIO: " + getPrecioRopa());
        System.out.println("| * STOCK: " + getStockRopa());
        if (proveedorRopa != null) {
            proveedorRopa.descripcionProovedor();
        } else {
            System.out.println("| * PROVEEDOR: Sin proveedor asignado");
        }
        System.out.println("-----------------------------------------------------");
    }
}


