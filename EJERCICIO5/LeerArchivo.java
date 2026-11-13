package EJERCICIO5;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    public static String leerContenido(File archivo)
            throws IOException {

        StringBuilder contenido = new StringBuilder();

        try (BufferedReader lector = new BufferedReader(
                new FileReader(archivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }

        return contenido.toString();
    }

    public static String convertirMayusculas(String texto) {

        return texto.toUpperCase();
    }
}

