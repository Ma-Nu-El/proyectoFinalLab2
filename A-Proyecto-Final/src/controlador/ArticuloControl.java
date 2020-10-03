package controlador;

import objeto.ArticuloDAO;
import objeto.CategoriaDAO;

import modelo.Articulo;
import modelo.Categoria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ArticuloControl {

    private final ArticuloDAO DATOS;
    private final CategoriaDAO DATOSCAT;
    private Articulo obj;
    private DefaultTableModel modeloTabla;
    public int regMostrados;

    public ArticuloControl() {
        this.DATOS = new ArticuloDAO();
        this.DATOSCAT = new CategoriaDAO();//instancia, ahora podemos hacer referencia a los metodos  de la clase categoriaDAO mediante el objeto DATOSCAT
        this.obj = new Articulo();
        this.regMostrados = 0;//iniciamos la variable

    }

    //Metodo Listar
    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Articulo> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));

        String[] titulos = {"Id", "Categoría ID", "Categoría", "Código", "Nombre", "Precio Venta", "Stock", "Descripción", "Imagen", "Estado"};//Columnas de la tabla titulos
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[10];//vector registro de cuatro indices

        this.regMostrados = 0;//reinicializar, por que el metodo listar puede ser consultado en más de una ocación

        //Regorre cada elemento de la lista mediante el item
        for (Articulo item : lista) {
            if (item.isActivo()) {
                estado = "Activo";

            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getCategoriaId());
            registro[2] = item.getCategoriaNombre();
            registro[3] = item.getCodigo();//en el indice 3 del objeto item 
            registro[4] = item.getNombre();
            registro[5] = Integer.toString(item.getPrecioVenta());//lo transf. en String el valor decimal para mostrar en el listado
            registro[6] = Integer.toString(item.getStock());
            registro[7] = item.getDescripcion();
            registro[8] = item.getImagen();
            registro[9] = estado;
            this.modeloTabla.addRow(registro);
            this.regMostrados = this.regMostrados + 1;//Contador

        }
        return this.modeloTabla;

    }

    //metodo, retorna un modelo para poder agregarlo al comboBox
    public DefaultComboBoxModel seleccionar() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Categoria> lista = new ArrayList(); //objeto llamado lista de tipo ArrayList
        lista = DATOSCAT.seleccionar();
        //recorre el objeto
        for (Categoria item : lista) {
            items.addElement(new Categoria(item.getId(), item.getNombre()));

        }
        return items;
    }

    //Metodo Insertar
    public String insertar(int categoriaId, String codigo, String nombre, int precioVenta, int stock, String descripcion, String imagen) {
        //Determinamos que el registro no se duplique
        if (DATOS.existe(nombre)) {
            return "Registro existente";
        } else {
            obj.setCategoriaId(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecioVenta(precioVenta);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error de registro";
            }
        }
    }

    //Metodo Actualizar
    public String actualizar(int id, int categoriaId, String codigo, String nombre, String nombreAnt, int precioVenta, int stock, String descripcion, String imagen) {
        //Validamos
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setCategoriaId(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecioVenta(precioVenta);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);

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
                obj.setCategoriaId(categoriaId);
                obj.setCodigo(codigo);
                obj.setNombre(nombre);
                obj.setPrecioVenta(precioVenta);
                obj.setStock(stock);
                obj.setDescripcion(descripcion);
                obj.setImagen(imagen);

                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error de actualizacion";
                }
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
}