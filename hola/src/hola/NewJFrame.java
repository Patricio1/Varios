/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */int l=0;
    int bd;
    DefaultTableModel model;
    DefaultTableModel  model0;
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tlista = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tproductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtFacturaCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tlista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "PRECIO", "CANTIDAD"
            }
        ));
        jScrollPane1.setViewportView(Tlista);

        Tproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"P1", "ATUN", "5,60", null},
                {"P2", "JABON", "3,40", null},
                {"P3", "SAL", "2", null},
                {"P4", "FIDEO", "1", null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "PRECIO", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Tproductos);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(64, 64, 64))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFacturaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtFacturaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     InertarUnicaVez();
    }//GEN-LAST:event_jButton1ActionPerformed
  public void InertarUnicaVez(){
    //inciallizamos nuestro banderin el cual sirve para notificar si el producto ya esta o no en lista
      bd=0;
      String codigo,nombre,precio,can;
     //almacenamos indice de fila seleccionada en tabla productos
    int fila= Tproductos.getSelectedRow();
    //contamos el numero de filas que tiene nuestra tabla detalle
     int filas= Tlista.getRowCount();
     //Obtenemos los valores de las repectivas celdas
     //de la tabla productos para pasarlos a la tabla detalle
    codigo=Tproductos.getValueAt(fila, 0).toString();
    nombre=Tproductos.getValueAt(fila, 1).toString();
    precio=Tproductos.getValueAt(fila, 2).toString();
    can=txtFacturaCantidad.getText();

    //declaramos un objeto de tipo DefaultTableModel para
    //poder manipular la tabla Tlista=>tabla detalle
    DefaultTableModel temp = (DefaultTableModel)  Tlista.getModel();
                        Object nuevo[] = {codigo,nombre,can,precio};                      
      try{             
          if(filas==0){
            //si no hay filas en la tabla detalle insertamos nuestro primer registro en ella
              temp.addRow(nuevo);
          }
          //Cuando ya existe filas en la tabla detalle 
          else{
             //recorremos cada fila en de la tabla
              for(int i=0;i<filas;i++){
                  //obtenemos el codigo de producto de cada fila recorrida
          Object tp= Tlista.getValueAt(i, 0);
          //comparamos para verificar si el producto ya esta en lista
          if(codigo.equals(tp)){
              //alertamos que se hallo un producto repetido
              bd=1;
          }
              }
      //si no hay productos repetidos insetar nueva fila en la tabla detalle        
     if(bd==0)
         temp.addRow(nuevo);
     else {
         //notifica que producto ya esta en lista
  JOptionPane.showMessageDialog(null, "existe");
     
     }
       }
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null, " error");
     
     }
  }
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tlista;
    private javax.swing.JTable Tproductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtFacturaCantidad;
    // End of variables declaration//GEN-END:variables
}
