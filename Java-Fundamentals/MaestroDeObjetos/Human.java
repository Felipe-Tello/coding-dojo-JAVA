public class Human {
    private int strength=3;
    private int stealth=3;
    private int intelligence=3;
    private int health=100;
    private int fiambres=0;

    // Getters and Setters
    
    public int getFiambres() {
        return fiambres;
    }
    public void setFiambres(int fiambres) {
        this.fiambres = fiambres;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getStealth() {
        return stealth;
    }
    public void setStealth(int stealth) {
        this.stealth = stealth;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    // Metodos

    public void attack(Human nombre){
        nombre.setHealth(nombre.getHealth()-this.getStrength());
        System.out.println("El siguiente personaje recibio un golpe "+nombre+" y su vida se redujo a: "+nombre.getHealth());
        
    }
}
