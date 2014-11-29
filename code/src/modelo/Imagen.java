
package modelo;
  
import java.awt.image.BufferedImage;
import java.io.File; 
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * @author Edwin Alexander
 */

public class Imagen {

    private BufferedImage imagen;
    private String ubicacion;
    
    public Imagen(){
        imagen = null;
    }    
    
    public BufferedImage ObtenerImagen(){
    return imagen;
    }
    
    public String ObtenerUbicacionDeImagen(){
        return ubicacion;
    } 
    
    public BufferedImage CargarImagen(){
        JFileChooser selector=new JFileChooser("C:/");
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("Archivo de Imagen","jpg","png","bmp");
        selector.setFileFilter(filtroImagen);
        int flag=selector.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                //Devuelve el fichero seleccionado
                File imagenSeleccionada=selector.getSelectedFile();
//                System.out.println("La imagen portador se encuentra en : "+imagenSeleccionada);
                ubicacion = imagenSeleccionada.getAbsolutePath();
                //Asignamos a la variable bmp la imagen leida
                imagen = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }         
        }
        return imagen;
    }
    
    public void guardarImagen(BufferedImage imagen) throws IOException{
                javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser("C:/");
                fileChooser.setDialogTitle("Guardar estego imagen");
                int flag = fileChooser.showSaveDialog(null);
		if ( flag == javax.swing.JFileChooser.APPROVE_OPTION) {
			String filename = fileChooser.getSelectedFile().getName();
			if (!filename.endsWith(".bmp")) {
				filename = filename + ".bmp";
			}
			java.io.File file = new java.io.File(fileChooser.getCurrentDirectory().getAbsolutePath() + filename);
                        javax.imageio.ImageIO.write(imagen, "bmp",file);
		}
        }
    
}
