/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

/**
 *
 * @author infor18
 */
public class ExcepcionCajero extends Exception {
    private String mensaje;
    public ExcepcionCajero (double cantidad) {
        super();
        this.mensaje=" Actualmente el cajero no dispone de efectivo"
                + " suficiente para satisfacer la cantidad de "
                + Double.toString(cantidad) + " €. ";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void añadirMensaje(String newMessage){
        this.setMensaje(this.getMensaje()+newMessage);
    }
    
}
