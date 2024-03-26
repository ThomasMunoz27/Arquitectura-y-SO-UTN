package EjerciciosThreads.Ejercicio8;

public class InterrumptReset {
    public static void main(String[] args) {
        Thread t=Thread.currentThread();
        System.out.println("A: Thread.interrupted()="+ Thread.interrupted());
        t.interrupt();
        System.out.println("B: Thread.interrupted()="+Thread.interrupted());
        System.out.println("C: Thread.interrupted()="+Thread.interrupted());
        try{
            Thread.sleep(2000);
            System.out.println("No ha sido interrumpida");
        }catch(InterruptedException e){
            System.out.println("Si ha sido interrumpida");
        }
        System.out.println("D: t.isInterrupted()="+t.isInterrupted());
    }
}//Crea una variable de tipo thread, que representa el hilo que se está ejecutando, imprime un mensaje con Thread.interrupted mostrando que no está interrumpido, luego con otra instruccion lo interrumpe y vuelve a escribir el mensaje imprimiendo que está interrumpido y luego reinicia el Thread y ya no está interrumpido, por lo que el siguiente mensaje mostrará que no está interrumpido. Luego hace un try y si el hilo está interrumpido mostrará un mensaje y si no está interrumpido esperará 2000 milisegundos y mostrará un mensaje diferente
