
package modelo;

import java.awt.Color;
import java.awt.image.BufferedImage; 
import static modelo.FFT.fft;
import java.util.LinkedList;

/*
 * @author Edwin Alexander
 */ 

public class ExtraerInformacion {
 
     public void obtenerbitsocultos(LinkedList<Integer> lista,LinkedList<Integer> bitsOcultos) {
        int index = 0;
        NumeroComplejo[] estegoimagen = new NumeroComplejo[4];
        for (int i = 0; i < lista.size(); i++) {
            estegoimagen[index] = new NumeroComplejo(lista.get(i), 0);
            index++;
            if( index%4 == 0 ){
                NumeroComplejo[] tdf = fft(estegoimagen);
                int a = (int)Math.round(tdf[1].ObtenerReal());
                int b = (int)Math.round(tdf[1].ObtenerImaginario());
                if( a%2 == 0 && b%2==0 ){
                    bitsOcultos.add(0);
                    bitsOcultos.add(0);
                }else{
                        if( a%2 == 0 && b%2 !=0 ){
                                bitsOcultos.add(0);
                                bitsOcultos.add(1);
                        }else{
                            if( a%2 != 0 && b%2==0 ){
                                    bitsOcultos.add(1);
                                    bitsOcultos.add(0);
                            }else{
                                 if( a%2 != 0 && b%2 !=0 ){
                                        bitsOcultos.add(1);
                                        bitsOcultos.add(1);
                                    }
                                }
                            }
                    }
                index = 0;
            }
        }
    }
     
    public int recuperarComponentes(BufferedImage imagen) {
        int ncomp=0;
        Color colorImagen;
        int rojo = 0,verde =0,azul=0;
        colorImagen = new Color(imagen.getRGB(imagen.getWidth()-1, imagen.getHeight()-3));
        rojo = colorImagen.getRed()*100000000;
        verde = colorImagen.getGreen()*10000000;
        azul = colorImagen.getBlue()*1000000;
        ncomp = rojo + verde + azul;
        colorImagen = new Color(imagen.getRGB(imagen.getWidth()-1, imagen.getHeight()-2));
        rojo = colorImagen.getRed()*100000;
        verde = colorImagen.getGreen()*10000;
        azul = colorImagen.getBlue()*1000;
        ncomp = ncomp + rojo + verde + azul;
        colorImagen = new Color(imagen.getRGB(imagen.getWidth()-1, imagen.getHeight()-1));
        rojo = colorImagen.getRed()*100;
        verde = colorImagen.getGreen()*10;
        azul = colorImagen.getBlue();
        ncomp = ncomp + rojo + verde + azul;
        return ncomp;
    }  
     
}
