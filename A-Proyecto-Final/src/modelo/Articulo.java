package modelo;

//Clase que contiene los atributos, constructores, toString, set y get de un Articulo
public class Articulo extends Estructura{

    private int categoriaId;
    private String categoriaNombre;
    private String codigo;
    private int precioVenta;
    private int stock;
    private String imagen;
   
    //Contructores
    public Articulo() {
    }

    public Articulo(int id, int categoriaId, String categoriaNombre, String codigo, String nombre, int precioVenta, int stock, String descripcion, String imagen, boolean activo) {
        this.id = id;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
   

    @Override
    public String toString() {
        return "Articulo: " + "id=" + id + ", categoriaId=" + categoriaId + ", categoriaNombre=" + categoriaNombre + ", codigo=" + codigo + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen + ", activo=" + activo + '}';
    }

}
