package EJERCICIO4;


import java.util.ArrayList;

public class EquipoMaratonProgramacion {

    private String nombreEquipo;
    private String universidad;
    private String lenguajeProgramacion;

    private ArrayList<Programador> programadores;

    public EquipoMaratonProgramacion(
        String nombreEquipo,
        String universidad,
        String lenguajeProgramacion
    ) {

        if (nombreEquipo == null || nombreEquipo.trim().isEmpty()
                || universidad == null || universidad.trim().isEmpty()
                || lenguajeProgramacion == null
                || lenguajeProgramacion.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "Todos los datos del equipo son obligatorios."
            );
        }

        this.nombreEquipo = nombreEquipo.trim();
        this.universidad = universidad.trim();
        this.lenguajeProgramacion = lenguajeProgramacion.trim();

        programadores = new ArrayList<>();
    }

    public void agregarProgramador(Programador programador) {

        if (programador == null) {
            throw new IllegalArgumentException(
                "El programador no puede ser nulo."
            );
        }

        if (programadores.size() >= 3) {
            throw new IllegalArgumentException(
                "El equipo ya tiene el máximo de 3 programadores."
            );
        }

        programadores.add(programador);
    }

    public void verificarEquipo() {

        if (programadores.size() < 2 || programadores.size() > 3) {
            throw new IllegalArgumentException(
                "El equipo debe tener entre 2 y 3 programadores."
            );
        }
    }

    public String mostrarInformacion() {

        StringBuilder informacion = new StringBuilder();

        informacion.append("EQUIPO DE MARATÓN DE PROGRAMACIÓN\n");
        informacion.append("----------------------------------\n");
        informacion.append("Nombre: ").append(nombreEquipo).append("\n");
        informacion.append("Universidad: ").append(universidad).append("\n");
        informacion.append("Lenguaje: ").append(lenguajeProgramacion).append("\n");

        informacion.append("\nINTEGRANTES:\n");

        for (int i = 0; i < programadores.size(); i++) {
            informacion.append(i + 1)
                       .append(". ")
                       .append(programadores.get(i))
                       .append("\n");
        }

        return informacion.toString();
    }

    public int getCantidadProgramadores() {
        return programadores.size();
    }
}

