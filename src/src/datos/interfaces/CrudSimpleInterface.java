
package datos.interfaces;

/**
 *
 * @author themartin
 */

import java.util.List;


//Una interfaz especifica qué se debe hacer, pero no cómo hacerlo. 
//Una vez que se define una interfaz, una o varias clases puede implementarla las que son utilizadas en CrudSimpleInterface y PaginacionInterface  
//cada vez que se implemente se le ingresa un objeto, y en base a este objeto realizamos ciertos metodos
public interface CrudSimpleInterface<T> {
    
    //Metodos
    public List<T> listar(String texto);//retorna una lista,permite filtrar a un registro
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public boolean desactivar(int id);//desactivar registro
    public boolean activar(int id);//activar registro
    public int total();//total de los registros de la tabla
    public boolean existe(String texto);//si existe un registro en la tabla
    
}
