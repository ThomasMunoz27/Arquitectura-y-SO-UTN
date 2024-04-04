package EjercicioClaseHilos.Ejercicio6;

import java.util.Random;

public class Matriz2 extends Thread{
    private static int tam = 9;
    private static int [][] matriz = new int[tam][tam];
    private int ini, fin;

    public Matriz2(int ini, int fin) {
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
        Runtime runtime = Runtime.getRuntime();

        int nNucleos = runtime.availableProcessors();
        Random rand = new Random(System.nanoTime());
        double tiempo_inicio, tiempo_final;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rand.nextInt(10);
            }

        }
        Thread[]hilos = new Thread[nNucleos];
        int rango = tam/nNucleos;
        int start = 0;
        int finish = rango;
        for (int i = 0; i < nNucleos; i++) {
            if (i != nNucleos -1){
                hilos[i] = new Matriz2(start, finish);
                hilos[i].start();
                start = finish;
                finish += start;
        }else{
                hilos[i] = new Matriz2(start,tam);
                hilos[i].start();
            }


        }

        tiempo_inicio = System.nanoTime();
        Matriz2 m1 = new Matriz2(0, 400);
        Matriz2 m2 = new Matriz2(400, 800);

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
