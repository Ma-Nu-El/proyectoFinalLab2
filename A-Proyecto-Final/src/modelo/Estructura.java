/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//Clase abstracta y padre, que hereda sus atributos a categoria y articulo
public abstract class Estructura {
    protected int id;
    protected String nombre;
    protected String descripcion;
    protected boolean activo;

    public Estructura(int id, String nombre, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Estructura() {
    }
     
}
