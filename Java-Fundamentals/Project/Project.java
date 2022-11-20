public class Project {
    private String nombre;
    private String descripcion;

    // Constructores

    public Project(){
    }
    public Project(String name){
        this.nombre = name;
    }
    public Project(String name, String description){
        this.nombre = name;
        this.descripcion = description;
    }

    // Getters and Setters

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Metodos

    public String elevatorPitch() {
        return "nombre del proyecto: " + nombre + "\n" + "descripcion del proyecto: " + descripcion ;    
    }
 
}
