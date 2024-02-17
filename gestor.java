/**
 * @author Héctor Roviño
 * @since 29/01/2024
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;

public class Gestor {
    //Se crean los diferentes arraays
    private ArrayList<Evento> listado_eventos;
    private Sala[] listado_salas;
    private ArrayList<Asistente> listado_asistentes;
    private ArrayList<Reserva> listado_reservas;

    Gestor() {
        listado_eventos = new ArrayList<>();
        listado_salas = new Sala[5];
        listado_asistentes = new ArrayList<>();
        listado_reservas = new ArrayList<>();
        info_inicial();
    }

    //Getters y setters de los arrays
    public ArrayList<Evento> getListado_eventos() {
        return listado_eventos;
    }

    public void setListado_eventos(ArrayList<Evento> listado_eventos) {
        this.listado_eventos = listado_eventos;
    }

    public Sala[] getListado_salas() {
        return listado_salas;
    }

    public void setListado_salas(Sala[] listado_salas) {
        this.listado_salas = listado_salas;
    }

    public ArrayList<Asistente> getListado_asistentes() {
        return listado_asistentes;
    }

    public void setListado_asistentes(ArrayList<Asistente> listado_asistentes) {
        this.listado_asistentes = listado_asistentes;
    }

    public ArrayList<Reserva> getListado_reservas() {
        return listado_reservas;
    }

    public void setListado_reservas(ArrayList<Reserva> listado_reservas) {
        this.listado_reservas = listado_reservas;
    }


    //Método para comprobar si el usuario introducido existe
    private  boolean comprobar_usuario(String emailBuscado, String contrasena) {
        for (Asistente asistente : listado_asistentes) {
            if (asistente.getEmail().equals(emailBuscado) &&asistente.getPassword().equals(contrasena)) {
                return true;
            }
        }
        return  false;
    }

    // Se inicializan y se pone por defecto los arrays, con diferentes ejemplos
    public   void info_inicial(){
        // Crear la lista de asistentes
        listado_asistentes = new ArrayList<>();

        Asistente asistente1 = new Asistente("pol", "soriano garcía", "dd","dd0","01-02-2012","pol@gmail.com","12345678");
        listado_asistentes.add(asistente1);
        Asistente asistente2 = new Asistente("hugo", "aldeguer garcía", "dd","dd0","11-11-2012","hugo@gmail.com","12345679");
        listado_asistentes.add(asistente2);
        Asistente asistente3 = new Asistente("Sara", "Martínez pérez", "dd","dd0","11-11-2012","hugo@gmail.com","12345679");
        listado_asistentes.add(asistente3);

        //Crear lista de evento
        Sala sala = new Sala("Sala 1", 20);
        LocalDate fecha_evento1 = LocalDate.of(2024,05,15);
        LocalTime hora_evento1 = LocalTime.of(18, 30);
        LocalDate fecha_evento2 = LocalDate.of(2024,04,07);
        LocalTime hora_evento2 = LocalTime.of(22, 15);

        listado_eventos= new ArrayList<>();
        Evento evento1 = new Evento("Teatro Caperucita Roja", sala, fecha_evento1, hora_evento1, 25.99, "Teatro", 40);
        listado_eventos.add(evento1);
        Evento evento2 = new Evento("Concierto Luis Fonsi", sala, fecha_evento2, hora_evento2, 25.99, "Concierto", 20);
        listado_eventos.add(evento2);

        //crear listas de reservas
        Butaca butaca = new Butaca("F3",true,true);
        LocalTime hora_reserva1 = LocalTime.of(18, 30);
        LocalDate fecha_reserva1 = LocalDate.of(2024,01,07);
        listado_reservas=new ArrayList<>();
        Reserva reserva1 = new Reserva("1578423loiJUtf*#@",asistente1,evento1,butaca,hora_evento1,fecha_evento1);
        listado_reservas.add(reserva1);
        Reserva reserva2 = new Reserva("4789520asPLrdc@*#",asistente2,evento2,butaca,hora_evento2,fecha_evento2);
        listado_reservas.add(reserva2);
        Reserva reserva3 = new Reserva("8741023ASdfgtQ@#*",asistente1,evento2,butaca,hora_evento2,fecha_evento2);
        listado_reservas.add(reserva3);
    }

    // Método para realizar el login, en el que se debe introducir correctamente el login
    public  String asistente_login(){
       // Obtener el nombre y la contraseña introducido por teclado
       Scanner sc = new Scanner(System.in);
       String emailBuscado;
        int respuesta=0;
       boolean login_correcto=false;
       do {
           System.out.println("***DELECTARE MULTIEVENTOS***");
           System.out.print("Introduce un correo: ");
            emailBuscado = sc.next();
           System.out.println("Introduce la contraseña: ");
           String contrasena = sc.next();

           if (comprobar_usuario(emailBuscado, contrasena)) {
               System.out.println("Bienvenido " + emailBuscado); //Usuario introducido correctamente
               login_correcto=true;
           } else if (Asistente.es_admin(emailBuscado, contrasena)) {
               System.out.println("Has accedido como administrador"); // Acceso como administrador, TODO(implementar acciones especiales)
               login_correcto=true;
           } else {
               System.out.println("Usuario o contraseña incorrecta. Puede ser que no estés registrado, si es así registrese");
               do {   //En caso de error en el login se da la opción de hacer directamente un nuevo registro o reintentar el login
                   System.out.println("1. Si quieres intentar logearte de nuevo ");
                   System.out.println("2. Si quieres hacer un nuevo registro");
                   respuesta = sc.nextInt();
               } while (respuesta!=1 && respuesta!=2);
           }
       }while (!login_correcto && respuesta==1);
        if (!login_correcto && respuesta==2) {
            asistente_registro();
        }
        return emailBuscado;
    }

    //Método que sirve para introducir un nuevo usuario
    public  String asistente_registro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sigue los pasos para crear una cuenta: ");
        String nombre, apellidos, dni, email, contrasena, telefono, fecha_nacimiento ;

        do { //Se pide y se valida el nombre
            System.out.println("Ingrese su nombre:");
            nombre = sc.nextLine();
            if (Validaciones.validar_nombre(nombre)) {
                System.out.println("Nombre introducido correctamente");
            } else {
                System.out.println("Incorrecto, solo se pueden introducir letras, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_nombre(nombre));
        do { //Se piden y se validan los apellidos
            System.out.println("Ingrese sus apellidos:");
            apellidos = sc.nextLine();
            if (Validaciones.validar_nombre(apellidos)) {
                System.out.println("Apellidos introducido correctamente");
            } else {
                System.out.println("Incorrecto, solo se pueden introducir letras, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_nombre(apellidos));
        do { //Se pide y se valida el DNI
            System.out.println("Ingrese su DNI:");
            dni = sc.nextLine();
            if (Validaciones.validar_DNI(dni)) {
                System.out.println("DNI introducido correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_DNI(dni));
        do { //Se pide y se valida el teléfono
            System.out.println("Ingrese su teléfono:");
            telefono = sc.nextLine();
            if (Validaciones.validar_telefono(telefono)) {
                System.out.println("Telefono introducido correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_telefono(telefono));

        do { //Se pide y se valida la fecha de nacimiento, que debe ser mayor de edad
            System.out.println("Introduzca su fecha de nacimiento (dd-mm-yyyy):");
            fecha_nacimiento=sc.nextLine();
            if (Validaciones.validar_fecha(fecha_nacimiento)) {
                System.out.println("Fecha introducida correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_fecha(fecha_nacimiento));

        do { //Se pide y se valida el email
            System.out.println("Ingrese su email:");
            email = sc.nextLine();
            if (Validaciones.validar_correo(email)) {
                System.out.println("Email introducido correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_correo(email));
        do { //Se pide y se valida la contraseña, que debe tener 8 dígitos mínimo
            System.out.println("Introduzca una contraseña para acceder posteriormente al sistema:");
            contrasena= sc.nextLine();
            if (Validaciones.validar_password(contrasena)) {
                System.out.println("Contraseña introducida correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_password(contrasena));
        //Se añade el nuevo usuario al listado de asistentes
        getListado_asistentes().add(new Asistente(nombre,apellidos,dni, telefono, fecha_nacimiento, email, contrasena));
        System.out.println("Bienvenido " + email);
        return email;
    }

    //Método que una vez logeado un usuario, da las opciones de hacer una nueva reserva o ver las ya existentes
    public void gestion_reservas(String email){
        Scanner sc = new Scanner(System.in);
        String eleccion = "";
        do {
            do {
                System.out.println("***DELECTARE MULTIEVENTOS***");
                System.out.println("---------------------------");
                System.out.println("1. Mostrar eventos disponibles");
                System.out.println("2. Mostrar mis reservas");
                System.out.println("3. Salir");
                System.out.println("Elige una opción:");
                eleccion = sc.nextLine();
                switch (eleccion) {
                    case "1":
                        mostrar_eventos();
                        String opcion;
                        do {
                            System.out.println();
                            System.out.println("***DELECTARE MULTIEVENTOS***");
                            System.out.println("1. Hacer nueva reserva");
                            System.out.println("2. Volver atrás");
                            opcion= sc.next();
                            switch (opcion){
                                case "1":
                                    hacer_reserva(email);
                                    hacer_pago();
                                    Validaciones.generar_token();
                                    break;
                                default:
                                    System.out.println("Opción incorrecta, vuelva a intentarlo");
                            }
                        }while (!opcion.equals("2"));
                        break;
                    case "2":
                        mostrar_mis_reservas(email);
                        do {
                            System.out.println("***DELECTARE MULTIEVENTOS***");
                            System.out.println("1.Para volver atrás");
                            opcion= sc.nextLine();
                            switch (opcion){
                                case "1":
                                    break;
                                default:
                                    System.out.println("Opción incorrecta, vuelva a intentarlo");
                            }
                        }while (!opcion.equals("1"));
                        break;
                    case "3":
                        break;
                    default:
                        System.out.println("Seleccion incorrecta vuelva a intentarlo");
                }
            }while (!eleccion.equals("3"));
        }while (!eleccion.equals("3") && !eleccion.equals("2") && !eleccion.equals("1"));
    }

    //Método que muestra todos los eventos programados
    public void mostrar_eventos(){
        // conciertos, cine, teatro, conferencias
        Sala sala = new Sala("Sala 1", 20);
        LocalDate fecha_evento1 = LocalDate.of(2024,05,15);
        LocalTime hora_evento1 = LocalTime.of(18, 30);
        LocalDate fecha_evento2 = LocalDate.of(2024,04,07);
        LocalTime hora_evento2 = LocalTime.of(22, 15);

        listado_eventos= new ArrayList<>();
        Evento evento1 = new Evento("Teatro Caperucita Roja", sala, fecha_evento1, hora_evento1, 25.99, "Teatro", 40);
        listado_eventos.add(evento1);
        Evento evento2 = new Evento("Concierto Luis Fonsi", sala, fecha_evento2, hora_evento2, 25.99, "Concierto", 20);
        listado_eventos.add(evento2);

        for (Evento e : listado_eventos) {
            System.out.println("-----------------------");
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Fecha: " + e.getFecha());
            System.out.println("Hora: " + e.getHora());
            System.out.println("Precio: " + e.getPrecio());
        }
    }

    //Método que recorre el array de reservas para mostrar las de un usuario en concreto
    public void mostrar_mis_reservas(String email) {
        for (Reserva reserva : listado_reservas) {
            if (reserva.getAsistente().getEmail().equals(email)) {
                System.out.println("-----------------------");
                System.out.println("Nombre: " + reserva.getAsistente().getNombre());
                System.out.println("Evento: " + reserva.getEvento().getNombre());
                System.out.println("Butaca: " + reserva.getButaca());
                System.out.println("Fecha: " + reserva.getFecha());
                System.out.println("Hora: " + reserva.getHora());
            }
        }
    }

    //Método para pagar la reserva
    public void hacer_pago(){
        int eleccion = 0;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("Eliga la opción de pago (1-3):");
            System.out.println("1. Bizum");
            System.out.println("2. Paypal");
            System.out.println("3. Transferencia bancaria");
            eleccion = sc.nextInt();
            if (eleccion == 1) {
                System.out.println("Haga el bizum al número de teléfono de la empresa:612345678");
            } else if (eleccion == 2) {
                System.out.println("Pago a través de Paypal");
            } else if (eleccion == 3) {
                // se pide que se ingrese el IBAN y se comprueba que se introduzca bien
                String iban;
                do {
                    System.out.println("Ingrese su número de cuenta(IBAN):");
                    iban = sc.next();
                    if (!Validaciones.validar_iban(iban)) {
                        System.out.println("Error: IBAN no válido.");
                    }
                } while (!Validaciones.validar_iban(iban));


            } else {
                System.out.println("Error,introduzca un número del 1 al 3, vuelva a intentarlo");
            }
        } while (!(eleccion == 1 || eleccion == 2 || eleccion == 3));
    }

    //Proceso de elección de evento y asiento
    public void hacer_reserva(String email){
        String eleccion;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("Seleccione el evento: ");
            System.out.println("1. Caperucita Roja");
            System.out.println("2. Concierto Luis Fonsi");
            eleccion=sc.nextLine();
        }while (!eleccion.equals("1") && !eleccion.equals("2"));

        String asiento;
        do {
            System.out.println("Eliga el asiento:");
            System.out.println("A1 A2 A3 A4 A5 A6");
            System.out.println("B1 B2 B3 B4 B5 B6");
            System.out.println("C1 C2 C3 C4 C5 C6");
            System.out.println("D1 D2 D3 D4 D5 D6");
            System.out.println("E1 E2 E3 E4 E5 E6");
            System.out.println("F1 F2 F3 F4 F5 F6");
            asiento = sc.next().toUpperCase();
            if (Validaciones.validar_asiento(asiento)) {
                System.out.println(Butaca.es_accesible(asiento));
                // Preguntar al usuario si está conforme
                System.out.println("¿Estás conforme con esta butaca? (S/N)");
                String respuesta = sc.next().toUpperCase();
                if (respuesta.equals("S")) {
                    System.out.println("Butaca " + asiento + " elegida correctamente");
                    break; // Salir del bucle
                } else {
                    System.out.println("Butaca no disponible. Seleccione otra butaca");
                }
            } else {
                System.out.println("Error, butaca no disponible");
            }
        }while (true);
    }
}
