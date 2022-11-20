import java.util.ArrayList;
import java.util.Arrays;
/**
 * EjerciciosBasicos
 */
public class EjerciciosBasicos {

    public void contador(int numero){
        for (int i = 1; i <= numero; i++) {
            System.out.println(i);
        }
    }

    public void impares(int numero){
        for (int i = 1; i <= numero; i++) {
            if(i%2 != 0){
                System.out.println(i);
            }
        }
    }

    public void mostrarSuma(int numero){
        int suma = 0;
        for (int i = 1; i <= numero; i++){
            suma = suma + i;
            System.out.println("nuevo numero: "+i+" suma: "+suma);
        }
    }

    public void recorrer(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public void promedio(int[] array){
        float sum = 0;
        for (int i = 0; i < array.length; i++){
            sum = sum + array[i];
        }
        System.out.println(sum/array.length);
    }

    public void arrImpares(int numero){
        ArrayList<Integer> Y = new ArrayList<Integer>();
        for (int i = 0; i < numero; i++) {
            if (i%2 != 0) {
                Y.add(i);
            }
        }
        System.out.println(Y);
    }

    public void mayorQueY(int[] array, int Y){
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > Y) {
                count +=1;
            }
        }
        System.out.println(count);
    }

    public void elevado(int[] array){
        ArrayList<Double> newArray = new ArrayList<Double>();
        for (int i = 0; i < array.length; i++) {
            double valorelev = Math.pow(array[i],2);
            newArray.add(valorelev);
        }
        System.out.println(newArray);
    }

    public void valorCero(int[] array){
        ArrayList<Integer> arraycero = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i]= 0;
                arraycero.add(array[i]);
            }
            else{
                arraycero.add(array[i]);
            }
        }
        System.out.println(arraycero);
    }

    public void minmaxpro(int[] array){
        ArrayList<Double> tresValores = new ArrayList<>();
        double max = array[0];
        double min = array[0];
        double sum = 0;
        for (int i = 0; i < array.length; i++){
            sum = sum + array[i];
            if (max<array[i]) {
                max=array[i];
            }
            else if (min>array[i]){
                min=array[i];
            }
        }
        tresValores.add(max); 
        tresValores.add(min);
        tresValores.add(sum/array.length);   
        System.out.println(tresValores);
    }

    public void moverIzq(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            array[i]=array[i+1];
        }
        array[array.length-1] = 0;
        System.out.println(Arrays.toString(array));
    }

    public void primos(){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (i%3==0) {
                lista.add(i);
            }
        }
        System.out.println(lista);
    }
}