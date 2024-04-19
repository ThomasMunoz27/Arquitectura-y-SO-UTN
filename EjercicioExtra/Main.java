package EjercicioExtra;

public class Main {
    public static void main(String[] args) {


        Cliente c1 = new Cliente(3);
        Cliente c2 = new Cliente(4);
        Cliente c3 = new Cliente(5);
        Cliente c4 = new Cliente(6);
        c1.start();
        c4.start();
        try {
            c1.join();
            c4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        c3.start();
        c2.start();




    }
}