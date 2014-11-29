 
package modelo; 

/* 
 * @author Edwin Alexander
 */

public class NumeroComplejo {
    
    private double real;   
    private double imaginario;   

    public NumeroComplejo(double re, double imag) {
        real = re;
        imaginario = imag;
    }

    public double ObtenerReal(){
    return real;
    }
    
    public double ObtenerImaginario(){
    return imaginario;
    }
    
    public void MofificarReal(Double num){
      real = num; 
    }
    
    public void MofificarImaginario(Double num){
      imaginario = num; 
    }
    
    public String toString() {
        if (imaginario == 0) return real + "";
        if (real == 0) return imaginario + "i";
        if (imaginario <  0) return real + " - " + (-imaginario) + "i";
        return real + " + " + imaginario + "i";
    }
    
    public NumeroComplejo suma(NumeroComplejo b) {
        NumeroComplejo a = this;             
        double numreal = a.real + b.real;
        double numimag = a.imaginario + b.imaginario;
        return new NumeroComplejo(numreal, numimag);
    }

    public NumeroComplejo resta(NumeroComplejo b) {
        NumeroComplejo a = this;
        double numreal = a.real - b.real;
        double numimag = a.imaginario - b.imaginario;
        return new NumeroComplejo(numreal, numimag);
    }

    public NumeroComplejo multiplicacion(NumeroComplejo b) {
        NumeroComplejo a = this;
        double numreal = a.real * b.real - a.imaginario * b.imaginario;
        double numimag = a.real * b.imaginario + a.imaginario * b.real;
        return new NumeroComplejo(numreal, numimag);
    }

    public NumeroComplejo multiplicacion(double alpha) {
        return new NumeroComplejo(alpha * real, alpha * imaginario);
    }

    public NumeroComplejo conjugado() {  
        return new NumeroComplejo(real, -imaginario); 
    }

    public static NumeroComplejo suma(NumeroComplejo a, NumeroComplejo b) {
        double numreal = a.real + b.real;
        double numimag = a.imaginario + b.imaginario;
        NumeroComplejo sum = new NumeroComplejo(numreal, numimag);
        return sum;
    }

}
