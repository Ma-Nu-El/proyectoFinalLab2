
package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    //Declaramos constantes
    
    // Si un driver no funciona pruebe el otro porfavor
    //private final String DRIVER="com.mysql.cj.jdbc.Driver";
    //private final String DRIVER="com.mysql.jdbc.Driver";
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/";
    private final String DB="dbsistema";
    private final String USER="root";
    private final String PASSWORD="";
    
    public Connection cadena;
    public static Conexion instancia;
    
    //Constructor 
    
    private Conexion() {
        this.cadena=null;//inicializamos la variable 
    }
    
    //metodos para conectarse a la bd y otro para desconectarse
    
    public Connection conectar() {
        try {
            Class.forName(DRIVER);
            this.cadena=DriverManager.getConnection(URL+DB,USER,PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;
    }
    
    public void desconectar() {
        
        try {
            this.cadena.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    //Metodo
    public synchronized static Conexion getInstancia() {
        
        if (instancia==null) {
            instancia=new Conexion();
            
        } 
        return instancia;
    }
    
    
}
