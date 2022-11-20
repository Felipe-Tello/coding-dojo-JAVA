public class Ninja extends Human {
    public Ninja() {
        this.setStealth(10);
    }
    public void steal(Human objetivo) {
        objetivo.setHealth(objetivo.getHealth()-this.getStealth());
        this.setHealth(this.getHealth()+this.getStealth());
        System.out.println("el ninja le pego un navajazo a "+ objetivo +" y le robo "+ this.getStealth() +" puntos de salud " );
    }
    public void runAway() {
        this.setHealth(this.getHealth()-10);
        System.out.println("el ninja sale corriendo, su salud disminuye a: "+ this.getHealth());
    }
}
