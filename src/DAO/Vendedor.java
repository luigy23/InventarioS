

package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;



public class Vendedor{
	private IntegerProperty idVendedor;
	private StringProperty nombre;

	public Vendedor(int idVendedor, String nombre) { 
		this.idVendedor = new SimpleIntegerProperty(idVendedor);
		this.nombre = new SimpleStringProperty(nombre);
	}

	//Metodos atributo: idVendedor
	public int getIdVendedor() {
		return idVendedor.get();
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = new SimpleIntegerProperty(idVendedor);
	}
	public IntegerProperty IdVendedorProperty() {
		return idVendedor;
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
        public static void llenarInformacion(Connection connection, ObservableList<Vendedor> lista){
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT `IDvendedor`,`Nombre_Vendedor` FROM `vendedor`");
			while (resultado.next()){
                            
				lista.add(new Vendedor(
                                        
                                        resultado.getInt("IDvendedor"),
                                        resultado.getString("Nombre_Vendedor")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
    
        
    public String toString() {
        return nombre.get();
    }
        
}