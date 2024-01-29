public class Butaca {
    //Atributos
    private String id;
    private boolean accesibilidad;
    private boolean disponibilidad;

    //Constructores
    Butaca(){}
    public Butaca(String id, boolean accesibilidad, boolean disponibilidad) {
        this.id = id;
        this.accesibilidad = accesibilidad;
        this.disponibilidad = disponibilidad;
    }

    //Getter and Setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean isAccesibilidad() {
        return accesibilidad;
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

    public boolean ocupar_butaca(){
        boolean butaca;
        if(butaca=true ){
            System.out.println("Butaca seleccionada");
            return butaca=false;
        }
        return false;
    }
    public boolean desocupar_butaca(){
        boolean butaca;
        if (butaca=false){
            System.out.println("Butaca liberada");
            return butaca=true;
        }
        return true;
    }
}
