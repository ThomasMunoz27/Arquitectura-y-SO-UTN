package EjeFilosofos;

public class Main {
    public static void main(String[] args) {

        Filosofo f1 = new Filosofo(1);
        Filosofo f2 = new Filosofo(2);
        Filosofo f3 = new Filosofo(3);
        Filosofo f4 = new Filosofo(4);
        Filosofo f5 = new Filosofo(5);


        f2.start();
        f4.start();
        f1.start();
        f5.start();
        f3.start();





    }
}
