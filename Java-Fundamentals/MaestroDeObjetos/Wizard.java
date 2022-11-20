public class Wizard extends Human{
    
    public Wizard() {
        this.setHealth(50);
        this.setIntelligence(8);
    }
    public void heal(Human objetivo) {
        objetivo.setHealth(objetivo.getHealth()+this.getIntelligence());
        System.out.println("el mago realizo el hechizo 'sana,sana potito de rana' a "+objetivo+ "y lo curo "+this.getIntelligence()+" puntos, ahora su salud es de "+objetivo.getHealth());
    }
    public void fireball(Human objetivo) {
        objetivo.setHealth(objetivo.getHealth()-(this.getIntelligence()*3));
        System.out.println("el mago realizo lanzo una molotov a "+objetivo+ " y le provoco "+ (this.getIntelligence()*3)+ " de danio");
    }
}
