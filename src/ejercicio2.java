import java.util.Scanner;

public class ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Declaración de la matriz
        int[][] ventas = new int[4][5];

        System.out.println("=== REGISTRO DE VENTAS POR SUCURSAL Y PRODUCTO ===\n");

        // 2. Lectura y validación de datos
        for (int i = 0; i < 4; i++) {
            System.out.println("--- Sucursal " + (i + 1) + " ---");
            for (int j = 0; j < 5; j++) {
                int valor;
                do {
                    System.out.print("Ingrese unidades vendidas del Producto " + (j + 1) + ": ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Error: Debe ingresar un número entero válido.");
                        System.out.print("Ingrese unidades vendidas del Producto " + (j + 1) + ": ");
                        sc.next();
                    }
                    valor = sc.nextInt();

                    if (valor < 0) {
                        System.out.println("Error: Las unidades no pueden ser negativas. Intente de nuevo.");
                    }
                } while (valor < 0);

                ventas[i][j] = valor;
            }
            System.out.println();
        }

        // 3. Cálculos y estadísticas

        // Totales por Sucursal (filas) y Sucursal con menor venta
        int[] totalSucursales = new int[4];
        int menorVentaSucursal = Integer.MAX_VALUE;
        int sucursalMenor = 1;

        for (int i = 0; i < 4; i++) {
            int sumaFila = 0;
            for (int j = 0; j < 5; j++) {
                sumaFila += ventas[i][j];
            }
            totalSucursales[i] = sumaFila;

            if (sumaFila < menorVentaSucursal) {
                menorVentaSucursal = sumaFila;
                sucursalMenor = i + 1;
            }
        }

        // Totales por Producto (columnas) y Producto con mayor venta
        int[] totalProductos = new int[5];
        int mayorVentaProducto = -1;
        int productoMayor = 1;

        for (int j = 0; j < 5; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < 4; i++) {
                sumaColumna += ventas[i][j];
            }
            totalProductos[j] = sumaColumna;

            if (sumaColumna > mayorVentaProducto) {
                mayorVentaProducto = sumaColumna;
                productoMayor = j + 1;
            }
        }

        // Conteo de registros en la matriz superiores a 30 unidades
        int registrosMayor30 = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (ventas[i][j] > 30) {
                    registrosMayor30++;
                }
            }
        }

        // 4. Mapeo e impresión de la matriz
        System.out.println("==========================================================================");
        System.out.println("                           MATRIZ DE VENTAS                               ");
        System.out.println("==========================================================================");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s %-10s %-12s%n",
                          "Sucursal", "Prod 1", "Prod 2", "Prod 3", "Prod 4", "Prod 5", "Total Suc.");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < 4; i++) {
            System.out.printf("Sucursal %-7d", (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-10d", ventas[i][j]);
            }
            System.out.printf("%-12d%n", totalSucursales[i]);
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-15s", "Total Prod.");
        for (int j = 0; j < 5; j++) {
            System.out.printf("%-10d", totalProductos[j]);
        }
        System.out.println("\n==========================================================================\n");

        // Impresión de resultados
        System.out.println("==========================================================================");
        System.out.println("                        RESUMEN Y ESTADÍSTICAS                            ");
        System.out.println("==========================================================================");
        System.out.println("Sucursal con MENOR cantidad de ventas : Sucursal " + sucursalMenor + " (" + menorVentaSucursal + " unidades)");
        System.out.println("Producto con MAYOR cantidad de ventas : Producto " + productoMayor + " (" + mayorVentaProducto + " unidades)");
        System.out.println("Registros superiores a 30 unidades   : " + registrosMayor30 + " registro(s)");
        System.out.println("==========================================================================\n");

        sc.close();
    }
}