/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rafael
 * @version 1.1
 * @see Tarjeta
 * @since negrita
 */
public class CajeroAutomatico {

    private static int idUltCaj;
    private int idCaj;
    private int billetes[][];
    private ArrayList<Tarjeta> listaTarjeta = new ArrayList<Tarjeta>();

    public CajeroAutomatico(int idCaj, int[][] billetes, ArrayList<Tarjeta> listaTarjeta) {
        this.setIdCaj(idUltCaj++);
        this.setBilletes(billetes);
        this.setListaTarjeta(listaTarjeta);
    }

    public CajeroAutomatico() {
        this.setIdCaj(idUltCaj++);
    }

    public static int getIdUltCaj() {
        return idUltCaj;
    }

    public static void setIdUltCaj(int idUltCaj) {
        CajeroAutomatico.idUltCaj = idUltCaj;
    }

    public int getIdCaj() {
        return idCaj;
    }

    public void setIdCaj(int idCaj) {
        this.idCaj = idCaj;
    }

    public int[][] getBilletes() {
        return billetes;
    }

    public void setBilletes(int[][] billetes) {
        this.billetes = billetes;
    }

    public ArrayList<Tarjeta> getListaTarjeta() {
        return listaTarjeta;
    }

    public void setListaTarjeta(ArrayList<Tarjeta> listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }

    public void sacarDinero() throws ExcepcionCajero {
// 1 cajero debo pedir su nif y pin
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el NIF: ");
        String nif = sc.nextLine();
        System.out.println("Dame el PIN");
        int pin = sc.nextInt();
        int localizador = localizarUsuario(this.getListaTarjeta(), nif, pin);
        if (localizador != -1) {
            System.out.println("¿que cantidad deseas sacar?");
//ponemo lectura de entero porque no habrá decimales, se da por hecho que el usuario conoce
// las cantidades que se pueden introducir.
            int importe = sc.nextInt();
            actualizarSaldo(this.getListaTarjeta().get(localizador), importe);
        }
    }

    public void actualizarSaldo(Tarjeta t, int importe) throws ExcepcionCajero {
        //primero compruebo que para la tarjeta tengo saldo suficiente para devolver
        // al cliente su dinero. Después verifico si el cajero ha podido dar el dinero
        //si es así, disminuimos el saldo definitivamente del cliente
        if (t instanceof TarjetaDebito) {
            if (((TarjetaDebito) t).getSaldoDisp() >= importe) {
                if (actualizarSaldoCajero(importe)) {
                    ((TarjetaDebito) t).disminuirSaldoDisp(importe);
                }
                else throw new ExcepcionCajero(importe);
            }
        } else {//es que es tarjeta de credito
            if (((TarjetaCredito) t).comprobarSaldoSuficiente(importe)) {
                if (actualizarSaldoCajero(importe)) {
                    ((TarjetaCredito) t).disminuirSaldoDisp(importe);
                }
                else throw new ExcepcionCajero(importe);
            }
        }

    }

    public static void mostrarCajero(int[][] caj) {
        //un metodo para comprobar la evolución de los saldos de tarjetas 
        for (int i = 0; i < caj.length; i++) {
            System.out.println(caj[i][1] + " billetes de " + caj[i][0] + " € ");
        }
    }

    /**
     *
     * @param cajero_billetes
     * @param cantidad
     * @return Devuelve true si tiene saldo el cajero, y false si no tiene saldo
     * suficiente
     */
    public boolean actualizarSaldoCajero(int cantidad) throws ExcepcionCajero {
        //compruebo si tengo saldo
        int[][] copia = new int[7][2];//billetes por defecto;
        arrayCopy(this.getBilletes(), copia);
        int cantidadCopy = cantidad;
        boolean salida=false;
        String resultado = "Desglose de la cantidad satisfecha: ";
        //for (int i = 0; i < this.getBilletes().length; i++) {
        int i = 0;
        while (i < this.getBilletes().length && cantidad > 0) {
            if (cantidad / this.getBilletes()[i][0] >= 1) {
                int num_billetes = 0;
                while ((cantidad >= this.getBilletes()[i][0]) && (this.getBilletes()[i][1] > 0)) {
                    cantidad -= this.getBilletes()[i][0];
                    num_billetes = num_billetes + 1;
                    this.getBilletes()[i][1] -= 1;
                }
                resultado += "\n" + num_billetes + " billetes de " + this.getBilletes()[i][0] + " € ";
            }
            i++;
        }
        if (cantidad != 0) {
            arrayCopy(copia, this.getBilletes());     
        } else {
            System.out.println(resultado);
            salida=true;
        }
        return salida;
    }

    public static void arrayCopy(int[][] aSource, int[][] aDestination) {
        for (int i = 0; i < aSource.length; i++) {
            System.arraycopy(aSource[i], 0, aDestination[i], 0, aSource[i].length);
        }
    }

    public static int localizarUsuario(ArrayList<Tarjeta> p, String nif, int pin) {
//no solo lo localizao sin que devuelvo en que posición está        
        int i = 0;
        boolean encontrado = false;
        int resultado = -1;
        while ((i < p.size()) && (encontrado == false)) {
            if (p.get(i).getNif().equals(nif)) {
                if (p.get(i).getPin() == pin) {
                    encontrado = true;
                    resultado = i;
                } else {
                    encontrado = true;
                    System.out.println("EL PIN INTRODUCIDO ES INCORRECTO");
                }

            } else {
                i++;
            }
        }
        if (encontrado == false) {
            System.out.println("NO SE HA ENCONTRADO EL NIF INTRODUCIDO");
        }
        return resultado;
    }
}
