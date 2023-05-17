
package com.todocodeacademy.login.igu;

import com.todocodeacademy.login.logica.Controladora;
import com.todocodeacademy.login.logica.Usuario;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PrincipalAdmin extends javax.swing.JFrame {
Controladora control;
Usuario usr;
    
    public PrincipalAdmin(Controladora control, Usuario usr) {
        initComponents();
        this.control = control;
        this.usr = usr;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnNuevoUsuario = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnRecargar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNombreUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Sistema Administrador de Usuarios");

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        btnNuevoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnNuevoUsuario.setText("Crear Nuevo Usuario");
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEditar.setText("Editar Usuario");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnBorrar.setText("Borrar Usuario");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnRecargar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRecargar.setText("Recargar Tabla");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtNombreUser.setEditable(false);
        txtNombreUser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreUser.setText("jTextField1");
        txtNombreUser.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNombreUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.txtNombreUser.setText(usr.getNombreUsuario());
        cargarTabla();
        
    }                                 

    private void cargarTabla() {
          //definir el modelo que queremos que tenga la tabla
       DefaultTableModel modeloTabla = new DefaultTableModel () {
       
           //que fila y columnas no sean editables
           @Override
           public boolean isCellEditable (int row, int column) {
               return false;
           }
           
       };
       
       //establecemos los nombres de las columnas
       String titulos[] = {"Id", "Usuario", "Rol"};
       modeloTabla.setColumnIdentifiers(titulos);
       
       //traer de la bd la lista de Usuarios
       List<Usuario> listaUsuarios = control.traerUsuarios();
       
       //preguntamos si la lista está vacía
       if (listaUsuarios!=null) {
           
           //recorrer la lista
           for (Usuario usu : listaUsuarios) {
               Object[] objeto = {usu.getId(), usu.getNombreUsuario(), usu.getUnRol().getNombreRol()};
               
               modeloTabla.addRow(objeto);
           }
             
       }     
       
       tablaUsuarios.setModel(modeloTabla);
    }//GEN-LAST:event_formWindowOpened

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        
        AltaUsuarios altaUsu = new AltaUsuarios(control);
        altaUsu.setVisible(true);
        altaUsu.setLocationRelativeTo(null);
        //this.dispose();
        
        
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
    
        //validar que la tabla tenga elementos
        if (tablaUsuarios.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tablaUsuarios.getSelectedRow()!=-1) {
                
                //obtengo la id del elemento a eliminar
                int id_usuario = Integer.parseInt(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),0)));
           
                //llamo al método borrar
                control.borrarUsuario(id_usuario);
                
                //avisar al usuario que se borró correctamente
                mostrarMensaje ("Se borró el usuario correctamente", "Info", "Eliminación Correcta");
                
                cargarTabla();  
            
            }
            else {
                mostrarMensaje ("No selecciono ningún registro", "Error", "Error al borrar");
            }
        
        }
        else {
            mostrarMensaje ("La tabla está vacía", "Error", "Error al borrar");
        }
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
         //validar que la tabla tenga elementos
        if (tablaUsuarios.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tablaUsuarios.getSelectedRow()!=-1) {
                
                //obtengo la id del elemento a eliminar
                int id_usuario = Integer.parseInt(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),0)));
           
                //llamo a la ventana de edición
                EdicionUsuarios pantallaEdic = new EdicionUsuarios(control,id_usuario);
                pantallaEdic.setVisible(true);
                pantallaEdic.setLocationRelativeTo(null);               
                
                
            }
            else {
                mostrarMensaje ("No selecciono ningún registro", "Error", "Error al editar");
            }
        
        }
        else {
            mostrarMensaje ("La tabla está vacía", "Error", "Error al editar");
        }
        
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
 cargarTabla();
    }//GEN-LAST:event_btnRecargarActionPerformed

 public void mostrarMensaje (String mensaje, String tipo, String titulo) {
       JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
   
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtNombreUser;
    // End of variables declaration//GEN-END:variables
}
