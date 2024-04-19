package EjercicioExtra;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Cliente extends Thread{
    private int idCliente;
    private int cantProductos;
    private static Caja[] cajas;

    private static Semaphore fila;
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
        this.cantProductos = 0;
        this.cajas = new Caja[2];
        fila = new Semaphore(0);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(int cantProductos) {
        this.cantProductos = cantProductos;
    }

    public static Caja[] getCajas() {
        return cajas;
    }

    public static void setCajas(Caja[] cajas) {
        Cliente.cajas = cajas;
    }

    public synchronized void  run(){
        Caja c1 = new Caja(1);
        Caja c2 = new Caja(2);
        cajas[0] = c1;
        cajas[1] = c2;


        comprando();

    }

    public void comprando(){
        System.out.println("El cliente: " + this.idCliente + " está seleccionando productos");
        try{
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            cantProductos = ThreadLocalRandom.current().nextInt(1, 10);
        }catch (Exception e){
            System.out.println(e);
        }

            if (cajas[0].isWorking() && cajas[1].isWorking()){
                System.out.println("El cliente: " + this.idCliente + " está esperando en la fila, para pagar");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(cajas[0].isWorking() == false){
                System.out.println("El cliente: " + this.idCliente + " está siendo atendido en la caja 1");
                cajas[0].atendiendo(this.cantProductos);


            } else if (cajas[1].isWorking() == false) {
                System.out.println("El cliente: " + this.idCliente + " está siendo atendido en la caja 2");
                cajas[1].atendiendo(this.cantProductos);

                notify();
            }
        System.out.println("El cliente " + this.idCliente + " se fue del supermercado");



    }
}