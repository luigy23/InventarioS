
package Visuales;
import datos.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
public class f_Inicio extends javax.swing.JFrame {

private Productos pr =new Productos();
private Registro rg =new Registro();
    public f_Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar();
    }
    
    void mostrar() {

        txt_Productos.setText("");
               
        pr.traerProductos();
         txt_Productos.setText(pr.txt); 
           System.out.println("este txt" +pr.txt);
            pr.limpiartxt();
        
}
            
            

        
     
  
        
        
        
        
    
    
    
    
    


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Inicio = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        PanelRegistrp = new javax.swing.JPanel();
        TFStock = new javax.swing.JTextField();
        TfID = new javax.swing.JTextField();
        TFNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Productos = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        PanelProductos = new javax.swing.JPanel();
        TfID3 = new javax.swing.JTextField();
        TFcantidad = new javax.swing.JTextField();
        V_C = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        TfID2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_Inicio.setBackground(new java.awt.Color(153, 153, 153));
        Panel_Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelRegistrp.setBackground(new java.awt.Color(255, 255, 255));
        PanelRegistrp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TFStock.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        TFStock.setText("Stock");
        TFStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFStockActionPerformed(evt);
            }
        });
        PanelRegistrp.add(TFStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 190, 30));

        TfID.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        TfID.setText("ID");
        PanelRegistrp.add(TfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 30));

        TFNombre.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        TFNombre.setText("Nombre");
        TFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFNombreActionPerformed(evt);
            }
        });
        PanelRegistrp.add(TFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 190, 30));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel1.setText("STock");
        PanelRegistrp.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel2.setText("ID");
        PanelRegistrp.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel3.setText("NOmbre");
        PanelRegistrp.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        txt_Productos.setColumns(20);
        txt_Productos.setRows(5);
        jScrollPane1.setViewportView(txt_Productos);

        PanelRegistrp.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 590, 180));

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelRegistrp.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PanelRegistrp.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        PanelRegistrp.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1));

        jButton4.setText("ver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        PanelRegistrp.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jTabbedPane2.addTab("Productos", PanelRegistrp);

        PanelProductos.setBackground(new java.awt.Color(255, 255, 255));
        PanelProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TfID3.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        TfID3.setText("ID");
        PanelProductos.add(TfID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, 30));

        TFcantidad.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        TFcantidad.setText("Cantidad");
        TFcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFcantidadActionPerformed(evt);
            }
        });
        PanelProductos.add(TFcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 190, 30));

        V_C.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "venta", "compra" }));
        PanelProductos.add(V_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        jButton5.setText("Crear registro");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        PanelProductos.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jButton6.setText("boorar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        PanelProductos.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        TfID2.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        TfID2.setText("Registro");
        PanelProductos.add(TfID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 190, 30));

        jTabbedPane2.addTab("Registros", PanelProductos);

        Panel_Inicio.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 610, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFStockActionPerformed
    }//GEN-LAST:event_TFStockActionPerformed

    private void TFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFNombreActionPerformed
    }//GEN-LAST:event_TFNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


//crear

   String nombre= TFNombre.getText();
   int stock= Integer.parseInt(TFStock.getText());

    pr.CrearProducto(nombre, stock , 3000, 5000);




    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

mostrar();


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

//editar
int ID= Integer.parseInt(TfID.getText());
 String nombre= TFNombre.getText();
   int stock= Integer.parseInt(TFStock.getText());
   
   
    pr.editarProducto(nombre, stock, 3000, 5000, ID);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //borrar
        
        int ID= Integer.parseInt(TfID.getText());
        pr.BorrarProducto(ID);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void TFcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFcantidadActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int cantidad = Integer.parseInt(TFcantidad.getText());
        String tipo = (String) V_C.getSelectedItem();
        int Producto = Integer.parseInt(TfID3.getText());

        java.util.Date d = new java.util.Date();
        java.sql.Timestamp date2 = new java.sql.Timestamp(d.getTime());
        rg.CrearRegisto(Producto, tipo, 10000, cantidad, 1, date2);
        
        rg.actualizarstock(Producto, tipo, cantidad);
        

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed


//Borrar registro
int id = Integer.parseInt(TfID2.getText());

rg.BorrarRegistro(id);





    }//GEN-LAST:event_jButton6ActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(f_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(f_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(f_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(f_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new f_Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelProductos;
    private javax.swing.JPanel PanelRegistrp;
    private javax.swing.JPanel Panel_Inicio;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFStock;
    private javax.swing.JTextField TFcantidad;
    private javax.swing.JTextField TfID;
    private javax.swing.JTextField TfID2;
    private javax.swing.JTextField TfID3;
    private javax.swing.JComboBox<String> V_C;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea txt_Productos;
    // End of variables declaration//GEN-END:variables
}
