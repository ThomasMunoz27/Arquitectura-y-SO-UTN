package EjercicioProcesos1;

public class Main {
    public static void main(String[] args) {
        Proceso p1 = new Proceso("Llamar impresora", 1);
        Proceso p2 = new Proceso("Grabar disco", 2);
        Proceso p3 = new Proceso("Sumar", 3);
        Proceso p4 = new Proceso("Tomar datos casilla 001", 4);

        p1.start();
        p2.start();
        p3.start();
        p4.start();

    }
}
