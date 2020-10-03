package modelo;

import java.util.Objects;

//Clase que contiene los atributos, constructores, toString, set y get de una categoria
public class Categoria extends Estructura{

    public Categoria(int id, String nombre, String descripcion, boolean activo) {
        super(id, nombre, descripcion, activo);
    }

    public Categoria() {
    }

    //nueva categoria ult. combBox
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    

    //Método toString que solo mostrara el nombre de la categoria
    @Override
    public String toString() {
        return nombre;
    }

}
