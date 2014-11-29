
package modelo;

/**
 *
 * @author Edwin Alexander
 */
 
public class MensajeAOcultar {
    
     public String convertirEnBinario(byte caracter){
        byte byteDeCaracter = (byte)caracter;
        String binario="";
        for( int i = 7; i>=0; i--){
           binario = binario + ( ( ( byteDeCaracter & ( 1<<i ) ) > 0 ) ? "1" : "0" ) ;
        }
        return binario;
    }
    
    public String obtenerMensajeEnBinario(String mensaje){
        String mb = "";
        char[] mensaje_tmp = mensaje.toCharArray();
        for(int i=0; i<mensaje_tmp.length;i++){
            mb = mb + convertirEnBinario( (byte) mensaje_tmp[i]);
        }
        return mb;
    }
    
}
