import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalTime;
public class Gestor {
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


   /*void info_inicial(){

        for (int i=0;i<5;i++){
            System.out.println("Sala"+i);
            //generar butacas

            ArrayList<Butaca> misbutacas=new ArrayList<>();
            for (char fila='A'; fila<='F'; fila++){
                for (int columna=1;columna<=6;columna++){
                    identificador++;
                    String pos=fila+columna+"";
                    System.out.println(fila+""+columna);
                    misbutacas.add(new Butaca(identificador,pos,));
                }
                listado_salas[i]=new Sala("Sala 1", 200, misbutacas,  100.0 );
            }
        }
   }
    */


    private  boolean comprobar_usuario(String emailBuscado, String contrasena) {
        for (Asistente asistente : listado_asistentes) {
            if (asistente.getEmail().equals(emailBuscado) &&asistente.getPassword().equals(contrasena)) {
                return true;
            }
        }
        return  false;
    }
    public   void info_inicial(){
        // Crear la lista de asistentes
        listado_asistentes = new ArrayList<>();
        listado_asistentes.add(new Asistente("pol", "soriano garcía", "dd","dd0","01-02-2012","pol@gmail.com","12345678"));
        listado_asistentes.add(new Asistente("hugo", "aldeguer garcía", "dd","dd0","11-11-2012","hugo@gmail.com","12345679"));
        listado_asistentes.add(new Asistente("Sara", "Martínez pérez", "dd","dd0","11-11-2012","hugo@gmail.com","12345679"));
    }
    public  void asistente_login(){
       // Obtener el nombre y la contraseña introducido por teclado
       Scanner sc = new Scanner(System.in);
       int respuesta=0;
       boolean login_correcto=false;
       do {
           System.out.println("***DELECTARE MULTIEVENTOS***");
           System.out.print("Introduce un correo: ");
           String emailBuscado = sc.next();
           System.out.println("Introduce la contraseña: ");
           String contrasena = sc.next();

           if (comprobar_usuario(emailBuscado, contrasena)) {
               System.out.println("Bienvenido " + emailBuscado);
               login_correcto=true;
           } else if (Asistente.es_admin(emailBuscado, contrasena)) {
               System.out.println("Has accedido como administrador");
               login_correcto=true;
           } else {
               System.out.println("Usuario o contraseña incorrecta. Puede ser que no estés registrado, si es así registrese");
               do {
                   System.out.println("1. Si quieres intentar logearte de nuevo ");
                   System.out.println("2. Si quieres hacer un nuevo registro");
                   respuesta = sc.nextInt();
               } while (respuesta!=1 && respuesta!=2);
           }
       }while (!login_correcto && respuesta==1);
        if (!login_correcto && respuesta==2) {
            asistente_registro();
        }
    }
    public  void asistente_registro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sigue los pasos para crear una cuenta: ");
        String nombre, apellidos, dni, email, contrasena, telefono, fecha_nacimiento ;

        do {
            System.out.println("Ingrese su nombre:");
            nombre = sc.nextLine();
            if (Validaciones.validar_nombre(nombre)) {
                System.out.println("Nombre introducido correctamente");
            } else {
                System.out.println("Incorrecto, solo se pueden introducir letras, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_nombre(nombre));
        do {
            System.out.println("Ingrese sus apellidos:");
            apellidos = sc.nextLine();
            if (Validaciones.validar_nombre(apellidos)) {
                System.out.println("Apellidos introducido correctamente");
            } else {
                System.out.println("Incorrecto, solo se pueden introducir letras, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_nombre(apellidos));
        do {
            System.out.println("Ingrese su DNI:");
            dni = sc.nextLine();
            if (Validaciones.validar_DNI(dni)) {
                System.out.println("DNI introducido correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_DNI(dni));
        do {
            System.out.println("Ingrese su teléfono:");
            telefono = sc.nextLine();
            if (Validaciones.validar_telefono(telefono)) {
                System.out.println("Telefono introducido correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_telefono(telefono));

        do {
            System.out.println("Introduzca su fecha de nacimiento (dd-mm-yyyy):");
            fecha_nacimiento=sc.nextLine();
            if (Validaciones.validar_fecha(fecha_nacimiento)) {
                System.out.println("Fecha introducida correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_fecha(fecha_nacimiento));

        do {
            System.out.println("Ingrese su email:");
            email = sc.nextLine();
            if (Validaciones.validar_correo(email)) {
                System.out.println("Email introducido correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_correo(email));
        do {
            System.out.println("Introduzca una contraseña para acceder posteriormente al sistema:");
            contrasena= sc.nextLine();
            if (Validaciones.validar_password(contrasena)) {
                System.out.println("Contraseña introducida correctamente");
            } else {
                System.out.println("Incorrecto, vuelva a intentarlo");
            }
        } while (!Validaciones.validar_password(contrasena));
        getListado_asistentes().add(new Asistente(nombre,apellidos,dni, telefono, fecha_nacimiento, email, contrasena));
        System.out.println("Bienvenido " + email);
    }
    public void gestion_reservas(){
        Scanner sc = new Scanner(System.in);
        String eleccion = "";
        do {
            do {
                System.out.println("***DELECTARE MULTIEVENTOS***");
                System.out.println("---------------------------");
                System.out.println("1. Mostrar eventos disponibles");
                System.out.println("2. Mostrar mis reservas");
                System.out.println("3. Hacer nueva reserva");
                System.out.println("4. Salir");
                System.out.println("Elige una opción:");
                eleccion = sc.nextLine();
                switch (eleccion) {
                    case "1":
                        mostrar_eventos();
                        String salir;
                        do {
                            System.out.println("Para volver atrás pulse 1");
                            salir= sc.nextLine();
                        }while (!salir.equals("1"));
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    default:
                        System.out.println("Seleccion incorrecta vuelva a intentarlo");
                }
            }while (!eleccion.equals("4"));
        }while (!eleccion.equals("3") && !eleccion.equals("2") && !eleccion.equals("1") && !eleccion.equals("4"));
    }

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
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Sala: " + e.getSala().getNombre());
            System.out.println("Fecha: " + e.getFecha());
            System.out.println("Hora: " + e.getHora());
            System.out.println("Precio: " + e.getPrecio());
            System.out.println("Tipo evento: " + e.getTipo_evento());
            System.out.println("Capacidad: " + e.getNumero_asistentes_maximo());
            System.out.println("-----------------------");
            System.out.println("-----------------------");
        }
    }
}
