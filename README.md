# Primer Parcial Práctico – Programación I

## Versión B

**Lenguaje:** Java  
**Modalidad:** Individual  
**Duración total:** 60 minutos  
**Valor:** 100 puntos  
**Temas:** arreglos unidimensionales, arreglos bidimensionales, ciclos, condicionales, contadores y acumuladores.

---

## Indicaciones generales

- Desarrolle los dos ejercicios en Java y desde consola.
- Cada ejercicio debe resolverse en un archivo independiente.
- Toda la solución debe estar dentro del método `main`.
- Puede utilizar `Scanner`, arreglos, matrices, ciclos y condicionales.
- No se permite utilizar `ArrayList`, colecciones, `Stream`, métodos de ordenamiento automático ni métodos creados por el estudiante.
- Los datos deben ser solicitados al usuario; no deben quedar escritos directamente en el código.
- Los resultados deben mostrarse de forma clara e identificable.
- Si se presenta un empate, debe reportarse la primera posición encontrada.

---

# Ejercicio 1 – Paquetes procesados por hora

**Tiempo sugerido:** 30 minutos  
**Valor:** 50 puntos

Un centro de distribución registró la cantidad de paquetes procesados durante **10 horas consecutivas**. Los valores son enteros y deben almacenarse en un arreglo unidimensional.

Construya un programa que:

1. Cree un arreglo de 10 posiciones.
2. Solicite la cantidad de paquetes procesados en cada hora y valide que no sea negativa. Si el dato es inválido, debe solicitarlo nuevamente.
3. Calcule y muestre:
   - El total de paquetes procesados.
   - El promedio de paquetes por hora.
   - El número de la hora con la menor cantidad procesada.
   - Cuántas horas tuvieron una producción inferior al promedio.
   - La racha más larga de horas consecutivas cuya producción fue inferior al promedio.
4. Muestre el listado final con el número de cada hora y su cantidad registrada.

## Aclaraciones

- Las horas se numeran del 1 al 10, aunque las posiciones del arreglo comiencen en 0.
- Una racha es una secuencia de posiciones consecutivas. Por ejemplo, si las horas 5, 6 y 7 están por debajo del promedio, existe una racha de longitud 3.
- Para determinar cuáles valores están por debajo del promedio será necesario recorrer nuevamente el arreglo después de calcularlo.

## Criterios de evaluación

| Criterio | Puntaje |
|---|---:|
| Lectura, almacenamiento y validación de los 10 valores | 10 |
| Cálculo correcto del total y del promedio | 10 |
| Identificación de la hora con menor producción | 10 |
| Conteo de horas por debajo del promedio | 8 |
| Cálculo correcto de la racha más larga | 8 |
| Claridad de la salida y organización del código | 4 |

---

# Ejercicio 2 – Registro de ventas de sucursales

**Tiempo sugerido:** 30 minutos  
**Valor:** 50 puntos

Una empresa tiene **4 sucursales** y desea analizar las unidades vendidas de **5 productos** durante una jornada. La información debe almacenarse en una matriz de 4 filas por 5 columnas:

- Cada fila representa una sucursal.
- Cada columna representa un producto.

Construya un programa que:

1. Cree una matriz de `4 x 5`.
2. Solicite las unidades vendidas de cada producto en cada sucursal y valide que ningún valor sea negativo.
3. Calcule y muestre:
   - El total de unidades vendidas por cada sucursal.
   - El total vendido de cada producto, sumando las cuatro sucursales.
   - La sucursal con la menor cantidad total de ventas.
   - El producto con la mayor cantidad total de unidades vendidas.
   - Cuántos registros de la matriz fueron superiores a 30 unidades.
4. Muestre la matriz completa, organizada por sucursales y productos.

## Aclaraciones

- Las sucursales se numeran del 1 al 4 y los productos del 1 al 5.
- Si dos sucursales tienen el mismo total mínimo, se reporta la primera.
- Si dos productos tienen el mismo total máximo, se reporta el primero.
- No es necesario crear arreglos adicionales para resolver el ejercicio, aunque puede utilizarlos si lo considera conveniente.

## Criterios de evaluación

| Criterio | Puntaje |
|---|---:|
| Lectura, almacenamiento y validación de la matriz | 10 |
| Cálculo del total de cada sucursal | 10 |
| Cálculo del total de cada producto | 10 |
| Identificación de la sucursal menor y el producto mayor | 10 |
| Conteo de registros superiores a 30 | 6 |
| Presentación de la matriz y organización del código | 4 |

---

## Entrega

Entregue los dos archivos `.java`, debidamente nombrados y capaces de compilar y ejecutarse sin errores.

**Analice primero y programe después. Java ejecuta exactamente lo escrito, incluso cuando la idea iba por otro camino.**

## Solucion del ejercicio1
El programa resuelve la gestión de datos del centro de distribución mediante un arreglo de 10 posiciones. Su funcionamiento se divide en tres etapas principales:

- 1. Leer y Validar los Datos: Se utiliza un bucle for para solicitar la cantidad de paquetes procesados en cada una de las 10 horas. Para garantizar que los datos sean solo numeros positivos, se implementa una validación con do-while y Scanner que impide el ingreso de valores negativos o caracteres que no sean numeros. Durante la lectura, se acumula la suma total de los paquetes.

- 2. Cálculos y Procesamiento:

Promedio y Mínimo: Se calcula el promedio dividiendo el total acumulado entre las 10 horas.

Conteo: Mediante un segundo recorrido, se compara el valor de cada hora con el promedio. Si es inferior, se incrementa el contador de horas por debajo de la media y se suma a una racha activa. Si la racha actual supera a la racha máxima registrada, esta se actualiza; de lo contrario, la racha se reinicia a cero al encontrar una hora con producción igual o superior al promedio.

Finalmente, el programa imprime una tabla formateada con la producción detallada de cada hora y un panel de estadísticas finales con el total de paquetes, el promedio por hora, la hora de menor rendimiento, el número de horas con baja producción y la racha consecutiva más larga.

## Solucion del ejercicio2
El programa resuelve el análisis de ventas mediante una matriz bidimensional de 4x5 (int[4][5]), combinada con arreglos auxiliares para almacenar acumulados. Su ejecución consta de tres partes principales:

- 1. Leer y Validar la Matriz: Se recorre la matriz celda por celda mediante ciclos for anidados. En cada iteración se aplica una estructura de validación con do-while y Scanner para garantizar que la entrada sea de tipo entero y no contenga valores negativos.

- 2. Cálculos y Procesos:

Suma por Filas (Sucursales): Se itera fijando la fila para sumar los productos de cada sucursal y se guarda el total en un arreglo. En el mismo paso se evalúa con el operador < cuál es la sucursal con menor ventas, conservando la primera registrada en caso de empate.

Suma por Columnas (Productos): Se invierte el orden de iteración fijando la columna para calcular el total de unidades por producto. Mediante el operador > se identifica el producto con mayor unidades vendidas.

Evaluación de Filtro: Se efectúa un recorrido completo de la matriz contando cuántas celdas registraron una cantidad estrictamente mayor a 30.

- 3. Impresión de la Matriz y Resumen: Finalmente, se presenta en consola la matriz formateada con alineación tabular, agregando los totales acumulados por fila y columna, así como el cuadro estadístico resumen.