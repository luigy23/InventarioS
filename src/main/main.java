package main;

import datos.Productos;
import java.util.Scanner;
import static javafx.application.Platform.exit;
import Visuales.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author LUIGY
 */
public class main extends Application{
    

    
    public static void main(String[] args) {
    /* f_Inicio V_inicio;    
     V_inicio =new f_Inicio();
     
     V_inicio.setVisible(true);
     */
    
     launch(args);
            
   
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResource("/Visuales/Inicio.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Escritorio- Organizador");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
            System.out.println("Se supone que inició");
        } catch (Exception e) {
            System.err.println("Hubo un error en el inicio : "+e);
        }


    }
}

      


























/*  Productos pr = new Productos();
        Scanner sc = new Scanner(System.in);

        int opcion = 0;


        
        

        while (opcion!=4){
                System.out.println("0-boorar 1-crear 2-editar- 3-ver 4-salir");
        opcion = sc.nextInt();
          switch (opcion) {

            case 1:
                System.out.println("ingresa nombre:");
                String nombre = sc.next();
                System.out.println("ingresa Stock:");
                int stock = sc.nextInt();
                pr.CrearProducto(nombre, stock, 1000, 3000);
                break;

            case 2:
                System.out.println("ingresa ID:");
                int ID = sc.nextInt();
                pr.buscarproducto(ID);
                System.out.println("nombre:");
                String nombre2 = sc.next();
                System.out.println("ingresa Stock:");
                int stock2 = sc.nextInt();

                pr.editarProducto(nombre2, stock2, 500, 3000, ID);
                
                break;

            case 3:
                pr.traerProductos();
               
                
                break;
            case 0: 
                
                System.out.println("ingresa ID:");
                ID = sc.nextInt();
                
                pr.BorrarProducto(ID);
        }

        }
         
        
    }*/


       
    

