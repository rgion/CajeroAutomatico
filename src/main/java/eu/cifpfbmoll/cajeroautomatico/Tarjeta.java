/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

/**
 * son <b>comentarios</b> 1
 *
 * @author professorat son comentarios 2
 */
public abstract class Tarjeta {

    private String nif;
    private int pin;
    private String nombre;
    private String apellido;
    private boolean estado;//true activada false desactivada

    /**
     *
     * @param nif nif del cliente
     * @param pin pin numérico del cliente
     * @param nombre
     * @param apellido
     */

    public Tarjeta() {
    }

    public Tarjeta(String nif, int pin, String nombre, String apellido) {
        this.setNif(nif);
        this.setApellido(apellido);
        this.setEstado(estado);
        this.setNombre(nombre);
        this.setPin(pin);
    }

    public Tarjeta(Tarjeta t1) {
        this.setNif(t1.getNif());
        this.setApellido(t1.getApellido());
        this.setEstado(t1.isEstado());
        this.setNombre(t1.getNombre());
        this.setPin(t1.getPin());
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
        /**
         * @code jdkddd
         */

    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void mostrarTarjeta() {
        //un metodo para comprobar la evolución de los saldos de Tarjetas 
        //y cajero.
        System.out.println("======================");
        System.out.println(" DATOS DE LA TARJETA DEL CLIENTE");
        System.out.println("Nombre : " + this.getNombre());
        System.out.println("Apellido: " + this.getApellido());
        System.out.println("NIF: " + this.getNif());
    }

    public abstract void disminuirSaldoDisp(double importe);
}
