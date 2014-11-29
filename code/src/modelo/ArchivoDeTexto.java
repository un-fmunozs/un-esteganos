
package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin Alexander
 */
public class ArchivoDeTexto {
    
    public void guardarArchivo(String texto, String ruta){   
    //se separa el texto cada salto de linea
    StringTokenizer st = new StringTokenizer(texto,"\n");
    FileWriter fichero = null;
    try{
           fichero = new FileWriter(ruta);
           PrintWriter pw = new PrintWriter(fichero);                               
            //se guarda linea por linea en el archivo
            while(st.hasMoreTokens()){
                String line = st.nextToken();
                pw.println(line);           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            fichero.close();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoDeTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void procesarArchivo(String mensaje) throws IOException{
                javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser("C:/");
                fileChooser.setDialogTitle("Guardar archivo de texto");
                int flag = fileChooser.showSaveDialog(null);
		if ( flag == javax.swing.JFileChooser.APPROVE_OPTION) {
			String filename = fileChooser.getSelectedFile().getName();
                        if (!filename.endsWith(".txt")) {
				filename = filename + ".txt";
			}
			String ruta = fileChooser.getCurrentDirectory().getAbsolutePath() + filename;
                        guardarArchivo(mensaje,ruta);     
		}
        }
}
