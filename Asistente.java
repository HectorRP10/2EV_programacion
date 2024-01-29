import java.time.LocalDate;

public class Asistente {
    //Atributos
    private String nombre;
    private String apellidos;
    private String dni;
    private int telefono;
    private LocalDate fecha_nacimiento;
    private String email;

    //Constructores
    Asistente(){}
    public Asistente(String nombre, String apellidos, String dni, int telefono, LocalDate fecha_nacimiento, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
    }

    Asistente(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public  String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }
    public String getDni(){
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public int getTelefono(){
        return telefono;
    }
    public void setTelefono(int telefono){
        this.telefono=telefono;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    //Métodos
    public void info_basica(){
        System.out.println("\t Nombre: "+ this.nombre);
        System.out.println("\t Apellidos: "+ this.apellidos);
        System.out.println("\t DNI: "+ this.dni);
        System.out.println("\t Email: "+ this.email);
    }
    public String toString (){
        return "Nombre: "+nombre+"Apellidos: "+apellidos+"DNI: "+dni+"Email: "+email+"Teléfono: "+telefono+"Fecha nacimiento: "+fecha_nacimiento;
    }
}
