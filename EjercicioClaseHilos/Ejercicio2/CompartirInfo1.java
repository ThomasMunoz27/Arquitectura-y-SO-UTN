package EjercicioClaseHilos.Ejercicio2;

public class CompartirInfo1 {
    public static void main(String[] args) {
        Contador c1 = new Contador(0);
        HiloA h1 = new HiloA("HiloA", c1);
        HiloB h2 = new HiloB("HiloB", c1);
        h1.start();
        h2.start();
    }
}
