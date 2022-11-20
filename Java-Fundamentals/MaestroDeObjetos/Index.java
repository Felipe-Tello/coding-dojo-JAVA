public class Index {
    public static void main(String[] args) {
        Human human = new Human();
        Ninja ninja = new Ninja();
        Samurai samurai = new Samurai();
        Wizard wizard = new Wizard();
        human.attack(samurai);  
        wizard.heal(samurai);
        samurai.deathBlow(ninja);
        samurai.deathBlow(ninja);
        samurai.deathBlow(ninja);
        samurai.howMany();
        wizard.fireball(samurai);       
    }
}
