
package vista;


import modelo.EstegoImagen;
import modelo.ExtraerInformacion;
import modelo.ImagenPortador;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import modelo.ArchivoDeTexto;
import modelo.Imagen;

/**
 *
 * @author Edwin Alexander
 */

public class RevelarInformacion extends javax.swing.JFrame {

    /**
     * Creates new form RevelarInformacion
     */
    public RevelarInformacion() {
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

        seleccionarEstegoImagen = new javax.swing.JLabel();
        cargarEstegoImagen = new javax.swing.JButton();
        ubicacionDeEstegoImagen = new javax.swing.JTextField();
        revelarInformacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        labelNumeroDeCaracteresOcultos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UN - Esteganos");

        seleccionarEstegoImagen.setText("Seleccione la Estego-Imagen");

        cargarEstegoImagen.setText("cargar imagen");
        cargarEstegoImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarEstegoImagenActionPerformed(evt);
            }
        });

        revelarInformacion.setText("Revelar Informacion");
        revelarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revelarInformacionActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        labelNumeroDeCaracteresOcultos.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cargarEstegoImagen)
                                .addGap(12, 12, 12)
                                .addComponent(ubicacionDeEstegoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(seleccionarEstegoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNumeroDeCaracteresOcultos, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(revelarInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(seleccionarEstegoImagen)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cargarEstegoImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ubicacionDeEstegoImagen))
                .addGap(28, 28, 28)
                .addComponent(revelarInformacion)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNumeroDeCaracteresOcultos)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarEstegoImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarEstegoImagenActionPerformed
         Imagen estegoimg = new Imagen();
         BufferedImage estego = estegoimg.CargarImagen();
         ubicacionDeEstegoImagen.setText(estegoimg.ObtenerUbicacionDeImagen());
    }//GEN-LAST:event_cargarEstegoImagenActionPerformed

    
    public static String toChar(String binario){
        int i = Integer.parseInt(binario ,2);
        String aChar = new Character((char)i).toString();
        return aChar;        
    } 
    
    private void revelarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revelarInformacionActionPerformed

        File archivo = new File(ubicacionDeEstegoImagen.getText()); 
        BufferedImage estegoimagen = null;
        try {
            estegoimagen = ImageIO.read(archivo);
        } catch (IOException ex) {
            Logger.getLogger(AlmacenarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }  
        ImagenPortador n = new ImagenPortador();
        LinkedList<Integer> listaDeEstegoImagen = new LinkedList<>();
        ExtraerInformacion ext = new ExtraerInformacion();
        
        int num_componentes = ext.recuperarComponentes(estegoimagen);
        listaDeEstegoImagen = n.convertirImagenEnLista(estegoimagen, num_componentes);
        LinkedList<Integer> bitsOcultos = new LinkedList<>();
        ext.obtenerbitsocultos(listaDeEstegoImagen , bitsOcultos);
        String men = "";
        String mensajefinal = "";
        for (int i = 0; i < bitsOcultos.size(); i++) {
            men = men.concat(String.valueOf(bitsOcultos.get(i)));
            if( men.length()%8 == 0 ){
                mensajefinal = mensajefinal + toChar(men);
                men = "";
            } 
        }
        jTextArea1.setText(mensajefinal);
        labelNumeroDeCaracteresOcultos.setText("El texto tiene "+mensajefinal.length()+" caracteres" );
        
        ArchivoDeTexto arch = new ArchivoDeTexto();
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea guardar este texto en un archivo .txt ?");
        if(respuesta == JOptionPane.YES_OPTION){
            try {
                arch.procesarArchivo(mensajefinal);
            }catch (IOException ex) {
            Logger.getLogger(RevelarInformacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_revelarInformacionActionPerformed

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
            java.util.logging.Logger.getLogger(RevelarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RevelarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RevelarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RevelarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RevelarInformacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarEstegoImagen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelNumeroDeCaracteresOcultos;
    private javax.swing.JButton revelarInformacion;
    private javax.swing.JLabel seleccionarEstegoImagen;
    private javax.swing.JTextField ubicacionDeEstegoImagen;
    // End of variables declaration//GEN-END:variables
}