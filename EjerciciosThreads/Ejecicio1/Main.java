package EjerciciosThreads.Ejecicio1;

public class Main {
    public static void main(String[] args){

// Declaración de 2 threads
        PingPong t1 =new PingPong("PING",33);
        PingPong t2= new PingPong("PONG",10);
// Activación
        t1.start();
        t2.start();
// Espera 2 segundos
        try{Thread.sleep(5000);
        }catch (InterruptedException e){};
// Finaliza la ejecución de los threads
        t1.stop();
        t2.stop();
    }
}
