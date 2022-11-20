/**
 * ManipulacionDeCadenas
 */
public class ManipulacionDeCadenasTest{
    public static void main(String[] args) {
        ManipulacionDeCadenas manipulator = new ManipulacionDeCadenas();
        manipulator.trimAndConcat("    Hola     ","     Mundo    ");
    

        char letter = 'n';
        int a = manipulator.getIndexOrNull("Coding", letter);
        int b = manipulator.getIndexOrNull("Hola Mundo", letter);
        int c = manipulator.getIndexOrNull("Saludar", letter);
        System.out.println(a); // 4
        System.out.println(b); // 7
        System.out.println(c); // -1

        String word = "Hola";
        String subString = "la";
        String notSubString = "mundo";
        int auno = manipulator.getIndexOrNull(word, subString);
        int bdos = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(auno); // 2
        System.out.println(bdos); // -1

        String wordy = manipulator.concatSubstring("Hola", 1, 3, "mundo");
        System.out.println(wordy); // olmundo

    }

}
