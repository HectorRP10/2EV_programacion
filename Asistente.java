/**
 * @author Héctor Roviño
 * @since 15/01/2024
 */

public class Asistente {
    //Atributos de la clase asistente
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String fecha_nacimiento;
    private String email;
    private String password;
    private boolean esadmin;

    //Constructores de la clase asistente
    Asistente(){}
    public Asistente(String nombre, String apellidos, String dni, String telefono, String fecha_nacimiento, String email, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.password=password;
    }

   Asistente(String nombre, String password) {
        this.nombre = nombre;
        this.password=password;
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
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEsadmin() {
        return esadmin;
    }
    public void setEsadmin(boolean esadmin) {
        this.esadmin = esadmin;
    }

    //Métodos
    public String toString (){
        return "Nombre: "+nombre+"Apellidos: "+apellidos+"DNI: "+dni+"Email: "+email+"Teléfono: "+telefono+"Fecha nacimiento: "+fecha_nacimiento;
    }

    //Método es_admin para comprobar si el usuario logeado es administrador, TODO (entonces concederle permisos especiales)
    public static boolean es_admin(String usuario, String password){
        if (!usuario.equals("admin") || !password.equals("admin")){
            return false;
        }
        return true;
    }
}