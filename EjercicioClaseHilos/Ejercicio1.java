package EjercicioClaseHilos;

public class Ejercicio1 {
    public static void main(String[] args) {
        Hilo[] hilos = new Hilo[10];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Hilo("hilo " + i, i);
            hilos[i].start();

        try{
            hilos[i].join();
        }catch (Exception E){}

        }


            System.out.println(Hilo.cont);

    }
}
