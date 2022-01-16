package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author LUIGY
 */
public class Registro {

    private IntegerProperty idRegistro;
    private Producto producto;
    private StringProperty tipo;
    private IntegerProperty precio;
    private IntegerProperty cantidad;
    private Date fecha;
    private Vendedor vendedor;



    public Registro(int idRegistro, Producto producto, String tipo,
            int precio, int cantidad, Date fecha,
            Vendedor vendedor) {
        this.idRegistro = new SimpleIntegerProperty(idRegistro);
        this.producto = producto;
        this.tipo = new SimpleStringProperty(tipo);
        this.precio = new SimpleIntegerProperty(precio);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.fecha = fecha;
        this.vendedor = vendedor;
    

    }

    //Metodos atributo: idRegistro
    public int getIdRegistro() {
        return idRegistro.get();
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = new SimpleIntegerProperty(idRegistro);
    }

    public IntegerProperty IdRegistroProperty() {
        return idRegistro;
    }
    //Metodos atributo: producto

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    //Metodos atributo: tipo

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo = new SimpleStringProperty(tipo);
    }

    public StringProperty TipoProperty() {
        return tipo;
    }
    //Metodos atributo: precio

    public int getPrecio() {
        return precio.get();
    }

    public void setPrecio(int precio) {
        this.precio = new SimpleIntegerProperty(precio);
    }

    public IntegerProperty PrecioProperty() {
        return precio;
    }
    //Metodos atributo: cantidad

    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(int cantidad) {
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    public IntegerProperty CantidadProperty() {
        return cantidad;
    }
    //Metodos atributo: fecha

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    //Metodos atributo: vendedor

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    
    
    public static void llenarInfoRegistro(Connection con,ObservableList<Registro> lista){
    
        try {
            Statement ps = con.createStatement();
            ResultSet resultado = ps.executeQuery(
                   
                                                    "SELECT A.IDregistro,\n" +
                                "A.Producto,\n" +
                                "A.Tipo,\n" +
                                "A.Precioventa,\n" +
                                "A.Cantidad,\n" +
                                "A.Vendedor,\n" +
                                "A.Fecha,\n" +
                                "B.IDproducto,\n" +
                                "B.Nombre_Producto,\n" +
                                "B.Stock,\n" +
                                "B.Costo,\n" +
                                "B.Precio,\n" +
                                "C.IDvendedor,\n" +
                                "C.Nombre_Vendedor \n" +
                                "FROM registros A \n" +
                                "INNER JOIN productos B ON(A.Producto = B.IDproducto) \n" +
                                "INNER JOIN vendedor C ON(A.Vendedor=C.IDvendedor)"
                                            );
            
            while (resultado.next()) {               
                
                lista.add(new Registro(
                
                        resultado.getInt("IDregistro"), 
                        new Producto(
                        
                                resultado.getInt("IDproducto"),resultado.getNString("Nombre_Producto"),
                                resultado.getInt("Stock"),resultado.getInt("Costo"),
                                resultado.getInt("Precio")                               
                        ),
                        resultado.getString("Tipo"),
                        resultado.getInt("Precioventa"),
                        resultado.getInt("Cantidad"),
                        
                        resultado.getDate("Fecha"),
                        
                        new Vendedor(
                                
                                resultado.getInt("IDvendedor"), resultado.getNString("Nombre_Vendedor")
                                
                        )));
                      
                
                
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    public int  guardarRegistro(Connection con){
    
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO registros (`Producto`, `Tipo`, `Precioventa`, `Cantidad`, `Vendedor`, `Fecha`) "
                    + "VALUES (?, ?, ?, ?, ?, ?)");
            
                    ps.setInt(1, producto.getIdProducto());
                    ps.setString(2, tipo.get());
                    ps.setInt(3, precio.get());
                    ps.setInt(4, cantidad.get());
                    ps.setInt(5, vendedor.getIdVendedor());
                    ps.setDate(6, fecha);
                    
                  return  ps.executeUpdate();
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    
    
    }
    
    
}
