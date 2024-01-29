import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private String nombre;
    private String invitado;
    private Sala sala;
    private LocalDate fecha;
    private LocalTime hora;
    private double precio;
    private  String tipo_evento;
    private int numero_asistentes_maximo;
    private String lista_asistentes;

    //Constructor
    Evento(){}
    public Evento(String nombre, String invitado, Sala sala, LocalDate fecha, LocalTime hora, double precio, String tipo_evento, int numero_asistentes_maximo, String lista_asistentes) {
        this.nombre = nombre;
        this.invitado = invitado;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
        this.tipo_evento = tipo_evento;
        this.numero_asistentes_maximo = numero_asistentes_maximo;
        this.lista_asistentes = lista_asistentes;
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getInvitado() {
        return invitado;
    }
    public void setInvitado(String invitado) {
        this.invitado = invitado;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getTipo_evento() {
        return tipo_evento;
    }
    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
    public int getNumero_asistentes_maximo() {
        return numero_asistentes_maximo;
    }
    public void setNumero_asistentes_maximo(int numero_asistentes_maximo) {
        this.numero_asistentes_maximo = numero_asistentes_maximo;
    }
    public String getLista_asistentes() {
        return lista_asistentes;
    }
    public void setLista_asistentes(String lista_asistentes) {
        this.lista_asistentes = lista_asistentes;
    }
}
