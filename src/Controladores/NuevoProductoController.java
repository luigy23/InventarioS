/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import DAO.Producto;
import conexionSQL.Conexion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LUIGY
 */
public class NuevoProductoController implements Initializable {

    
    
    //componentes GUI
    @FXML
    private TextField txt_Nombre;
    @FXML
    private TextField txt_Stock;
    @FXML
    private TextField txt_Precio;
    @FXML
    private TextField txt_Costo;
    @FXML
    private Button btn_Guardar;
    @FXML
    private Button btn_Actualizar;
    @FXML
    private Button btn_Eliminar;
    
    
    //creamos objeto de conexion
    Conexion con = new Conexion();
    @FXML
    private TextField txt_Id;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    private void guardarProducto(ActionEvent event) {
    
    //obtemos datos de la GUI
    
    int Stock = Integer.parseInt(txt_Stock.getText()); //Stock
    String Nombre = txt_Nombre.getText();   //Nombre
    int Costo = Integer.parseInt(txt_Costo.getText());
    int Precio = Integer.parseInt(txt_Precio.getText());
    
    //Creamos un Producto
    
    Producto p = new Producto(0,Nombre,Stock,Costo,Precio);
    //Guardamos el Producto en base de datos
    int resultado = p.guardarProducto(con.conectar());
    con.desconectar();
    
        if (resultado == 1) {

           InicioController.listaProducto.add(p);

            Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
            mensaje.setTitle("Producto agregado");
            mensaje.setContentText("El Producto ha sido agregado exitosamente");
            mensaje.show();
            limpiarcampos();

        }
        

    }
        
    private void actualizarProducto(){
    
    
    
    }
    
    private void limpiarcampos(){
        txt_Nombre.setText("");
        txt_Costo.setText("");

        txt_Precio.setText("");
        txt_Stock.setText("");
        txt_Id.setText("");
  
    
    }
}
