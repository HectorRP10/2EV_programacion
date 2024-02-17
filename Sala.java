/**
 * @author Héctor Roviño
 * @since 15/01/2024
 */
import java.util.ArrayList;

public class Sala {
    //Atributos de la clase Sala
    private String nombre;
    private int capacidad_maxima;
    ArrayList<Butaca> lista_butaca=new ArrayList<>();
    private double dimension;
    private boolean accesibilidad;
    private String características_acusticas;
    private String observaciones;

    //Constructor de la clase Sala

    public Sala(String nombre, int capacidad_maxima) {
        this.nombre = nombre;
        this.capacidad_maxima = capacidad_maxima;
    }

    public Sala(String nombre, int capacidad_maxima, ArrayList<Butaca> lista_butaca, double dimension) {
        this.nombre = nombre;
        this.capacidad_maxima = capacidad_maxima;
        this.lista_butaca = lista_butaca;
        this.dimension = dimension;
    }

    public Sala(String nombre, int capacidad_maxima, ArrayList<Butaca> lista_butaca, double dimension, boolean accesibilidad, String características_acusticas, String observaciones) {
        this.nombre = nombre;
        this.capacidad_maxima = capacidad_maxima;
        this.lista_butaca = lista_butaca;
        this.dimension = dimension;
        this.accesibilidad = accesibilidad;
        this.características_acusticas = características_acusticas;
        this.observaciones = observaciones;
    }

    Sala(){}


    // Getter and Setter

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }
    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public ArrayList<Butaca> getLista_butaca() {
        return lista_butaca;
    }

    public void setLista_butaca(ArrayList<Butaca> lista_butaca) {
        this.lista_butaca = lista_butaca;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    public double getDimension() {
        return dimension;
    }
    public boolean isAccesibilidad() {
        return accesibilidad;
    }
    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }
    public String getCaracterísticas_acusticas() {
        return características_acusticas;
    }
    public void setCaracterísticas_acusticas(String características_acusticas) {
        this.características_acusticas = características_acusticas;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    //Métodos


    public void comprobar_capacidad(){
        int capacidad=0;
        if (capacidad>capacidad_maxima){
            System.out.println("Capacidad superior a la disponible");
        } else
            System.out.println("Capacidad correcta");
    }

}