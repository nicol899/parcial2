import java.util.Random;
import java.util.Scanner;

public class LaberintoUniversitario {

    public static void main(String[] args) {
        int[][] laberinto = new int[5][5];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generar el laberinto con valores aleatorios del 1 al 9
        for (int fila = 0; fila < laberinto.length; fila++) {
            for (int col = 0; col < laberinto[fila].length; col++) {
                laberinto[fila][col] = random.nextInt(9) + 1;
            }
        }

        // Mostrar el laberinto
        System.out.println("=== LABERINTO UNIVERSITARIO ===");
        mostrarMatriz(laberinto);

        System.out.println("""
                ¡Bienvenido al Laberinto Universitario!
                Este sistema representa los pasillos secretos de tu facultad.
                Cada número indica un nivel de energía en ese punto.
                Tu misión es explorar este laberinto cumpliendo los siguientes objetivos:

                - Empiezas en la esquina superior izquierda (posición 0,0).
                - Puedes moverte en 4 direcciones: arriba, abajo, izquierda o derecha.
                - Cada movimiento resta energía según el valor de la nueva celda.
                - Empiezas con 30 de energía.
                - El objetivo es llegar a la esquina inferior derecha (posición 4,4).

                ¡Buena suerte!
                """);

        int fila = 0;
        int col = 0;
        int energia = 30;

        while (true) {
            System.out.println("Estás en la posición (" + fila + "," + col + ")");
            System.out.println("Energía actual: " + energia);
            System.out.print("¿Hacia dónde te mueves? (W=arriba, S=abajo, A=izquierda, D=derecha): ");
            String direccion = scanner.nextLine().toUpperCase();

            int nuevaFila = fila;
            int nuevaCol = col;

            switch (direccion) {
                case "W":
                    nuevaFila--;
                    break;
                case "S":
                    nuevaFila++;
                    break;
                case "A":
                    nuevaCol--;
                    break;
                case "D":
                    nuevaCol++;
                    break;
                default:
                    System.out.println("Dirección no válida.");
                    continue;
            }

            // Verificar que el nuevo movimiento esté dentro del laberinto
            if (nuevaFila >= 0 && nuevaFila < 5 && nuevaCol >= 0 && nuevaCol < 5) {
                fila = nuevaFila;
                col = nuevaCol;
                int energiaGastada = laberinto[fila][col];
                energia -= energiaGastada;
                System.out.println(
                        "Te moviste a (" + fila + "," + col + ") y gastaste " + energiaGastada + " de energía.");
            } else {
                System.out.println("¡Movimiento fuera del laberinto! Intenta otra dirección.");
            }

            // Verificar si ganó o perdió
            if (fila == 4 && col == 4) {
                System.out.println("¡Felicidades! Llegaste al final del laberinto.");
                break;
            }

            if (energia <= 0) {
                System.out.println("¡Oh no! Te quedaste sin energía. Fin del juego.");
                break;
            }
        }

        scanner.close();
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print("[" + valor + "] ");
            }
            System.out.println();
        }
    }
}
