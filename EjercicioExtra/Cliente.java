package EjercicioExtra;

import java.util.concurrent.ThreadLocalRandom;

public class Cliente extends Thread{
    private int idCliente;
    private boolean esperandoEnFila = false;

    private static SuperMercado sm1 = new SuperMercado("Atomo");

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public synchronized void  run(){
        SuperMercado sm1 = new SuperMercado("Atomo");
        comprando();
        System.out.println("Los clientes que estan esperando en la fila son: ");
        for (Cliente c: sm1.getFila()) {
            System.out.println("holaaaa" + c.idCliente);
        }
        System.out.println("lel");
    }

    public void comprando(){
        System.out.println("El cliente: " + this.idCliente + " está seleccionando productos");
        try{
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            this.esperandoEnFila = true;
            System.out.println("El cliente: " + this.idCliente + " está esperando en la fila, para pagar");
            sm1.agregarClienteFila(this);

        }catch (Exception e){
            System.out.println(e);
        }

    }
}