package model;

public class car {
    
    private String marca;
    private String modelo;
    private String año;
    private Double precio;
    private String color;
    private String tipoMotor;
    private String kilometraje;
    private String fechaIngresoo;
    private String placa;
    private int cantidad; // Agregar la propiedad cantidad

    // Constructor actualizado
    public car(String marca, String modelo, String año, Double precio, String color, String tipoMotor, String kilometraje, String fechaIngresoo, String placa, int cantidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.color = color;
        this.tipoMotor = tipoMotor;
        this.kilometraje = kilometraje;
        this.fechaIngresoo = fechaIngresoo;
        this.placa = placa;
        this.cantidad = cantidad; // Inicializar cantidad
    }

    // Métodos getter y setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getFechaIngresoo() {
        return fechaIngresoo;
    }

    public void setFechaIngresoo(String fechaIngresoo) {
        this.fechaIngresoo = fechaIngresoo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
