package EjercicioClaseHilos.Ejercicio5;


import java.util.Random;

public class Matriz extends Thread{
    private static int tam = 800;
    private static int [][] matriz = new int[tam][tam];
    private int ini, fin;

    public Matriz(int ini, int fin) {
        this.ini = ini;
        this.fin = fin;
    }
    public void run(){
        for (int i = ini; i < fin; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] *= 10;
                }
            }
        }
    public static void main(String[] args) {
        Random rand = new Random(System.nanoTime());
        double tiempo_inicio, tiempo_final;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rand.nextInt(10);
                }
            }
        tiempo_inicio = System.nanoTime();
        Matriz m1 = new Matriz(0, 400);
        Matriz m2 = new Matriz(400, 800);

        m1.start();
        m2.start();

        try {
            m1.join();
            m2.join();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        tiempo_final = System.nanoTime() - tiempo_inicio;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println(matriz[i][j]);
            }
        }
        System.out.println("El proceso demoró " + tiempo_final/1000000 + " milisegundos");
        }
}
