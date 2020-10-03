package objeto;

import acceso.Conexion;

import datos.interfaces.PaginacionInterface;
import modelo.Articulo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ArticuloDAO implements PaginacionInterface<Articulo> {

    //Declaramos una cte, de tipo conexion
    private final Conexion CON;//Obj para instanciar a la clase conexion
    private PreparedStatement ps;//compilar una sentencia y enviarlo al motor de bd
    private ResultSet rs;//permite almacenar el resultado de ejecutar
    private boolean resp;

    //Constructor de esta clase
    public ArticuloDAO() {
        this.CON = Conexion.getInstancia();
    }

    //Metodo Listar
    @Override
    public List<Articulo> listar(String texto, int totalPorPagina, int numPagina) {
        List<Articulo> registros = new ArrayList();
        try {
            //union de la tabla articulo con la tabla categoria mediante el campo categoria_id  de la tabla articulo con el id de la tabla categoria
            ps = CON.conectar().prepareStatement("SELECT a.id,a.categoria_id, c.nombre as categoria_nombre, a.codigo, a.nombre, a.precio_venta, a.stock, a.descripcion, a.imagen, a.activo FROM articulo a inner join categoria c ON a.categoria_id=c.id WHERE a.nombre LIKE ? ORDER BY a.id ASC LIMIT ?,?");
            ps.setString(1, "%" + texto + "%");//Primer parametro para el prepareStatement
            ps.setInt(2, (numPagina - 1) * totalPorPagina);//desde que registro comienza a mostrar
            ps.setInt(3, totalPorPagina);//cuantos de van a mostrar
            rs = ps.executeQuery();
            while (rs.next()) {//enviamos en orden los parametros al constructor de la clase articulo
                registros.add(new Articulo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getBoolean(10)));
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
    public boolean insertar(Articulo obj) {
        resp = false;

        try {
            ps = CON.conectar().prepareStatement("INSERT INTO articulo (categoria_id,codigo,nombre,precio_venta,stock,descripcion,imagen,activo) VALUES (?,?,?,?,?,?,?,1)");
            ps.setInt(1,obj.getCategoriaId());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setInt(4, obj.getPrecioVenta());
            ps.setInt(5, obj.getStock());
            ps.setString(6, obj.getDescripcion());
            ps.setString(7, obj.getImagen());

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
    public boolean actualizar(Articulo obj) {

        resp = false;

        try {//enviamos los valores de 
            ps = CON.conectar().prepareStatement("UPDATE articulo SET categoria_id=?, codigo=?, nombre=?, precio_venta=?, stock=?, descripcion=?, imagen=? WHERE id=?");
            ps.setInt(1,obj.getCategoriaId());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setInt(4, obj.getPrecioVenta());
            ps.setInt(5, obj.getStock());
            ps.setString(6, obj.getDescripcion());
            ps.setString(7, obj.getImagen());
            ps.setInt(8, obj.getId());

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
            ps = CON.conectar().prepareStatement("UPDATE articulo SET activo=0 WHERE id=?");
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
            ps = CON.conectar().prepareStatement("UPDATE articulo SET activo=1 WHERE id=?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM articulo");
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
            ps = CON.conectar().prepareStatement("SELECT nombre FROM articulo WHERE nombre=?");
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
