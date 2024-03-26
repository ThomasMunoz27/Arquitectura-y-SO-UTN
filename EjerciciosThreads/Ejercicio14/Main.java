package EjerciciosThreads.Ejercicio14;

public class Main {
    public static void main(String[] args) {
        System.out.println("Comienza main()");
        Thread t=new Thread(new DaemondThread());
        t.setDaemon(true);
        t.start();
        try{Thread.sleep(2000);
        }catch (InterruptedException e){};
        System.out.println("Termina main()");
    }
}

