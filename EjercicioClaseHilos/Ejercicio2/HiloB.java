package EjercicioClaseHilos.Ejercicio2;

public class HiloB extends Thread{
    private Contador contador;
    public HiloB(String name, Contador c) {
        super(name);
        this.contador = c;
    }
    public void run(){
        for (int i = 0; i < 300; i++) {
            contador.decrementa();
            /*
            try{
                sleep(100);
            }catch (InterruptedException e){}

             */

        }
        System.out.println(getName() + " Contador Vale " + contador.getValor());
    }
}

