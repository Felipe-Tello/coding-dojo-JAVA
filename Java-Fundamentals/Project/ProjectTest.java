public class ProjectTest {
    public static void main(String[] args) {
        Project proyecto = new Project();

        System.out.println(proyecto.elevatorPitch());

        Project proyecto2 = new Project("casa de vacaciones");
        System.out.println(proyecto2.elevatorPitch());

        Project proyecto3 = new Project("farola","holamundoasadasd");
        System.out.println(proyecto3.elevatorPitch());
    }
}
