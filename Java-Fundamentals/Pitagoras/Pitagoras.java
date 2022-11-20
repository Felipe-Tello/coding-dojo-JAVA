public class Pitagoras {
    public double calcularHipotenusa(double catetoA, double catetoB) {
        double c;
        double a = catetoA;
        double b = catetoB;
        c = Math.sqrt(a*a+b*b);
        System.out.println(c);
        return c;
        //La hipotenusa es el lado opuesto del ángulo recto.
        //Calcular el valor de c dados los valores catetoA y catetoB
    }
}
 

