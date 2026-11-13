package EJERCICIO2;


public class Vendedor {

    private String nombre;
    private String apellido;
    private int edad;

    public Vendedor(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        verificarEdad(edad);
        this.edad = edad;
    }

    public void verificarEdad(int edad) {

        if (edad <= 18) {
            throw new IllegalArgumentException(
                "El vendedor debe ser mayor de 18 años."
            );
        }

        if (edad > 120) {
            throw new IllegalArgumentException(
                "La edad no puede ser superior a 120 años."
            );
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nApellido: " + apellido
                + "\nEdad: " + edad;
    }
}

