import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Rompecabezas {
    
    public int sumaAndMayores(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
    public ArrayList<Integer> mayoresQue(int[] array) {
        ArrayList<Integer> nuevaArray = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 10) {
                nuevaArray.add(array[i]);
            }
        }
        return nuevaArray;    
    }
    public ArrayList<String> nombres(String[] arr) {
        ArrayList<String> nuevaArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nuevaArray.add(arr[i]);
        }
        Collections.shuffle(nuevaArray);
        System.out.println(nuevaArray);
        
        ArrayList<String> nombresLargos = new ArrayList<>();
        for (int i = 0; i < nuevaArray.size(); i++) {
            // System.out.println(nuevaArray.get(i));
            if(nuevaArray.get(i).length() > 5){
                nombresLargos.add(nuevaArray.get(i));
            } 
        }
        System.out.println(nombresLargos);
        return nuevaArray;
    }
    public ArrayList<String> abecedario(String[] arr) {
        ArrayList<String> nuevaArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nuevaArray.add(arr[i]);
        }
        Collections.shuffle(nuevaArray);
        System.out.println(nuevaArray.get(0));
        System.out.println(nuevaArray.get(nuevaArray.size()-1));
        if (nuevaArray.get(0)== "a"){
            System.out.println("esta es una vocal");
        }
        else if (nuevaArray.get(0)== "e"){
            System.out.println("esta es una vocal"); 
        }
        else if (nuevaArray.get(0)== "i"){
            System.out.println("esta es una vocal");
        }
        else if (nuevaArray.get(0)== "o"){
            System.out.println("esta es una vocal");
        }
        else if (nuevaArray.get(0)== "u"){
            System.out.println("esta es una vocal");
        }
        return nuevaArray;
    }
    public ArrayList<Integer> numerosRandom(int numero) {
        Random azar = new Random();
        ArrayList<Integer> arrayNumeros = new ArrayList<>(numero);
        for (int i = 0; i < numero; i++) {
            int numeros = azar.nextInt(101-54)+54;
            arrayNumeros.add(numeros);
        }
        System.out.println(arrayNumeros);
        return arrayNumeros;
    }
    public void NrandomOrden(int numero) {
        Random azar = new Random();
        ArrayList<Integer> arrayNumeros = new ArrayList<>(numero);
        for (int i = 0; i < numero; i++) {
            int numeros = azar.nextInt(101-54)+54;
            arrayNumeros.add(numeros);
        }
        Collections.sort(arrayNumeros);
        System.out.println(arrayNumeros);
        System.out.println(arrayNumeros.get(0));
        System.out.println(arrayNumeros.get(arrayNumeros.size()-1));    
    }
    public void words(String[] arr) {
        ArrayList<String> nuevaArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nuevaArray.add(arr[i]);
        }
        Collections.shuffle(nuevaArray);
        String newWord = (nuevaArray.get(1)+nuevaArray.get(2)+nuevaArray.get(3)+nuevaArray.get(4)+nuevaArray.get(5));
        System.out.println(newWord);
    }
    public void tenWords(String[] arr) {
        ArrayList<String> nuevaArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nuevaArray.add(arr[i]);
        }
        ArrayList<String> arrayAlt = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(nuevaArray);
            String newWord = (nuevaArray.get(1)+nuevaArray.get(2)+nuevaArray.get(3)+nuevaArray.get(4)+nuevaArray.get(5));
            arrayAlt.add(newWord);
        }
        System.out.println(arrayAlt);
    }
}
