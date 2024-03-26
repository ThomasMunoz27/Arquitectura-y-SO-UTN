package EjerciciosThreads.Ejercicio7;

public class InterruptCheck {
    public static void main(String[] args) {
        Thread t=Thread.currentThread();
        System.out.println("A:t.isInterrupted()="+ t.isInterrupted());
        t.interrupt();
        System.out.println("B:t.isInterrupted()="+ t.isInterrupted());
        System.out.println("C:t.isInterrupted()="+ t.isInterrupted());
        try{
            Thread.sleep(2000);
            System.out.println("No ha sido interrumpida");
        }catch(InterruptedException e){
            System.out.println("Si ha sido interrumpida");
        }
        System.out.println("D:t.isInterrupted()="+ t.isInterrupted());
    }
}
//Crea una variable de tipo thread, que representa el hilo que se está ejecutando, imprime un mensaje con isInterrupted mostrando que no está interrumpido, luego con otra instruccion lo interrumpe y vuelve a escribir el mensaje para comprobar si esta interrumpido o no. Luego hace un try y si el hilo está interrumpido mostrará un mensaje y si no está interrumpido esperará 2000 milisegundos y mostrará un mensaje diferente