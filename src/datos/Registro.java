/*package datos;

import conexionSQL.Conexion;

import java.sql.*;

import javax.swing.JOptionPane;

public class Registro {

    private Productos pr;
    private Conexion con;
    private PreparedStatement ps;
    ResultSet rs;

    public Registro() {
        ps = null;
        con = new Conexion();
        pr = new Productos();
    }

    public void CrearRegisto(int IDproducto, String tipo, int PrecioVenta, int Cantidad, int IDvendedor, Timestamp Fecha) {
        try {

            ps = con.conectar().prepareStatement("INSERT INTO `registros` (`Producto`, `Tipo`, `Precioventa`,"
                    + " `Cantidad`, `Vendedor`, `Fecha`)"
                    + " VALUES ('" + IDproducto + "', '" + tipo + "', '" + PrecioVenta + "', '" + Cantidad + "', '" + IDvendedor + "', '" + Fecha + "')");
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, res + " Registro se ha creado");

            }

        } catch (SQLException e) {

            System.err.println("error: " + e);

        } finally {

            con.desconectar();
        }

    }

    int cantidadAnterior;
    String tipoRegistro;
    String invertido;
    int IDproducto;

    public void RegistroAnterior(int IDregistro) {

        //se recoge el dato RegistroAnterior
        try {
            tipoRegistro = buscarRegistro(IDregistro).getNString("tipo");
            IDproducto = buscarRegistro(IDregistro).getInt("Producto");
            cantidadAnterior = buscarRegistro(IDregistro).getInt("Cantidad");

        } catch (SQLException ex) {
            System.err.println("error: " + ex);
        }

        //se invierte el tipo para restar o sumar
        if ("venta".equals(tipoRegistro)) {
            invertido = "compra";

        } else if ("compra".equals(tipoRegistro)) {
            invertido = "venta";
        }

        actualizarstock(IDproducto, invertido, cantidadAnterior);

    }

    public void BorrarRegistro(int ID) {

        RegistroAnterior(ID);

        try {

            ps = con.conectar().prepareStatement("DELETE FROM `registros` WHERE `registros`.`IDregistro` = " + ID);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, res + " Registro se ha Borrado");

            }

        } catch (SQLException ex) {
            System.out.println("uy un error en SQL =" + ex);
        }

    }

    public ResultSet buscarRegistro(int ID) {

        try {

            ps = con.conectar().prepareStatement("SELECT * FROM `registros` WHERE `IDregistro` =" + ID);
            rs = ps.executeQuery();
            if (rs.next()) {

                System.out.println("tengo el registro con la ID= " + ID + " en rs");
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

    ///Metodos para Productos
    int Stock1;
    int Stock2;

    public void actualizarstock(int ID, String tipo, int Cantidad) {

        try {
            Stock1 = pr.buscarproducto(ID).getInt("Stock");

            JOptionPane.showMessageDialog(null, "Este es el stock1= " + Stock1);
            System.out.println("////////STOCK/////" + Stock1);

        } catch (SQLException ex) {
            System.out.println("hay un error =" + ex);
        }

        if ("venta".equals(tipo)) {
            Stock2 = Stock1 - Cantidad;
            pr.ActualizarStock(ID, Stock2);

        } else if ("compra".equals(tipo)) {
            Stock2 = Stock1 + Cantidad;
            pr.ActualizarStock(ID, Stock2);

        }

        System.out.println("el registro se ha creado Stock actual= " + Stock2);

    }

}
*/