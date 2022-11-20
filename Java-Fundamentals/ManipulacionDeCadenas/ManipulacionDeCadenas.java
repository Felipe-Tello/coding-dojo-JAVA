/**
 * ManipulacionDeCadenas
 */
public class ManipulacionDeCadenas {
    public void trimAndConcat(String parte1, String parte2){
    String cortar = parte1.trim() + parte2.trim();
    System.out.println(cortar); // HolaMundo
    }

    public int getIndexOrNull(String palabra, char letter){

    int indice = palabra.indexOf(letter);
    return indice;
    }

    public int getIndexOrNull(String palabra1, String palabra2){

    int indice = palabra1.indexOf(palabra2);
    return indice;
    }

    public String concatSubstring(String palabrauno, int uno, int dos, String palabrados){
    
    String indice = palabrauno.substring(uno,dos);
    return indice + palabrados;
    
    }    
}


