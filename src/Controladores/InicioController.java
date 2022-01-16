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
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LUIGY
 */
public class InicioController implements Initializable {

    
    //Tabla Registro
    @FXML
    private TableView<Registro> Tbl_Registros;
    @FXML
    private TableColumn<Registro,Integer> Clm_IDRegistro;
    @FXML
    private TableColumn  Clm_Tipo;
    @FXML
    private TableColumn Clm_Producto;
    @FXML
    private TableColumn Clm_Cantidad;
    @FXML
    private TableColumn Clm_Precio;
    @FXML
    private TableColumn Clm_Vendedor;
    @FXML
    private TableColumn<Registro, Date> Clm_Fecha;

    //Tabla Producto
    
    @FXML
    private TableView<Producto> tbl_Productos;
    @FXML
    private TableColumn clm_IdProducto;
    @FXML
    private TableColumn clm_nombreProducto;
    @FXML
    private TableColumn clm_precioProducto;
    @FXML
    private TableColumn clm_CostoProducto;
    @FXML
    private TableColumn clm_stockProducto;
    
    //Botones
    @FXML
    private Button Btn_nuevo;


    
    
    
    //objetos y variables
    Conexion con = new Conexion();
    
    //Listas
    static ObservableList<Producto> listaProducto;
    static ObservableList<Registro> listaRegistro;
    @FXML
    private Tab btap_Registros;
    @FXML
    private Tab btap_Productos;
    @FXML
    private Button Btn_Productos;

     

                                                                                                     ///FALTA INICAR TABLA DE PRODUCTOS
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cargartablas();
        
        con.desconectar();

    }

    @FXML
    private void NuevoRegistro(ActionEvent event) {
        
        
      
        crearventana2("/Visuales/NuevoRegistro.fxml", "Nuevo Registro","r");
     // crearventanaNuevoRegistro();
        

        
        
    }
        @FXML
    private void NuevoProducto(ActionEvent event) {
        crearventana2("/Visuales/NuevoProducto.fxml","Nuevo Producto","p");
    }
    
    
    private void cargartablas(){
            
        




        //inicamos listas
        listaProducto = FXCollections.observableArrayList();
        listaRegistro = FXCollections.observableArrayList();
 

        //llenar listas
        Producto.llenarInformacion(con.conectar(), listaProducto);
        Registro.llenarInfoRegistro(con.conectar(), listaRegistro);
        
        //enlazar a GUI
        tbl_Productos.setItems(listaProducto);
        Tbl_Registros.setItems(listaRegistro);
        
        //mostrar en la GUI
        this.iniciartablaR();
        this.IniciartablaP();
    
    }
    private void iniciartablaR() {
        
        

        //Enlazar atributos a columnas

        Clm_IDRegistro.setCellValueFactory(
                new PropertyValueFactory<Registro, Integer>("idRegistro")
        );
        Clm_Producto.setCellValueFactory(
                new PropertyValueFactory<Registro, Producto>("producto")
        );
        Clm_Tipo.setCellValueFactory(
                new PropertyValueFactory<Registro, String>("tipo")
        );
        Clm_Precio.setCellValueFactory(
                new PropertyValueFactory<Registro, Number>("precio")
        );
        Clm_Cantidad.setCellValueFactory(
                new PropertyValueFactory<Registro, Number>("cantidad")
        );
        Clm_Fecha.setCellValueFactory(
                new PropertyValueFactory<Registro, Date>("fecha")
        );

        Clm_Vendedor.setCellValueFactory(
                new PropertyValueFactory<Registro, Vendedor>("vendedor")
        );
        
        Clm_Vendedor.setCellValueFactory(
                new PropertyValueFactory<Registro, Vendedor>("vendedor")
        );

        

}

    private void IniciartablaP(){
    
            //Enlazar atributos a columnas

        clm_IdProducto.setCellValueFactory(
                new PropertyValueFactory<Producto, Integer>("idProducto")
        );


        clm_nombreProducto.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("nombre")
        );

        clm_stockProducto.setCellValueFactory(
                new PropertyValueFactory<Producto, Number>("stock")
        );
        
         clm_CostoProducto.setCellValueFactory(
                new PropertyValueFactory<Producto, Number>("costo")
        );
              clm_precioProducto.setCellValueFactory(
                new PropertyValueFactory<Producto, Number>("precio")
        );
    }
    
    private void crearventanaNuevoRegistro(){
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Visuales/NuevoRegistro.fxml"));
            Parent root =loader.load();
            NuevoRegistroController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            
            stage.setTitle("Nuevo Registro- Organizador");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException ex) {
                System.out.println("un error:"+ ex);
        }
            
    
    }
    private void crearventana2(String ruta, String titulo,String tipo){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Parent root = loader.load();
                                                                                       //"p" es igual a producto  (tipo)                                                                                 
            if ("p".equals(tipo)) {                                                    //"r" es igual a registro (tipo)
                
                NuevoProductoController controlador = loader.getController();
                
            } else if ("r".equals(tipo)) {
                
                NuevoRegistroController controlador = loader.getController();
                
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException ex) {
             System.out.println("un error:"+ ex);
        }
            
    
    }


}
