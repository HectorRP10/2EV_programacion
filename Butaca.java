/**
 * @author Héctor Roviño
 * @since 15/01/2024
 */

public class Butaca {
    //Atributos de la clase Butaca
    private int id;
    private boolean accesibilidad;
    private boolean disponibilidad;
    private String pos;    //por ejemplo(a1,a2,a3)

    //Constructores de la clase Butaca
    Butaca(){}
    public Butaca( String pos, boolean accesibilidad, boolean disponibilidad) {
        this.id = id;
        this.accesibilidad = accesibilidad;
        this.disponibilidad = disponibilidad;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public static  boolean es_accesible(String asiento) {
        if (asiento.equalsIgnoreCase("a1") || asiento.equalsIgnoreCase("a2") || asiento.equalsIgnoreCase("a3") || asiento.equalsIgnoreCase("a4") || asiento.equalsIgnoreCase("a5") || asiento.equalsIgnoreCase("a6")){
            System.out.println("La butaca: "+ asiento+" es accesible");
            return false;
        }
        System.out.println("La butaca: "+ asiento+" no es accesible");
        return true;
    }
    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    //Métodos
    public String toString(){
        return "Butaca:"+id+"Accesibilidad:"+accesibilidad+"Disponible:"+disponibilidad;
    }


}
