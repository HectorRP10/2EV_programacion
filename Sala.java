public class Sala {
    //Atributos
    private String nombre;
    private int capacidad_maxima;
    private String lista_butacas_disponibles;
    private int dimension;
    private boolean accesibilidad;
    private String características_acusticas;
    private String observaciones;

    //Constructor
    Sala(){}
    public Sala(String nombre, int capacidad_maxima, String lista_butacas_disponibles, int dimension, boolean accesibilidad, String características_acusticas, String observaciones) {
        this.nombre = nombre;
        this.capacidad_maxima = capacidad_maxima;
        this.lista_butacas_disponibles = lista_butacas_disponibles;
        this.dimension = dimension;
        this.accesibilidad = accesibilidad;
        this.características_acusticas = características_acusticas;
        this.observaciones = observaciones;
    }


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
    public String getLista_butacas_disponibles() {
        return lista_butacas_disponibles;
    }
    public void setLista_butacas_disponibles(String lista_butacas_disponibles) {
        this.lista_butacas_disponibles = lista_butacas_disponibles;
    }
    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
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
