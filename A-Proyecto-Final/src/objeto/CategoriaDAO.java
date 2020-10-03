package objeto;

import acceso.Conexion;
import datos.interfaces.CrudSimpleInterface;
import modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO implements CrudSimpleInterface<Categoria> {

    //Declaramos una cte, de tipo conexion
    private final Conexion CON;//Obj para instanciar a la clase conexion
    private PreparedStatement ps;//compilar una sentencia y enviarlo al motor de bd
    private ResultSet rs;//permite almacenar el resultado de ejecutar
    private boolean resp;

    //Constructor de esta clase
    public CategoriaDAO() {
        this.CON = Conexion.getInstancia();
    }

    //Metodo Listar
    @Override
    public List<Categoria> listar(String texto) {
        List<Categoria> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM categoria WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
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

    //Nuevo Metodo para trabajar con comboBox (metodo propio de la clase, que se implementa mediante la interf.)
    public List<Categoria> seleccionar() {
        List<Categoria> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT id, nombre FROM categoria ORDER BY nombre asc");//ORDER BY ordena por el nombre de manera ascendente 

            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Categoria(rs.getInt(1), rs.getString(2)));//Parametos para el id, nombre
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

    //Metodo Insertar
    @Override
    public boolean insertar(Categoria obj) {
        resp = false;

        try {
            ps = CON.conectar().prepareStatement("INSERT INTO categoria (nombre,descripcion,activo) VALUES (?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    //Metodo Actualizar
    @Override
    public boolean actualizar(Categoria obj) {

        resp = false;

        try {
            ps = CON.conectar().prepareStatement("UPDATE categoria SET nombre=?, descripcion=? WHERE id=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getId());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;

    }

    //Metodo Desactivar
    @Override
    public boolean desactivar(int id) {

        resp = false;

        try {
            ps = CON.conectar().prepareStatement("UPDATE categoria SET activo=0 WHERE id=?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;

    }

    //Metodo Activar
    @Override
    public boolean activar(int id) {

        resp = false;

        try {
            ps = CON.conectar().prepareStatement("UPDATE categoria SET activo=1 WHERE id=?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;

    }

    //Metodo Total
    @Override
    public int total() {

        int totalRegistros = 0;

        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM categoria");
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

    //Metodo Existe
    @Override
    public boolean existe(String texto) {

        resp = false;

        try {
            ps = CON.conectar().prepareStatement("SELECT nombre FROM categoria WHERE nombre=?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            rs.last();

            if (rs.getRow() > 0) {
                resp = true;
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
        return resp;

    }

}
