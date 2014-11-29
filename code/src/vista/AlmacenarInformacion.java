
package vista;


import modelo.EstegoImagen;
import modelo.ImagenPortador;
import modelo.MensajeAOcultar;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import modelo.Imagen;

/**
 *
 * @author Edwin Alexander
 */
public class AlmacenarInformacion extends javax.swing.JFrame {

  
    /**
     * Creates new form AlmacenarInformacion
     */
    public AlmacenarInformacion() {
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

        cargarImagenPortador = new javax.swing.JButton();
        seleccionarArchivoPortador = new javax.swing.JLabel();
        ubicacionDeImagenPortador = new javax.swing.JTextField();
        ingresarMensajeAOcultar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensajeDeTextoAOcultar = new javax.swing.JTextArea();
        ejecutar = new javax.swing.JButton();
        labelcapacidad = new javax.swing.JLabel();
        capacidadMaxima = new javax.swing.JLabel();
        botonContarCaracteres = new javax.swing.JButton();
        labelNumeroDeCaracteres = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UN - Esteganos");

        cargarImagenPortador.setText("cargar imagen");
        cargarImagenPortador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarImagenPortadorActionPerformed(evt);
            }
        });

        seleccionarArchivoPortador.setText("Seleccione el archivo Portador");

        ubicacionDeImagenPortador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubicacionDeImagenPortadorActionPerformed(evt);
            }
        });

        ingresarMensajeAOcultar.setText("Ingrese el Mensaje a Ocultar");

        mensajeDeTextoAOcultar.setColumns(20);
        mensajeDeTextoAOcultar.setRows(5);
        jScrollPane1.setViewportView(mensajeDeTextoAOcultar);

        ejecutar.setText("ocultar informacion");
        ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarActionPerformed(evt);
            }
        });

        labelcapacidad.setText(" ");

        capacidadMaxima.setText("   ");

        botonContarCaracteres.setText("contar caracteres");
        botonContarCaracteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContarCaracteresActionPerformed(evt);
            }
        });

        labelNumeroDeCaracteres.setText("  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seleccionarArchivoPortador, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresarMensajeAOcultar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(cargarImagenPortador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ubicacionDeImagenPortador))
                            .addComponent(capacidadMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelcapacidad))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(botonContarCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelNumeroDeCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(seleccionarArchivoPortador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cargarImagenPortador)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ubicacionDeImagenPortador)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcapacidad)
                    .addComponent(capacidadMaxima))
                .addGap(18, 18, 18)
                .addComponent(ingresarMensajeAOcultar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonContarCaracteres)
                    .addComponent(labelNumeroDeCaracteres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ejecutar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
        String mensaje = mensajeDeTextoAOcultar.getText();
        File archivo = new File(ubicacionDeImagenPortador.getText());
        BufferedImage imagenDeCobertura = null;
        try { 
            imagenDeCobertura = ImageIO.read(archivo);
        }catch (IOException ex) {
            Logger.getLogger(AlmacenarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        int capacidadMaximaDeAlmacenamiento = ((imagenDeCobertura.getWidth()*imagenDeCobertura.getHeight()*3-9)/16);
        if( mensaje.length() > capacidadMaximaDeAlmacenamiento  ){
            JOptionPane.showMessageDialog(null,"Su texto supera la capacidad maxima de almacenamiento de la imagen."
            + "\nDebe reducir el numero de caracteres",
            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }else{
        ImagenPortador o = new ImagenPortador();
        MensajeAOcultar m = new MensajeAOcultar();
        String mensajebinario = m.obtenerMensajeEnBinario(mensaje);
        int numcomponentes = mensajebinario.length()*2;
        LinkedList<Integer> lista = o.convertirImagenEnLista(imagenDeCobertura,numcomponentes);
        EstegoImagen est = new EstegoImagen();
        String n_componentes = est.convertirComponentes(numcomponentes);
        LinkedList<Integer> nuevaLista = est.modificarComponentesDeLaImagen(lista, mensajebinario);
        BufferedImage estego = est.ObtenerEstegoImagen(imagenDeCobertura, nuevaLista);
        est.esconderComponentes(estego, n_componentes);
        Imagen img = new Imagen();
        try { 
            img.guardarImagen(estego);
        }catch (IOException ex) {
            Logger.getLogger(AlmacenarInformacion.class.getName()).log(Level.SEVERE, null, ex);
          } 
        }
    }//GEN-LAST:event_ejecutarActionPerformed

    private void cargarImagenPortadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarImagenPortadorActionPerformed
         Imagen imgportador = new Imagen();
         BufferedImage imagenPortador = imgportador.CargarImagen();
         ubicacionDeImagenPortador.setText(imgportador.ObtenerUbicacionDeImagen());
         String capacidadmaxima = Integer.toString((imagenPortador.getWidth()*imagenPortador.getHeight()*3-9)/16);
         capacidadMaxima.setText("Capacidad maxima de almacenamiento de la imagen : "+capacidadmaxima+" caracteres");
    }//GEN-LAST:event_cargarImagenPortadorActionPerformed

    private void ubicacionDeImagenPortadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubicacionDeImagenPortadorActionPerformed
         
    }//GEN-LAST:event_ubicacionDeImagenPortadorActionPerformed

    private void botonContarCaracteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContarCaracteresActionPerformed
        labelNumeroDeCaracteres.setText("Su texto tiene "+mensajeDeTextoAOcultar.getText().length()+" caracteres");
    }//GEN-LAST:event_botonContarCaracteresActionPerformed

    
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
            java.util.logging.Logger.getLogger(AlmacenarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlmacenarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlmacenarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlmacenarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlmacenarInformacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonContarCaracteres;
    private javax.swing.JLabel capacidadMaxima;
    private javax.swing.JButton cargarImagenPortador;
    private javax.swing.JButton ejecutar;
    private javax.swing.JLabel ingresarMensajeAOcultar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNumeroDeCaracteres;
    private javax.swing.JLabel labelcapacidad;
    private javax.swing.JTextArea mensajeDeTextoAOcultar;
    private javax.swing.JLabel seleccionarArchivoPortador;
    private javax.swing.JTextField ubicacionDeImagenPortador;
    // End of variables declaration//GEN-END:variables
}