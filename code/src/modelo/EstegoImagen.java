
package modelo;

import java.awt.Color;
import static modelo.FFT.fft;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import static modelo.FFT.ifft;

/*
 * @author Edwin Alexander
 */ 

public class EstegoImagen {
    
    public EstegoImagen(){
    
    }
    
    public BufferedImage ObtenerEstegoImagen(BufferedImage imagen, LinkedList<Integer> lista){
      int colorRGB;
      int contador = 0;
      boolean salir = false;
      int coloresfaltantes = lista.size()%3;
      int limite = lista.size() - coloresfaltantes;
     for( int i = 0; i < imagen.getWidth(); i++ ){
            for( int j = 0; j < imagen.getHeight(); j++ ){
                if( contador == limite ){
                    if( coloresfaltantes == 2 ){
                        int rojo = lista.get(contador);
                        contador = contador + 1;
                        int verde = lista.get(contador);
                        int azul = 255;
                        colorRGB=(rojo << 16 | verde << 8 | azul);  
                        imagen.setRGB(i, j,colorRGB);
                    }else{
                        if( coloresfaltantes == 1 ){ 
                        int rojo = lista.get(contador);
                        int verde = 255;
                        int azul = 255;
                        colorRGB=(rojo << 16 | verde << 8 | azul);  
                        imagen.setRGB(i, j,colorRGB);
                        }
                    }
                    salir = true;
                }
                if(salir == true){
                   break;
                }
                int rojo = lista.get(contador);
                contador = contador + 1;
                int verde = lista.get(contador);
                contador = contador + 1;
                int azul = lista.get(contador);
                contador = contador + 1;
                colorRGB=(rojo << 16 | verde << 8 | azul);               
                //Asignamos el nuevo valor al BufferedImage
                imagen.setRGB(i, j,colorRGB);
                }
             if(salir == true){
                   break;
                }
            }
     return imagen;
    }
    
    public LinkedList<Integer> modificarComponentesDeLaImagen(LinkedList<Integer> lista,String mensajebinario){
        int index =0;
        int ib=0;
        LinkedList<Integer> nuevaLista = new LinkedList<>();
        NumeroComplejo[] imagen1D = new NumeroComplejo[4];
            for (int i = 0; i < lista.size(); i++) {
            imagen1D[index] = new NumeroComplejo(lista.get(i), 0);
            index++;
            if( index%4 == 0 ){
                NumeroComplejo[] tdf = fft(imagen1D);
                int NuevocoeReal = ModificarNumero(tdf[1].ObtenerReal(),1,mensajebinario.charAt(ib));
                int NuevocoeImag = ModificarNumero(tdf[1].ObtenerImaginario(),1,mensajebinario.charAt(ib+1));
                tdf[1].MofificarReal(NuevocoeReal*1.0);
                tdf[1].MofificarImaginario(NuevocoeImag*1.0);
                tdf[3] = tdf[1].conjugado();
                NumeroComplejo[] inversa = ifft(tdf);
                int coeReal=0;
                for (int j = 0; j <= 3; j++) {
                    coeReal = (int)Math.round(inversa[j].ObtenerReal());
                    if( coeReal < 0 ){
                        coeReal = 0;
                    }else{
                        if( coeReal > 255 ){ 
                            coeReal = 254;
                        }
                    }
                    nuevaLista.add(coeReal);
                }
                index = 0;
                ib = ib + 2;
            }
        }
        return nuevaLista;
    }
    
    public int ModificarNumero(Double real,int delta,char bit){
    int signo = 0;    
    int q_prima = 0;
    int realModificado = 0;
    if( real >= 0.0 ){
            signo = 1; 
    }else{
            signo = -1;
         }
           int q = (int)Math.round(Math.abs(real)/(delta));
            if( q%2 == 0 && bit == '0' ){
                q_prima = q;
            }
            else{
                 if( q%2 != 0 && bit == '0' ){
                     q_prima = q - 1;
                 }   
                 else{
                      if( q%2 != 0 && bit == '1' ){
                           q_prima = q;
                      }
                      else{
                           if( q%2 == 0 && bit == '1' ){
                                  q_prima = q + 1;
                                }
                           }
                    }       
                }    
     realModificado = signo*q_prima*delta;
     return realModificado;
    }
    
    public String convertirComponentes(int num){
        Integer n = num;
        String entero = Integer.toString(n);
        String cad = "";
        for (int i = 0; i < 9-n.toString().length(); i++) {
            cad = cad.concat("0");
        }
        String n_final = cad.concat(entero);
        return n_final;
    }

   public void esconderComponentes(BufferedImage imagen,String numc){
        Color colorImagen;
        int colorRGB=0;
        int rojo = 0,verde =0,azul=0;
        
        colorImagen = new Color(imagen.getRGB(imagen.getWidth()-1, imagen.getHeight()-3));
        rojo = numc.charAt(0)-48;
        verde = numc.charAt(1)-48;
        azul = numc.charAt(2)-48;
        colorRGB=(rojo << 16 | verde << 8 | azul);   
        imagen.setRGB(imagen.getWidth()-1, imagen.getHeight()-3, colorRGB);
        
        colorImagen = new Color(imagen.getRGB(imagen.getWidth()-1, imagen.getHeight()-2));
        rojo = numc.charAt(3)-48;
        verde = numc.charAt(4)-48;
        azul = numc.charAt(5)-48;
        colorRGB=((rojo) << 16 |(verde) << 8 | (azul));   
        imagen.setRGB(imagen.getWidth()-1, imagen.getHeight()-2, colorRGB);
        
        colorImagen = new Color(imagen.getRGB(imagen.getWidth()-1, imagen.getHeight()-1));
        rojo = numc.charAt(6)-48;
        verde = numc.charAt(7)-48;
        azul = numc.charAt(8)-48;
        colorRGB=((rojo) << 16 |(verde) << 8 | (azul));   
        imagen.setRGB(imagen.getWidth()-1, imagen.getHeight()-1, colorRGB);
    } 
    
    
}
