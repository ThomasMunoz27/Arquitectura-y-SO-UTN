package EjerciciosThreads.Ejecicio2;

import EjerciciosThreads.Ejecicio1.PingPong;

public class PruebaRunnable {
    public static void main(String[] args){
// Los objetos r1 y r2 definen la funcionalidad.
// (definen los métodos run())
        PingPong r1 =new PingPong("PING",33);
        PingPong r2= new PingPong("PONG",10);
// Se crean los threads
        Thread t1 = new Thread(r1);
        Thread t2= new Thread(r2);
// Se activan los threads
        t1.start();
        t2.start();
        try {
            Thread.sleep(500);
            t1.stop();
            t2.stop();
        }catch (Exception E) {}

    }
}
