/**
 * @author Héctor Roviño
 * @since 15/01/2024
 */
import java.util.Scanner;

public class Main {
    public static void main (String[]args){
        Gestor gestorEventos = new Gestor();
        Scanner sc = new Scanner(System.in);
        String eleccion = "";
        String emailBuscado;
        do { //bucle con 3 opciones, se repetirá hasta elegir una de las tres opciones
            System.out.println("***DELECTARE MULTIEVENTOS***");
            System.out.println("---------------------------");
            System.out.println("1. Login");
            System.out.println("2. Registro");
            System.out.println("3. Salir");
            System.out.println("Elige una opción:");
            eleccion = sc.nextLine();
            switch (eleccion) {
                case "1": // Se inicializa la info_inicial, se hace una instancia del asistente_login y para gestionar las reservas
                    gestorEventos.info_inicial();
                    emailBuscado=gestorEventos.asistente_login();
                    gestorEventos.gestion_reservas(emailBuscado);
                    break;
                case "2": // Se hace instancia para hacer un nuevo registro y gestion de rservas
                    gestorEventos.asistente_registro();
                    emailBuscado=gestorEventos.asistente_registro();
                    gestorEventos.gestion_reservas(emailBuscado);
                    break;
                case "3": //Opción de salir
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Error vuelva a intentarlo");
            }
        }while (!eleccion.equals("3") && !eleccion.equals("2") && !eleccion.equals("1"));
    }
}