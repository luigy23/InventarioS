
package datos;
import conexionSQL.Conexion;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class Vendedores {

    private Conexion con;
    private PreparedStatement ps;
    ResultSet rs;

    public Vendedores() {
        ps=null;
        con= new Conexion();

    }

    public void CrearVendedor(String nombre) {
        try {

            ps = con.conectar().prepareStatement("INSERT INTO `vendedor` (`Nombre`) VALUES ('"+nombre+"')");
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, res + " Vendedor se ha creado");

            }

        } catch (SQLException e) {
        } finally {

            con.desconectar();
        }

    }

    public void Traervendedotes() {

        try {

            ps = con.conectar().prepareCall("SELECT * FROM `vendedor`");
            rs = ps.executeQuery();

            if (rs.next()) {

                do {
                    mostrardatos();
                } while (rs.next());

                System.out.println("tengo los vendedores en rs");

            } else {

                System.out.println("no tengo una mondá");
            }

        } catch (SQLException e) {

            System.out.println("hay un error =" + e);
        } finally {
            con.desconectar();

        }

    }

    public void BuscarVendedor(int ID) {
        try {

            ps = con.conectar().prepareStatement("SELECT * FROM vendedor WHERE `IDvendedor` =" + ID);
            rs = ps.executeQuery();
            if (rs.next()) {

                do {
                    mostrardatos();
                } while (rs.next());

                System.out.println("tengo el vendedor con la ID= " + ID + " en rs");
            } else {

                System.out.println("no tengo una mondá");
            }

        } catch (SQLException e) {

            System.out.println("hay un error =" + e);

        } finally {
            con.desconectar();
        }
    }

    public void EditarVendedor(int ID, String nombre) {

        try {
            ps = con.conectar().prepareStatement("UPDATE `vendedor` SET `Nombre` = 'Juanes' WHERE `vendedor`.`IDvendedor` = " + ID);
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, res + " Vendedor se ha Editado");

            }

        } catch (HeadlessException | SQLException e) {

            System.out.println("uy un error en SQL =" + e);
        } finally {
            con.desconectar();
        }

    }

    public void BorrarVendedor(int ID) {

        try {
            ps = con.conectar().prepareStatement("DELETE FROM `vendedor` WHERE `vendedor`.`IDvendedor` = " + ID);
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, res + " Vendedor se ha Borrado");

            }

        } catch (HeadlessException | SQLException e) {

            System.out.println("uy un error en SQL =" + e);
        } finally {
            con.desconectar();
        }

    }

    public void mostrardatos(){
        
                String Dato="nada";
               int Id=0;
        try {
            Dato = rs.getNString("Nombre");
            Id  = rs.getInt("IDvendedor");
           
           
        } catch (SQLException ex) {
            System.out.println("hay un error ="+ ex);
        }
                System.out.println("///////VENDEDORES//////////");
                System.out.println("este es un valor que tengo (" + Dato + ") ID=("+Id+")");

     
    
    }

}
