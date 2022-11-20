public class Mammal {
    private int energyLevel = 100;

    public Mammal() {
    }
    public Mammal(int energy) {
        this.setEnergyLevel(energy);
    }

    // Getters and Setters

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    
    // Metodos

    public int desiplayEnergy() {
        System.out.println(energyLevel);
        return energyLevel;
    }
}
