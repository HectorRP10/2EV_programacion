import java.util.Scanner;

public class Main {
    public static void main (String[]args){
        System.out.println("***DEECTARE MULTIEVENTOS***");
        System.out.println("---------------------------");
        System.out.println("1. Seleccionar evento");
        System.out.println("2. Información de reserva");
        System.out.println("3. Salir");
        String eleccion="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Elige una opción:");
        eleccion=sc.nextLine();
        switch (eleccion){
            case "1":
                System.out.println("Has elegido seleccionar evento");
                break;
            case "2":
                System.out.println("Has elegido información de reserva");
                break;
            case "3":
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("Error vuelva a intentarlo");
        }


    }
}