/**
 * @author Héctor Roviño
 * @since 15/01/2024
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    //Atributos de la clase Evento
    private String nombre;
    private Sala sala;
    private LocalDate fecha;
    private LocalTime hora;
    private double precio;
    private  String tipo_evento;
    private int numero_asistentes_maximo;

    //Constructor de la clase Evento
    Evento(){}
    public Evento(String nombre, Sala sala, LocalDate fecha, LocalTime hora, double precio, String tipo_evento, int numero_asistentes_maximo) {
        this.nombre = nombre;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
        this.tipo_evento = tipo_evento;
        this.numero_asistentes_maximo = numero_asistentes_maximo;
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
