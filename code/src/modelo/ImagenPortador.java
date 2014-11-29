
package modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
 
/*
 * @author Edwin Alexander
 */

public class ImagenPortador {
    
    public ImagenPortador(){
        
    }    
     
    public LinkedList<Integer> convertirImagenEnLista(BufferedImage imagen,int ncomponentes){
        Color colorImagen;
        LinkedList<Integer> lista = new LinkedList<>();
        int numcomponentes = 0;
        for (int i = 0; i < imagen.getWidth(); i++) {
            for (int j = 0; j < imagen.getHeight(); j++) {  
                  colorImagen = new Color(imagen.getRGB(i, j));
                  lista.add(colorImagen.getRed());
                  numcomponentes = numcomponentes + 1;
                  if( ncomponentes == numcomponentes ){
                      break;//rompo el primer ciclo
                  }
                  lista.add(colorImagen.getGreen());
                  numcomponentes = numcomponentes + 1;
                  if( ncomponentes == numcomponentes ){
                      break;//rompo el primer ciclo
                  }
                  lista.add(colorImagen.getBlue());
                  numcomponentes = numcomponentes + 1;
                  if( ncomponentes == numcomponentes ){
                      break;//rompo el primer ciclo
                  }
            }
             if( ncomponentes == numcomponentes ){
                      break;//rompo el segundo ciclo
                  }
        }
        return lista;  
    }
     
}
