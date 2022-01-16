/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Producto;
import DAO.Registro;
import DAO.Vendedor;
import conexionSQL.Conexion;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author LUIGY
 */
public class NuevoRegistroController implements Initializable {

    
    //componentes GUI

    @FXML
    private TextField txt_Precio;
    @FXML
    private TextField txt_Tipo;
    @FXML
    private TextField txt_cantidad;
    @FXML
    private Button Btn_Guardar;
    

    @FXML
    private ComboBox<Producto> cmb_Producto;
    

    
    
        //Colecciones
    ObservableList<Producto> listaProducto;
    ObservableList<Vendedor> listaVendedor;
    @FXML
    private ComboBox<Vendedor> cmb_Vendedor;
     @FXML
    private ComboBox<String> cmb_Tipo;

    @FXML
    private DatePicker dte_Fecha;

    //creamos objeto de conexion
    Conexion con = new Conexion();
    @FXML
    private Pane Panel;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {



        //inicar listas
        listaProducto = FXCollections.observableArrayList();
        listaVendedor = FXCollections.observableArrayList();
        //llenar listas
        Producto.llenarInformacion(con.conectar(), listaProducto);
        Vendedor.llenarInformacion(con.conectar(), listaVendedor);
        //mostrar items en combox
        cmb_Producto.setItems(listaProducto);
        cmb_Vendedor.setItems(listaVendedor);
        cmb_Tipo.getItems().addAll("Venta","Compra");


        //finalizamos conexion
        con.desconectar();
    }

    Producto p;
    int Cantidad;
    
    @FXML
    private void guardarRegistro(ActionEvent event) {
        
        
        //sacamos la informacion desde los controles de la GUI
    
        String Tipo = cmb_Tipo.getSelectionModel().getSelectedItem(); //sacamos el tipo
        
        
        
        Vendedor v = cmb_Vendedor.getSelectionModel().getSelectedItem(); //Vendedor
        
        int Precio = Integer.parseInt(txt_Precio.getText()); //Precio
        
        Date fecha = Date.valueOf(dte_Fecha.getValue()); //Fecha 
        
        
         Cantidad = Integer.parseInt(txt_cantidad.getText()); //cantidad
         p = cmb_Producto.getSelectionModel().getSelectedItem(); //Obtenemos el Producto Seleccionado
        
        
        ///VENTA O COMPRA
        
         if ("Venta".equals(Tipo)) {
             restarStock();
            
        }else if ("Compra".equals(Tipo)) {
            aumentarStock();
        }else{
            
           

                Alert mensaje = new Alert(AlertType.ERROR);
                mensaje.setTitle("Error");
                mensaje.setContentText("Seleccione El Tipo de Registro");
                mensaje.show();
        
        }
            
            
            

            //creamos un registro         
            Registro r = new Registro(
                    0, p, Tipo, Precio, Cantidad, fecha, v);

            //guardamos el registro
            int resultado = r.guardarRegistro(con.conectar());
            //deconectamos
            con.desconectar();
            //Mostramos Mensaje de Exito
            if (resultado == 1) {

                InicioController.listaRegistro.add(r);

                Alert mensaje = new Alert(AlertType.CONFIRMATION);
                mensaje.setTitle("Registro agregado");
                mensaje.setContentText("El registro ha sido agregado exitosamente");
                mensaje.show();

            }

        } 

    void restarStock(){


        int Stock = p.getStock(); //Obtenemos el Stock del Producto Seleccionado

        if (Stock >= Cantidad) { //verificamos que hay Stock suficiente

            int NvStock = Stock - Cantidad; //restamos la cantidad del Stock 

            p.setStock(NvStock);
            
            p.actualizarProducto(con.conectar());
            con.desconectar();
    
    }else{
        
                Alert mensaje = new Alert(AlertType.ERROR);
                mensaje.setTitle("Error");
                mensaje.setContentText("No hay suficiente Stock!");
                mensaje.show();
        }    


        
    


    

    }
    void aumentarStock(){

        int Stock = p.getStock(); //Obtenemos el Stock del Producto Seleccionado
        int NvStock = Stock + Cantidad; //Sumamos la cantidad del Stock 

        p.setStock(NvStock);

        p.actualizarProducto(con.conectar());
        con.desconectar();


    }
}