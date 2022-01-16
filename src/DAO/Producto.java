
package DAO;

import java.sql.Connection;
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



public class Producto{
	private IntegerProperty idProducto;
	private StringProperty nombre;
	private IntegerProperty stock;
	private IntegerProperty costo;
	private IntegerProperty precio;

	public Producto(int idProducto, String nombre, int stock, 
int costo, int precio) { 
		this.idProducto = new SimpleIntegerProperty(idProducto);
		this.nombre = new SimpleStringProperty(nombre);
		this.stock = new SimpleIntegerProperty(stock);
		this.costo = new SimpleIntegerProperty(costo);
		this.precio = new SimpleIntegerProperty(precio);
	}

	//Metodos atributo: idProducto
	public int getIdProducto() {
		return idProducto.get();
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = new SimpleIntegerProperty(idProducto);
	}
	public IntegerProperty IdProductoProperty() {
		return idProducto;
	}
	//Metodos atributo: nombre
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}
	public StringProperty NombreProperty() {
		return nombre;
	}
	//Metodos atributo: stock
	public int getStock() {
		return stock.get();
	}
	public void setStock(int stock) {
		this.stock = new SimpleIntegerProperty(stock);
	}
	public IntegerProperty StockProperty() {
		return stock;
	}
	//Metodos atributo: costo
	public int getCosto() {
		return costo.get();
	}
	public void setCosto(int costo) {
		this.costo = new SimpleIntegerProperty(costo);
	}
	public IntegerProperty CostoProperty() {
		return costo;
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
        
public static void llenarInformacion(Connection connection, ObservableList<Producto> lista){
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT IDproducto, Nombre_Producto, Stock, Costo, Precio "
                                + "FROM `productos`");
			while (resultado.next()){
                            
				lista.add(new Producto(
                                        resultado.getInt("IDproducto"),
                                        resultado.getString("Nombre_Producto"),
                                        resultado.getInt("Stock"),
                                        resultado.getInt("Costo"),
                                        resultado.getInt("Precio")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
  
    public int  guardarProducto(Connection con){
    
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO productos (Nombre_Producto, Stock, Costo, Precio)"+
                  "  VALUES (?,?,?,?)");

            ps.setNString(1, nombre.get());
            ps.setInt(2, stock.get());
            ps.setInt(3, costo.get());
            ps.setInt(4, precio.get());


                    
                  return  ps.executeUpdate();
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    
    
    }

    public int actualizarProducto(Connection con){

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE `productos` SET "
                    + "`Nombre_Producto` = ?,"
                    + " `Stock` = ?, "
                    + "`Costo` = ?, "
                    + "`Precio` = ?"
                    + " WHERE `productos`.`IDproducto` = ?");


            ps.setNString(1, nombre.get());
            ps.setInt(2, stock.get());
            ps.setInt(3, costo.get());
            ps.setInt(4, precio.get());
            ps.setInt(5, idProducto.get());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    
  
    
    }
    
    @Override
    public String toString() {
        return nombre.get()+" ("+stock.get()+")";
    }
        
}