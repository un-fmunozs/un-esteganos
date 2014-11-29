  
package modelo;

/*
 * @author Edwin Alexander
 */

public class FFT { 

    public static NumeroComplejo[] fft(NumeroComplejo[] x) {
        int N = x.length;

        // caso base
        if (N == 1) 
            return new NumeroComplejo[] { x[0] };

        // radix 2 Cooley-Tukey FFT
        if (N % 2 != 0) { 
            throw new RuntimeException("N no es una potencia de 2"); 
        }

        // transformada rapida de terminos pares
        NumeroComplejo[] par = new NumeroComplejo[N/2];
        for (int k = 0; k < N/2; k++) {
            par[k] = x[2*k];
        }
        NumeroComplejo[] q = fft(par);

        // transformada rapida de terminos impares
        NumeroComplejo[] impar  = par;  
        for (int k = 0; k < N/2; k++) {
            impar[k] = x[2*k + 1];
        }
        NumeroComplejo[] r = fft(impar);

        // combine
        NumeroComplejo[] y = new NumeroComplejo[N];
        for (int k = 0; k < N/2; k++) {
            double kth = -2 * k * Math.PI / N;
            NumeroComplejo wk = new NumeroComplejo(Math.cos(kth), Math.sin(kth));
            y[k]       = q[k].suma(wk.multiplicacion(r[k]));
            y[k + N/2] = q[k].resta(wk.multiplicacion(r[k]));
        }
        return y;
    }


    // aqui calcula la transformada inversa, asumiendo que la longitud del arreglo es potencia de 2
    public static NumeroComplejo[] ifft(NumeroComplejo[] x) {
        int N = x.length;
        NumeroComplejo[] y = new NumeroComplejo[N];

        // halla el conjugado
        for (int i = 0; i < N; i++) {
            y[i] = x[i].conjugado();
        }
        y = fft(y);

        for (int i = 0; i < N; i++) {
            y[i] = y[i].conjugado();
        }

        // divide por N
        for (int i = 0; i < N; i++) {
            y[i] = y[i].multiplicacion(1.0 / N);
        }
 
        return y;
    }

    public static void mostrar(NumeroComplejo[] x, String titulo) {
        System.out.println(titulo);
        System.out.println("-------------------");
        for (int i = 0; i < x.length; i++) {
            System.out.println("coeficiente ["+i+"] = "+x[i]);
        }
        System.out.println();
    }

}
