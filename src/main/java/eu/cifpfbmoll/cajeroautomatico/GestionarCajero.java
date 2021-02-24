/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.cajeroautomatico;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class GestionarCajero {

    public static void main(String[] args) {
        //cargamos el cajero con unos billetes y tarjetas  
        int[][] carga_billetes = {{500, 10}, {200, 0}, {100, 0}, {50, 27},
        {20, 0}, {10, 18}, {5, 25}};
        CajeroAutomatico micajero = new CajeroAutomatico();
        micajero.setBilletes(carga_billetes);
        TarjetaDebito mitarj1 = new TarjetaDebito("1111", 1111, "Jorge", "Lorenzo", 20000);
        TarjetaCredito mitarj2 = new TarjetaCredito("2222", 2222, "Rafa", "Nadal", 1000, 5000);
        micajero.getListaTarjeta().add(mitarj1);
        micajero.getListaTarjeta().add(mitarj2);
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0; //Guardaremos la opcion del usuario      //Guardaremos la opcion del usuario      

        while (!salir) {
            mitarj1.mostrarTarjeta();
            mitarj2.mostrarTarjeta();
            CajeroAutomatico.mostrarCajero(micajero.getBilletes());

            System.out.println("1. Opcion 1 - Sacar dinero");
            System.out.println("2. Opcion 2 - Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la opcion 1 - Sacar dinero");
                     {
                        try {
                            micajero.sacarDinero();
                        } catch (ExcepcionCajero ex) {
                            System.out.println(ex.getMensaje());
                        }
                    }
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Las opciones disponibles son 1 y 2. "
                            + "Vuelva a intentarlo");
            }

        }
    }
}
