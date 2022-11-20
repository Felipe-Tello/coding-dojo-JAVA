public class Bat extends Mammal{
    public Bat() {
        setEnergyLevel(300);
    }

    public void namefly() {
        System.out.println("El murcielago despego "+ (this.getEnergyLevel()-50));
        this.setEnergyLevel(getEnergyLevel()-50);
    }
    public void eatHumans() {
        System.out.println("bueno, no importa "+(this.getEnergyLevel()+25));
        this.setEnergyLevel(getEnergyLevel()+25);
    }
    public void attackTown() {
        System.out.println("sirenas y gritos en la distancia "+(this.getEnergyLevel()-100));
        this.setEnergyLevel(getEnergyLevel()-100);
    }
}
