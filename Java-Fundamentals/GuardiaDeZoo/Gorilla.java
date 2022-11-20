import java.util.Set;

public class Gorilla extends Mammal {

    public void throwSomething(){
        System.out.println("El Gorilla ha lanzado un objeto, su energia diminuye 5 puntos "+(this.getEnergyLevel()-5));
        this.setEnergyLevel(getEnergyLevel()-5);
    }
    public void eatBananas(){
        System.out.println("El Gorilla se comio un bananon esta muy contento, su energia aumenta 10 puntos "+(this.getEnergyLevel()+10));
        this.setEnergyLevel(getEnergyLevel()+10);
    }
    public void climb(){
        System.out.println("El Gorilla se ha subido a in arbol necesita un descanso, su energia diminuye 10 puntos "+(this.getEnergyLevel()-10));
        this.setEnergyLevel(getEnergyLevel()-10);
    }
}
