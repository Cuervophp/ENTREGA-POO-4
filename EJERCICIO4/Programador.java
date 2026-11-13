package EJERCICIO4;


public class Programador {

    private String nombre;
    private String apellido;

    public Programador(String nombre, String apellido) {

        validarNombre(nombre, "nombre");
        validarNombre(apellido, "apellido");

        this.nombre = nombre;
        this.apellido = apellido;
    }

    private void validarNombre(String valor, String campo) {

        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El " + campo + " no puede estar vacío."
            );
        }

        valor = valor.trim();

        if (valor.length() >= 20) {
            throw new IllegalArgumentException(
                "El " + campo + " debe tener menos de 20 caracteres."
            );
        }

        for (int i = 0; i < valor.length(); i++) {

            if (!Character.isLetter(valor.charAt(i))) {
                throw new IllegalArgumentException(
                    "El " + campo + " solo puede contener letras."
                );
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
