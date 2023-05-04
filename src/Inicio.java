
import java.awt.CardLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author a22luismsg
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /* CREAR OBJETO BD*/
    DAO conexion = new DAO("LuisMiguel", "Palomitas02");

    /* CONTROLADOR */
    private int filasResultSet(ResultSet result) {

        int total = 0;

        try {
            while (result.next()) {
                total++;
            }

            result.first();
        } catch (SQLException e) {
        }

        return total;
    }

    private void mostrarError(String text) {
        JOptionPane.showMessageDialog(this, text, "AVISO", JOptionPane.ERROR_MESSAGE);
    }

    private boolean insertarUsuario(String nombreUsuario, String contraseña, String correo, String fechaNacimiento) {
        return conexion.crearUsuario(nombreUsuario, contraseña, correo, fechaNacimiento);
    }

    private boolean iniciarSesion(String nombre, String contraseña) {
        return conexion.inicioSesión(nombre, contraseña);
    }

    private String getTipoUsuario(String nombreUsuario) {
        return conexion.getTipoUsuario(nombreUsuario);
    }

    private void cambiarVista(String vista) {
        CardLayout card = (CardLayout) panel.getLayout();
        card.show(panel, vista);
    }

    private void rellenarTablaTareas(String nombreUsuario) {

        ResultSet tareas = conexion.getTareasUsuario(nombreUsuario);
        Object datosTabla[][] = new Object[filasResultSet(tareas)][4];

        try {
            /*
            for (int i = 0; i < datosTabla.length; i++) {
                for (int j = 0; i < datosTabla[i].length; i++) {
                    if (tareas.next()) {
                        datosTabla[i][j] = tareas.getString(j + 1);
                    }
                }
            }
            */
            while (tareas.next()) {
                System.out.println("texto" + tareas.getString(1));
                System.out.println("estado" + tareas.getString(2));
                System.out.println("fechaInicio" + tareas.getString(3));
                System.out.println("fechaFin" + tareas.getString(4));

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        tableTareas.setModel(new javax.swing.table.DefaultTableModel(
                datosTabla,
                new String[]{
                    "Estado", "texto", "fecha inicio", "fecha fin"
                }
        ));
    }

    /* VISTA */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        panelInicio = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        contra = new javax.swing.JLabel();
        iniciarUsuario = new javax.swing.JTextField();
        iniciarSesion = new javax.swing.JButton();
        botonCrear = new javax.swing.JButton();
        iniciarPassword = new javax.swing.JPasswordField();
        panelCuenta = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        crearNombreUsuario = new javax.swing.JTextField();
        labelContra = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        crearCorreo = new javax.swing.JTextField();
        crearFechaNacimiento = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        crearCuenta = new javax.swing.JButton();
        crearContraseña = new javax.swing.JPasswordField();
        crearInicioSesión = new javax.swing.JButton();
        panelUsuario = new javax.swing.JPanel();
        UsuarioNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usuarioScrollPanel = new javax.swing.JScrollPane();
        tableTareas = new javax.swing.JTable();
        usuarioCerrarSesion = new javax.swing.JButton();
        usuarioCambiarAdmin = new javax.swing.JButton();
        panelAdmin = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new java.awt.CardLayout());

        titulo.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        titulo.setText("INICIO DE SESIÓN");

        usuario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        usuario.setText("Usuario");

        contra.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        contra.setText("Contraseña");

        iniciarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarUsuarioActionPerformed(evt);
            }
        });

        iniciarSesion.setText("Iniciar Sesión");
        iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionActionPerformed(evt);
            }
        });

        botonCrear.setText("Crear Usuario");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        iniciarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addComponent(titulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuario)
                                    .addComponent(contra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(iniciarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                                    .addComponent(iniciarPassword)))
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                                .addComponent(iniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario)
                    .addComponent(iniciarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contra)
                    .addComponent(iniciarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCrear)
                    .addComponent(iniciarSesion))
                .addGap(66, 66, 66))
        );

        panel.add(panelInicio, "panelInicio");

        labelUsuario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelUsuario.setText("Usuario");

        crearNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearNombreUsuarioActionPerformed(evt);
            }
        });

        labelContra.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelContra.setText("Contraseña");

        labelCorreo.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelCorreo.setText("Correo");

        labelFecha.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelFecha.setText("fechaNacimiento");

        crearCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCorreoActionPerformed(evt);
            }
        });

        crearFechaNacimiento.setText("aaaa-mm-dd");
        crearFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearFechaNacimientoActionPerformed(evt);
            }
        });

        titulo1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        titulo1.setText("Crear Cuenta de Usuario");

        crearCuenta.setText("Crear cuenta");
        crearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCuentaActionPerformed(evt);
            }
        });

        crearInicioSesión.setText("Iniciar Sesión");
        crearInicioSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearInicioSesiónActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuentaLayout = new javax.swing.GroupLayout(panelCuenta);
        panelCuenta.setLayout(panelCuentaLayout);
        panelCuentaLayout.setHorizontalGroup(
            panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo1)
                    .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelCuentaLayout.createSequentialGroup()
                            .addComponent(crearInicioSesión)
                            .addGap(18, 18, 18)
                            .addComponent(crearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelCuentaLayout.createSequentialGroup()
                            .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelFecha)
                                .addComponent(labelUsuario)
                                .addComponent(labelCorreo)
                                .addComponent(labelContra))
                            .addGap(18, 18, 18)
                            .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(crearContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(crearCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(crearNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(crearFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        panelCuentaLayout.setVerticalGroup(
            panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContra))
                .addGap(52, 52, 52)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCorreo))
                .addGap(43, 43, 43)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha))
                .addGap(28, 28, 28)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearCuenta)
                    .addComponent(crearInicioSesión))
                .addGap(24, 24, 24))
        );

        panel.add(panelCuenta, "panelCuenta");

        UsuarioNombre.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        UsuarioNombre.setText("AAA");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel4.setText("TAREAS DE");

        tableTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        usuarioScrollPanel.setViewportView(tableTareas);

        usuarioCerrarSesion.setText("Cerrar Sesión");
        usuarioCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioCerrarSesionActionPerformed(evt);
            }
        });

        usuarioCambiarAdmin.setText("Panel Admin");
        usuarioCambiarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioCambiarAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(UsuarioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(usuarioCambiarAdmin))
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(usuarioScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(usuarioCerrarSesion))
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(UsuarioNombre)
                    .addComponent(usuarioCambiarAdmin))
                .addGap(22, 22, 22)
                .addComponent(usuarioScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(usuarioCerrarSesion))
        );

        panel.add(panelUsuario, "panelLista");

        jToggleButton1.setText("jToggleButton1");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jToggleButton1)
                .addContainerGap(562, Short.MAX_VALUE))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jToggleButton1)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        panel.add(panelAdmin, "panelAdmin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iniciarUsuarioActionPerformed

    private void crearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCuentaActionPerformed
        String nombre = crearNombreUsuario.getText();
        String contraseña = crearContraseña.getText();
        String correo = crearCorreo.getText();
        String fechaNacimiento = crearFechaNacimiento.getText();

        boolean crearUsuarioCorrecto = insertarUsuario(nombre, contraseña, correo, fechaNacimiento);

        if (crearUsuarioCorrecto) {
            cambiarVista("panelInicio");
        } else {
            mostrarError("El usuario no se ha creado con exito");
        }

    }//GEN-LAST:event_crearCuentaActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        cambiarVista("panelCuenta");
    }//GEN-LAST:event_botonCrearActionPerformed

    private void crearNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearNombreUsuarioActionPerformed

    private void crearCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearCorreoActionPerformed

    private void crearFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearFechaNacimientoActionPerformed

    private void iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionActionPerformed
        String nombre = iniciarUsuario.getText();
        String contraseña = iniciarPassword.getText();

        boolean resultado = iniciarSesion(nombre, contraseña);

        if (resultado) {
            rellenarTablaTareas(nombre);
            UsuarioNombre.setText(nombre.toUpperCase());
            usuarioCambiarAdmin.setVisible(getTipoUsuario(nombre).equals("administrador"));
            cambiarVista("panelLista");
            iniciarUsuario.setText("");
            iniciarPassword.setText("");
        } else {
            mostrarError("El Usuario o la Contraseña son incorrectas");
        }

    }//GEN-LAST:event_iniciarSesionActionPerformed

    private void iniciarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iniciarPasswordActionPerformed

    private void usuarioCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioCerrarSesionActionPerformed
        cambiarVista("panelInicio");
    }//GEN-LAST:event_usuarioCerrarSesionActionPerformed

    private void usuarioCambiarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioCambiarAdminActionPerformed
        cambiarVista("panelAdmin");
    }//GEN-LAST:event_usuarioCambiarAdminActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void crearInicioSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearInicioSesiónActionPerformed
        cambiarVista("panelInicio");
    }//GEN-LAST:event_crearInicioSesiónActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UsuarioNombre;
    private javax.swing.JButton botonCrear;
    private javax.swing.JLabel contra;
    private javax.swing.JPasswordField crearContraseña;
    private javax.swing.JTextField crearCorreo;
    private javax.swing.JButton crearCuenta;
    private javax.swing.JTextField crearFechaNacimiento;
    private javax.swing.JButton crearInicioSesión;
    private javax.swing.JTextField crearNombreUsuario;
    private javax.swing.JPasswordField iniciarPassword;
    private javax.swing.JButton iniciarSesion;
    private javax.swing.JTextField iniciarUsuario;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelContra;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelCuenta;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JTable tableTareas;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel usuario;
    private javax.swing.JButton usuarioCambiarAdmin;
    private javax.swing.JButton usuarioCerrarSesion;
    private javax.swing.JScrollPane usuarioScrollPanel;
    // End of variables declaration//GEN-END:variables
}
