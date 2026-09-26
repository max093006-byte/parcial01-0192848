import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Crear el arreglo de 10 posiciones
        int[] paquetes = new int[10];
        int total = 0;

        System.out.println("=== REGISTRO DE PAQUETES PROCESADOS (10 HORAS) ===\n");

        // 2. Lectura y validación de datos
        for (int i = 0; i < paquetes.length; i++) {
            int valor;
            do {
                System.out.print("Ingrese paquetes procesados en la Hora " + (i + 1) + ": ");
                while (!sc.hasNextInt()) {
                    System.out.println("Error: Debe ingresar un número entero válido.");
                    System.out.print("Ingrese paquetes procesados en la Hora " + (i + 1) + ": ");
                    sc.next();
                }
                valor = sc.nextInt();

                if (valor < 0) {
                    System.out.println("Error: La cantidad no puede ser negativa. Intente de nuevo.");
                }
            } while (valor < 0);

            paquetes[i] = valor;
            total += valor; // Acumular para el total
        }

        // 3. Cálculos requeridos

        // Total y Promedio
        double promedio = (double) total / paquetes.length;

        // Menor cantidad procesada
        int menorCantidad = paquetes[0];
        int horaMenor = 1;

        for (int i = 1; i < paquetes.length; i++) {
            if (paquetes[i] < menorCantidad) {
                menorCantidad = paquetes[i];
                horaMenor = i + 1; // La hora es el índice + 1
            }
        }

        // Conteo de horas por debajo del promedio y racha más larga
        int horasBajoPromedio = 0;
        int rachaActual = 0;
        int rachaMaxima = 0;

        for (int i = 0; i < paquetes.length; i++) {
            if (paquetes[i] < promedio) {
                horasBajoPromedio++;
                rachaActual++;

                if (rachaActual > rachaMaxima) {
                    rachaMaxima = rachaActual;
                }
            } else {
                rachaActual = 0; // Se rompe la racha si está en o sobre el promedio
            }
        }

        // 4. Mapeo e impresión de resultados
        System.out.println("\n=================================================");
        System.out.println("             LISTADO DE REGISTROS                ");
        System.out.println("=================================================");
        System.out.printf("%-15s %-20s%n", "Hora", "Paquetes Procesados");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < paquetes.length; i++) {
            System.out.printf("Hora %-10d %-20d%n", (i + 1), paquetes[i]);
        }

        System.out.println("=================================================");
        System.out.println("               RESUMEN Y ESTADÍSTICAS            ");
        System.out.println("=================================================");
        System.out.println("Total de paquetes procesados     : " + total);
        System.out.printf("Promedio de paquetes por hora    : %.2f%n", promedio);
        System.out.println("Hora con menor producción        : Hora " + horaMenor + " (" + menorCantidad + " paquetes)");
        System.out.println("Horas con producción < promedio  : " + horasBajoPromedio);
        System.out.println("Racha más larga < promedio       : " + rachaMaxima + " hora(s) consecutiva(s)");
        System.out.println("=================================================\n");

        sc.close();
    }
}