public class Samurai extends Human {

    public Samurai() {
        this.setHealth(200);
    }
    
    public void deathBlow(Human objetivo) {
        objetivo.setHealth(objetivo.getHealth()-999);
        this.setHealth(this.getHealth());
        this.setFiambres(this.getFiambres()+1);
        System.out.println("samurai dio un golpe mortal a "+objetivo);

    }
    public void meditate() {
        this.setHealth(this.getHealth()+(this.getHealth()/2));
        System.out.println("El ninja se puso a meditar y recupero "+(this.getHealth()/2)+ "de salud, su salud actual es de "+ this.getHealth());
    }
    public void howMany(){
        System.out.println("el pana se ha pitiado a: "+this.getFiambres()+" personas");
    }

}