/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

/**
 *
 * @author Rafael
 */
public class TarjetaCredito extends Tarjeta {

    private double saldoDisp;
    private double creditoDisp;

    public TarjetaCredito() {
    }
    
    public TarjetaCredito(String nif, int pin, String nombre, String apellido, double saldoDisp, double creditoDisp) {
        super(nif, pin, nombre, apellido);
        this.setSaldoDisp(saldoDisp);
        this.setCreditoDisp(creditoDisp);
    }
    
    public TarjetaCredito(TarjetaCredito t1) {
        super((Tarjeta)t1);
        this.setSaldoDisp(t1.getSaldoDisp());
        this.setCreditoDisp(t1.getCreditoDisp());
    }
    public double getSaldoDisp() {
        return saldoDisp;
    }

    public void setSaldoDisp(double saldoDisp) {
        this.saldoDisp = saldoDisp;
    }

    public double getCreditoDisp() {
        return creditoDisp;
    }

    public void setCreditoDisp(double creditoDisp) {
        this.creditoDisp = creditoDisp;
    }

    public void aumentar_SaldoDisp(double importe) {
        this.setSaldoDisp(this.getSaldoDisp() + importe);
    }

    @Override
    public void disminuirSaldoDisp(double importe) {
        if (this.getSaldoDisp() < importe) {
            importe -= this.getSaldoDisp();
            this.setSaldoDisp(0);
            this.setCreditoDisp(this.getCreditoDisp() - importe);
        } else {
            this.setSaldoDisp(this.getSaldoDisp() - importe);
        }
    }
    

    public boolean comprobarSaldoSuficiente(double importe) {
        return (this.getSaldoDisp() + this.getCreditoDisp()) >= importe;
    }

    @Override
    public void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println("Tarjeta de credito:");
        System.out.println("Saldo: " + this.getSaldoDisp());
        System.out.println("Crédito: " + this.getCreditoDisp());
    }

}
