package objeto;

import acceso.Conexion;
import modelo.Cargo;//entidad importada
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CargoDAO {
    //cargos solo se visualiza

    private final Conexion CON;//Obj para instanciar a la clase conexion
    private PreparedStatement ps;//compilar una sentencia y enviarlo al motor de bd
    private ResultSet rs;//permite almacenar el resultado de ejecutar
    private boolean resp;

    //Constructor
    public CargoDAO() {
        CON = Conexion.getInstancia();

    }

    //Metodo Listar
    public List<Cargo> listar() {
        List<Cargo> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM Cargo");//seleccionar datos de tablas en MySQL. Usamos el comando SELECT * FROM table_cargo para seleccionar todas las columnas de esa tabla.

            rs = ps.executeQuery();
            while (rs.next()) {//creamos el arraylist util el constructor y sus parametros
                registros.add(new Cargo(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();//nos desconectamos de la bd

        }
        return registros;
    }

    //Metodo Seleccionar
    public List<Cargo> seleccionar() {//retorna una lista y cada elemento será de tipo Cargo
        List<Cargo> registros = new ArrayList();
        try {//seleccionamos el id, nombre de la tabla Cargo y las ordenamos por el nombre de forma ascendente
            ps = CON.conectar().prepareStatement("SELECT id, nombre FROM categoria ORDER BY nombre asc");

            rs = ps.executeQuery();
            while (rs.next()) {//Llamamos a la entiad Cargo y su constructor enviando un valor al id, nombre
                registros.add(new Cargo(rs.getInt(1), rs.getString(2)));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();//nos desconectamos de la bd

        }
        return registros;
    }

    //Metodo Total
    public int total() {

        int totalRegistros = 0;

        try {//contamos el id de la tabla Cargo
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM Cargo");
            rs = ps.executeQuery();

            while (rs.next()) {
                totalRegistros = rs.getInt("COUNT(id)");

            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return totalRegistros;

    }

}

//Informacion: SELECT * FROM table_name
//https://dyclassroom.com/mysql/mysql-select-from-table
//https://www.tutorialrepublic.com/sql-tutorial/sql-select-statement.php
