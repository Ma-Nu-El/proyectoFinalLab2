package controlador;

import objeto.CategoriaDAO;
import modelo.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriaControl {

    private final CategoriaDAO DATOS;
    private Categoria obj;
    private DefaultTableModel modeloTabla;
    public int regMostrados;

    public CategoriaControl() {
        this.DATOS = new CategoriaDAO();
        this.obj = new Categoria();
        this.regMostrados = 0;//iniciamos la variable

    }

    //Metodo Listar
    public DefaultTableModel listar(String texto) {
        List<Categoria> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));//Lista con todos los registro en un Arraylist

        String[] titulos = {"Id", "Nombre", "Descripcion", "Estado"};//Columnas de la tabla
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[4];//vector registro de cuatro indices

        this.regMostrados = 0;//reinicializar, por que el metodo listar puede ser consultado en más de una ocación

        //Regorre cada elemento de la lista mediante el item
        for (Categoria item : lista) {
            if (item.isActivo()) {
                estado = "Activo";

            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());//convertimos el int a un String
            registro[1] = item.getNombre();
            registro[2] = item.getDescripcion();
            registro[3] = estado;
            this.modeloTabla.addRow(registro);
            this.regMostrados = this.regMostrados + 1;//Contador

        }
        return this.modeloTabla;

    }

    //Metodo Insertar
    public String insertar(String nombre, String descripcion) {
        //Determinamos que el registro no se duplique
        if (DATOS.existe(nombre)) {
            return "Registro Existente";
        } else {
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error de Registro";
            }
        }
    }

   

    //Metodos Activar & Desactivar
    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No es posible desactivar el registro";
        }

    }

    public String activar(int id) {

        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "No es posible activar el registro";
        }
    }

    //Metodo Total
    //Total de registros almacenados en la tabla
    public int total() {
        return DATOS.total();
    }

    //Total de los registros que mostramos
    public int totalMostrados() {
        return this.regMostrados;//retornamos la variable
    }

    
    
     //Metodo Actualizar
    public String actualizar(int id, String nombre, String nombreAnt, String descripcion) {
        //Validamos
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);

            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error de actualizacion";
            }

        } else {
            if (DATOS.existe(nombre)) {//validamos que no se repita
                return "Registro Existente";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setDescripcion(descripcion);

                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error de actualizacion";
                }
            }
        }

    }
}
