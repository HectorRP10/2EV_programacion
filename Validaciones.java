import java.math.BigInteger;

public class Validaciones {
    public static boolean validar_asiento(String asiento) {
        // se definen las diferentes variables
        String a = "A", b = "B", c = "C";
        int numero_asiento=0;
        // se comprueba que el asiento sea a,b,c y numero(1-6)
        if (asiento.length() > 1) {
            if ((a.equals(asiento.substring(0, 1)) || b.equals(asiento.substring(0, 1)) || c.equals(asiento.substring(0, 1))) &&
                    validar_numero(asiento.substring(1))) {
                numero_asiento = Integer.parseInt(asiento.substring(1));
                if (numero_asiento >= 1 && numero_asiento <= 6){
                    if(!(a.equals(asiento.substring(0, 1))&& numero_asiento==1) && !(b.equals(asiento.substring(0, 1))&& numero_asiento==5) && !(c.equals(asiento.substring(0, 1))&& numero_asiento==6)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean validar_DNI(String dni) {
        // se comprueba que la longitud sea de 9
        if (dni.length() != 9) {
            System.out.println("Error, vuelva a intentarlo");
            return false;
        }
        // se coge la parte numerica y se comprueba que sea solo de numeros
        String parteNumeros = dni.substring(0, 8);
        if (!validar_numero(parteNumeros)) {
            System.out.println("Error, vuelva a intentarlo");
            return false;
        }
        // se coge la letra y se comprueba que corresponda al número
        char letra = dni.toUpperCase().charAt(8);
        if (validar_numero(parteNumeros) && calcular_letra_DNI(Integer.parseInt(parteNumeros)) == letra) {
            return true;
        } else {
            System.out.println("Error, vuelva a intentarlo");
            return false;
        }
    }
    public static char calcular_letra_DNI(int numerosDNI) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.charAt(numerosDNI % 23);  // se debe dividir los números del DNI entre 23 para obtener la letra
    }
    public static boolean validar_numero(String parte_numeros) {
        //comprueba si la cadena está vacía
        if ( parte_numeros.isEmpty()) {
            return false;
        }
        // Verifica que lo que hay en la cadena sean números
        for (int contador = 0; contador < parte_numeros.length(); contador++) {
            char c = parte_numeros.charAt(contador);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    public static boolean validar_correo(String correo){
        // se verifica la estructura del correo
        if (correo.indexOf('@')!=-1){
            if (correo.indexOf('.', correo.indexOf('@')) != -1) {
                if (correo.indexOf("@") != 0 && correo.lastIndexOf(".") != correo.length() - 1){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean validar_iban(String iban) {
        // Verificación de la longitud
        if (iban.length() != 24) {
            return false;
        }

        // Verificar que los primeros dos caracteres sean letras

        char letra1 = iban.charAt(0);
        char letra2 = iban.charAt(1);
        if (!((letra1 >= 'A' && letra1 <= 'Z') && (letra2 >= 'A' && letra2 <= 'Z'))) {  // se comprueba si es una letra
            return false;
        }
        // Reorganizar los dígitos
        String ibanReorganizado = iban.substring(4) + iban.substring(0, 4);

        // Convertir letras a dígitos
        String ibanNumerico = "";
        for (int contador = 0; contador < ibanReorganizado.length(); contador++) {
            char caracter = ibanReorganizado.charAt(contador);

            if ('0' <= caracter && caracter <= '9') {
                ibanNumerico= ibanNumerico+ caracter;
            } else {
                ibanNumerico = ibanNumerico+ (10 + caracter - 'A'); // se convierte la letra al número
            }
        }

        // Convertir la cadena IBAN a BigInteger y calcular el módulo 97
        BigInteger resultadoModulo = new BigInteger(ibanNumerico).mod(BigInteger.valueOf(97));

        // Verificar si el resultado del módulo es igual a 1
        return resultadoModulo.intValue() == 1;
    }   // iban de ejemplo ES9121000418450200051332
    public static boolean validar_nombre(String nombre) {
        // se comprueba que la cadena no este vacía
        if(nombre.isEmpty()){
            return false;
        }
        // se verifica que solo haya letras
        for (int contador = 0; contador < nombre.length(); contador++) {
            char letra = nombre.charAt(contador);
            int tablaascii = (int) letra;
            if ((tablaascii < 65 || tablaascii > 90) && (tablaascii < 97 || tablaascii > 122)) {
                return false;
            }
        }
        return true;
    }
    public static boolean validar_telefono(String telefono){
        if (telefono.length() != 9 || !validar_numero(telefono)) {
            System.out.println("Error, inténtelo de nuevo");
            return false;
        }
        return true;
    }

}
