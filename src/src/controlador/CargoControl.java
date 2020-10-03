package controlador;

import objeto.CargoDAO;
import modelo.Cargo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

//Clase que controla los datos de la tabla
public class CargoControl {

    private final CargoDAO DATOS;
    private Cargo obj;
    private DefaultTableModel modeloTabla;
    public int regMostrados;

    //Constructor
    public CargoControl() {
        this.DATOS = new CargoDAO();
        this.obj = new Cargo();
        this.regMostrados = 0;
    }

    //Metodo Listar
    public DefaultTableModel listar() {

        List<Cargo> lista = new ArrayList();
        lista.addAll(DATOS.listar());//Lista con todos los registro en un Arraylist

        String[] titulos = {"Id", "Nombre", "Descripcion"};//Columnas de la tabla
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[3];//vector registro de cuatro indices

        this.regMostrados = 0;//reinicializar, por que el metodo listar puede ser consultado en más de una ocación

        //Regorre cada elemento de la lista mediante el item
        for (Cargo item : lista) {

            registro[0] = Integer.toString(item.getId());//convertimos el int a un String
            registro[1] = item.getNombre();
            registro[2] = item.getDescripcion();
            this.modeloTabla.addRow(registro);
            this.regMostrados = this.regMostrados + 1;//Contador

        }
        return this.modeloTabla;

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
