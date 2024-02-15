import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main (String[]args){
        Gestor gestorEventos = new Gestor();
        Scanner sc = new Scanner(System.in);
        String eleccion = "";
        String emailBuscado;
        do {
            System.out.println("***DELECTARE MULTIEVENTOS***");
            System.out.println("---------------------------");
            System.out.println("1. Login");
            System.out.println("2. Registro");
            System.out.println("3. Salir");
            System.out.println("Elige una opción:");
            eleccion = sc.nextLine();
            switch (eleccion) {
                case "1":
                    gestorEventos.info_inicial();
                    emailBuscado=gestorEventos.asistente_login();
                    gestorEventos.gestion_reservas(emailBuscado);
                    break;
                case "2":
                    gestorEventos.asistente_registro();
                    //gestorEventos.gestion_reservas();
                    break;
                case "3":
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Error vuelva a intentarlo");
            }
        }while (!eleccion.equals("3") && !eleccion.equals("2") && !eleccion.equals("1"));
    }
}