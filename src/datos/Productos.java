package datos;

import conexionSQL.Conexion;
import java.awt.HeadlessException;
import java.sql.*;

import javax.swing.JOptionPane;

public class Productos {

    private Conexion con;
    private PreparedStatement ps;
    ResultSet rs;
    
    
    // datos del Producto
    
    
    private String nombre;
    private int IDproducto;
    private int Stock;
    private int Costo;
    private int precio;      
    
    
    

    public Productos() 
   {
        ps = null;
        con = new Conexion();

    }

//METODOS PARA LLAMAR PRODUCTOS    
    public ResultSet traerProductos()
    {

        try {

            ps = con.conectar().prepareCall("SELECT * FROM `productos`");
            rs = ps.executeQuery();

            if (rs.next()) {

                do {
                    mostrartxt();
                } while (rs.next());

                System.out.println("tengo los productos en rs");

            } else {

                System.out.println("no tengo una mondá");
            }

        } catch (SQLException e) {

            System.out.println("hay un error =" + e);
        } finally {
            con.desconectar();

        }

        return rs;

    }

    public ResultSet buscarproducto(int ID) 
    {

        try {

            ps = con.conectar().prepareStatement("SELECT * FROM `productos` WHERE `IDproducto` =" + ID);
            rs = ps.executeQuery();
            if (rs.next()) {

                System.out.println("tengo el producto con la ID= " + ID + " en rs");
            } else {

                System.out.println("no tengo una mondá");
            }

        } catch (SQLException e) {

            System.out.println("hay un error =" + e);

        } finally {
            con.desconectar();
        }

        return rs;
    }

//METODOS PARA INTERACTUAR CON INTERFAZ
    public String txt;
    String Textodespues;

    public void mostrartxt()
    {

        try {
            String Nombre = rs.getString("Nombre");

            int Stock = rs.getInt("Stock");

            int ID = rs.getInt("IDproducto");

            String Textoantes = "\n " + ID + " " + Nombre + " " + Stock + "\n ";

            Textodespues = Textodespues + Textoantes;
        } catch (SQLException e) {
            System.out.print("eroor= " + e);
        }

        txt = Textodespues;

    }

    public void limpiartxt()
    {

        txt = "";
        Textodespues = "";

    }

    //METODOS DE CRUD
    public void CrearProducto(String nombre, int Stock, int Costo, int Precio) {

        try {

            ps = con.conectar().prepareStatement("INSERT INTO `productos` (`Nombre`, `Stock`, `Costo`, `Precio`)"
                    + " VALUES ('" + nombre + "', '" + Stock + "', '" + Costo + "', '" + Precio + "');");

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, res + " Producto se ha creado");

            }

        } catch (HeadlessException | SQLException e) {
            System.out.println("uy un error en SQL =" + e);
        } finally {

            con.desconectar();
        }

    }

    public void editarProducto(String nombre, int Stock, int Costo, int Precio, int id) {

        try {

            ps = con.conectar().prepareStatement("UPDATE `productos` "
                    + "SET `Nombre` = '" + nombre + "', `Stock` = '" + Stock + "', `Costo` = '" + Costo + "', `Precio` = '" + Precio + "' "
                    + "WHERE `productos`.`IDproducto` = " + id);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, res + " Producto se ha Editado");

            }

        } catch (HeadlessException | SQLException e) {

            System.out.println("uy un error en SQL =" + e);
        }

    }

    public void BorrarProducto(int ID) {

        try {
            ps = con.conectar().prepareStatement("DELETE FROM `productos` WHERE `productos`.`IDproducto` = " + ID);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, res + " Producto se ha Borrado");

            }

        } catch (SQLException ex) {
            System.out.println("uy un error en SQL =" + ex);
        }

    }
    
    
    //METODOS PARA REGISTRO

    public void ActualizarStock(int ID, int Stock) {

        try {
            ps = con.conectar().prepareStatement("UPDATE `productos` SET `Stock` = '" + Stock + "' WHERE `productos`.`IDproducto` = " + ID);

            int res = ps.executeUpdate();

            if (res > 0) {
                System.out.println("Se ha actualizado el Stock");

            }

        } catch (SQLException ex) {
            System.out.println("uy un error en SQL =" + ex);
        }

    }
    
    
    
    
}
