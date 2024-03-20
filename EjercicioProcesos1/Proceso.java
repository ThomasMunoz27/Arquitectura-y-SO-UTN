package EjercicioProcesos1;

public class Proceso extends Thread{
    public int id;

    public Proceso(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Soy el proceso " + this.getName() + " " + id);
    }
}
