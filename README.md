# CajeroAutomatico



<table>
  <tr>
   <td><strong>Apellidos y nombre:</strong>
   </td>
   <td>
   </td>
   <td><strong>Fecha:</strong>
   </td>
   <td><strong>10-02-2021</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Módulo</strong>
   </td>
   <td>Programación (Convocatoria extraordinaria)
   </td>
   <td><strong>CFGS</strong>
   </td>
   <td><strong>DAW</strong>
   </td>
  </tr>
</table>


      



1. Actualmente tenemos un cajero automático, en él hay una cantidad limitada de billetes. Esta limitación bien definida por la siguiente estructura de datos: 

** cajeroBilletes = [[500,10], [200,0], [100,0], [50,30], [20,0], [10,20], [5,25]]


    Es decir, en este estado, tenemos 10 billetes de 500 €, 0 billetes de 200 €, 100 € y 20 €, 30 billetes de 50 € ... Por tanto, en cada una de las sublistas el primer parámetros indica el valor del billete y el segundo la cantidad de billetes.


    Desarrolla las siguientes clases:


   **Clase CajeroAutomático (0,5 puntos),** en el que sus principales atributos son: 


   **numIDCajeroUlt**: este será el id compartido por todos los cajeros, para poder tener el control del idCajero dado de alta de cada uno de los cajeros. 


   **numIdCajero**: este será único e incremental para cada uno de los cajeros que se dan de alta. Se pide que en el momento de la creación asigne un id de cajero en cajero, teniendo en cuenta el <span style="text-decoration:underline;">numIDCajeroUlt</span>:


   **billetes:** Tendrá exactamente la estructura de datos definida anteriormente *. Por simplificación, podemos asumir que inicialmente están cargados como se muestra en el ejemplo para cualesquiera cajero cargado.


   **tarjeta: </span>tendrá una lista de tarjetas que se pueden utilizar.


   **Clase Tarjeta (0,25 puntos),** en el que sus principales atributos son: 


   **NIF del cliente.**


**PIN del cliente.**


   **Nombre del cliente.**


**Apellido del cliente**


    Además hay dos tipos de tarjeta diferentes que pueden tener los cajeros:


*   tarjeta de débito
*   tarjeta de crédito
*   ambas son una especialización de la clase tarjeta.

    **Clase TarjetaDebito (0,25 puntos),** en el que sus principales atributos son: 


    **Saldo disponible**


    **clase TarjetaCredito (0,25 puntos),** en el que sus principales atributos son: 


  **Saldo disponible**


   **crédito disponible**


    Desarrolla los constructores (sin parámetros, con parámetros y copia), getters / setters de las clases anteriores. **(1 punto)**


    Desarrolla en el programa principal un menú con las siguientes opciones: 

    1. Sacar dinero
    2. Salir

Este menú tiene que estar disponible mientras no se utilice la opción de salir. **(0,5 puntos)**


   **Métodos desarrollar**


   **mostrarCajero (0,5 puntos)** Desarrolla un método que haga un recorrido del cajero y muestre el número de billetes disponibles. Utiliza este método antes de imprimir el menú principal, para ver cómo se van actualizando los billetes. Ejemplo:


```
    5 billetes de 500 € 
    0 billetes de 200 € 
    0 billetes de 100 € 
    20 billetes de 50 € 
    0 billetes de 20 € 
    17 billetes de 10 € 
    25 billetes de 5 €
```


**mostrarTarjeta (1 punto): **Este método es común a las tres clases de tarjeta y té que utilizar obligatoriamente la misma firma en los tres métodos:



1. En la clase tarjeta, imprimirá el nombre, apellido y NIF de la tarjeta en cuestión. 
2. En la clase tarjeta de crédito, además de lo que imprime la clase tarjeta, imprimirá el saldo y el crédito.
3. En la clase tarjeta de débito, además de lo que imprime la clase tarjeta, imprimirá el saldo.
4. Haz uso de este método para ver cómo se van actualizando las tarjetas en el menú principal.

Desarrolla el método **sacarDinero**, que se llamará desde el menú principal y realizará todas las siguientes acciones:



1. Pedirá un NIF y su PIN. Si lo encuentra al cliente y el PIN es correcto, pedirá el dinero para sacar. Si no lo encuentra dará un aviso de NIF incorrecto o PIN incorrecto, según corresponda.

        Hay que tener en cuenta que si la tarjeta es de débito a solo puede sacar el saldo disponible, y obviamente actualizará el saldo disponible si el cajero tiene billetes por el importe pedido. Si no tiene saldo suficiente, dará un aviso de que no hay saldo suficiente, y por tanto, y volverá al menú principal. **(1 punto)**

2. Si es de crédito podrá sacar el saldo disponible + crédito disponible, y obviamente actualizará el saldo y crédito utilizado disponible si el cajero tiene billetes por el importe solicitado. Si no tiene saldo suficiente, dará un aviso de que no hay saldo suficiente, y por tanto, y volverá al menú principal. **(1 punto)**
3. Además en el momento de sacar el cajero este té que devolver la cantidad de dinero <span style="text-decoration:underline;">utilizando el menor número de billetes </span>posible. Si el cajero no tiene dinero suficiente para el importe, dará un aviso de que el cajero no tiene billetes y por tanto y volverá al menú principal sin actualizar nada. La función tiene que imprimir por pantalla los billetes y cantidad por pantalla. Si el cajero no tiene dinero tiene que informar de esta situación, y por tanto, el saldo de las tarjetas y el cajero no se modificarán. **(3,75 puntos)**

    Conclusión: si se puede sacar el dinero, se actualizará la estructura de datos tanto de tarjetas como del cajero con las modificaciones de saldo correspondientes.


    Utiliza todos los métodos que necesites para encapsular el programa y ahorrar tiempo de desarrollo.


    **Ayuda. Utiliza este código en tu programa principal:**


    ```
            int [] [] cargaBilletes = {{500, 10}, {200, 0}, {100, 0}, {50, 27},
            {20, 0}, {10, 18}, {5, 25}};
            CajeroAutomatico micajero = new CajeroAutomatico ();
            micajero.setBilletes (cargaBilletes);
            TarjetaDebito mitarj1 = new TarjetaDebito ( "33888999m", 1111, "Jorge", "Lorenzo", 20000);
            TarjetaCredit mitarj2 = new TarjetaCredit ( "34888999m", 2222, "Rafa", "Navidad", 1000, 5000);
            micajero.setListTarjeta (mitarj1);
            micajero.setListTarjeta (mitarj2); 

    ```


_Ejemplo de ejecución del programa:_


```
======================
 DATOS DE LA TARJETA DEL CLIENTE
Número: Jorge
Apellido: Lorenzo
NIF: 33888999m
Tarjeta de débito:
Saldo: 20000.0
======================
 DATOS DE LA TARJETA DEL CLIENTE
Número: Rafa
Apellido: Navidad
NIF: 34888999m
Tarjeta de crédito:
Saldo: 1000.0
Crédito: 5000.0
== ====================
Billetes DISPONIBLES EN cajero
10 billetes de 500 € 
0 billetes de 200 € 
0 billetes de 100 € 
27 billetes de 50 € 
0 billetes de 20 € 
18 billetes de 10 € 
25 billetes de 5 € 
========================
1. Opción 1 - Sacar dinero
2. Opción 2 - Salir
Escribe una de las opciones
1
Has seleccionado la opción 1 - Sacar dinero
Dame el NIF: 
33888999m
Dame el PIN
1111
¿Qué Cantidad deseáis Sacar?
3500
Desglose de la Cantidad satisfecha: 
7 billetes de 500 € 
======================
 DATOS DE LA TARJETA DEL CLIENTE
Número: Jorge
Apellido: Lorenzo
NIF: 33888999m
Tarjeta de débito:
Saldo: 16500.0
======================
 DATOS de LA TARJETA del CLIENTE
Número: Rafa
Apellido: Navidad
NIF: 34888999m
Tarjeta de crédito:
Saldo: 1000.0
Crédito: 5000.0
3 billetes de 500 € 
0 billetes de 200 € 
0 billetes de 100 € 
27 billetes de 50 € 
0 billetes de 20 € 
18 billetes de 10 € 
25 billetes de 5 € 
1. Opción 1 - Sacar dinero
2. Opción 2 - Salir
Escribe una de las opciones
2
