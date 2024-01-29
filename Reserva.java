import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    //Atributos
    private String id;
    private Asistente asistente;
    private Evento evento;
    private Butaca butaca;
    private LocalTime hora;
    private LocalDate fecha;

    //constructor
    Reserva(){}
    public Reserva(String id, Asistente asistente, Evento evento, Butaca butaca, LocalTime hora, LocalDate fecha) {
        this.id = id;
        this.asistente = asistente;
        this.evento = evento;
        this.butaca = butaca;
        this.hora = hora;
        this.fecha = fecha;
    }

    //Getter an Setter

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Asistente getAsistente() {
        return asistente;
    }
    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public Butaca getButaca() {
        return butaca;
    }
    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    //Métodos
    public boolean comprobar_disponibilidad(){
        if (butaca.isDisponibilidad()){
            return true;
        }
        return false;
    }

    public void generar_token(){
        System.out.println("El código de reserva es:");
        int cantidad_letras_numeros = 7;
        int cantidad_caracter = 3;
        for (int contador = 0; contador < cantidad_letras_numeros; contador++) {
            System.out.print((int) (Math.random() * 9));
        }
        for (int contador = 0; contador < cantidad_letras_numeros; contador++) {
            String letra_aleatoria = "aAbcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTvVuUwWxXyYzZ";
            int eleccion_letra_aleatoria = (int) (Math.random() * letra_aleatoria.length());
            System.out.print(letra_aleatoria.charAt(eleccion_letra_aleatoria));
        }
        for (int contador = 0; contador < cantidad_caracter; contador++) {
            String caracter = "!@#$%^&*";
            int eleccion_caracter = (int) (Math.random() * caracter.length());
            System.out.print(caracter.charAt(eleccion_caracter));
        }
    }
    public void reservar_plaza(){
        if(comprobar_disponibilidad()){
            System.out.println("Plaza reservada");
        }else {
            System.out.println("No es posible hacer la reserva");
        }
    }



}
