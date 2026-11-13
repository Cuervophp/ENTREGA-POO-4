package EJERCICIO3;


public class CalculosNumericos {

    public static double calcularLogaritmo(double numero) {

        if (numero <= 0) {
            throw new IllegalArgumentException(
                "El logaritmo natural solo acepta números mayores que cero."
            );
        }

        return Math.log(numero);
    }

    public static double calcularRaizCuadrada(double numero) {

        if (numero < 0) {
            throw new IllegalArgumentException(
                "No se puede calcular la raíz cuadrada real de un número negativo."
            );
        }

        return Math.sqrt(numero);
    }
}

