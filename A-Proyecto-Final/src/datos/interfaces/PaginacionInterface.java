
package datos.interfaces;

import java.util.List;

//Una interfaz especifica qué se debe hacer, pero no cómo hacerlo.
//Una vez que se define una interfaz, una o varias clases puede implementarla las que son utilizadas en CrudSimpleInterface y PaginacionInterface
public interface PaginacionInterface<T> {
    
    //Metodos
    public List<T> listar(String texto, int totalPorPagina, int numPagina);
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public boolean desactivar(int id);//desactivar registro
    public boolean activar(int id);//activar registro
    public int total();//total de los registros de la tabla
    public boolean existe(String texto);//si existe un registro en la tabla
    
}
