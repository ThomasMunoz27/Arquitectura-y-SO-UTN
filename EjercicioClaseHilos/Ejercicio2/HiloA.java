package EjercicioClaseHilos.Ejercicio2;

public class HiloA extends Thread{
    private Contador contador;

    public HiloA(String name, Contador c) {
        super(name);
        this.contador = c;
    }
    public void run(){
        synchronized (contador){
            for (int i = 0; i < 300; i++) {
                contador.incrementa();
                /*
                try{
                    sleep(100);
                }catch (InterruptedException e){}

                 */
            }
            System.out.println(getName() + " Contador Vale " + contador.getValor());
        }

    }
}
