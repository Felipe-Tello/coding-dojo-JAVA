import java.util.ArrayList;

public class ListaDeExcepciones {
    
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hola Mundo");
        myList.add(48);
        myList.add("Adios Mundo");
        for(int i = 0; i < myList.size(); i++) {
            try {
                int valor = (int) myList.get(i);
                System.out.println(valor);
            } catch (Exception e) {
                System.out.println("ERROR: el valor de tipo Int contiene caracteres no numericos"+e);
            }
        }
    }
}