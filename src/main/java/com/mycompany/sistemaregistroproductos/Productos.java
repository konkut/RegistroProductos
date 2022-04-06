
package com.mycompany.sistemaregistroproductos;

public class Productos {
    private int Id,Cantidad;
private double Precio;
private String Descripcion, Categoria;

    public Productos() {
        this.Id = 0;
        this.Cantidad = 0;
        this.Precio = 0;
        this.Descripcion = "";
        this.Categoria = "";
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }


}
