package EjercicioClaseHilos.Ejercicios3;

public class SacarDinero extends Thread{
    private Cuenta c;
    String name;

    public SacarDinero(String name, Cuenta c) {
        super(name);
        this.c = c;
    }
    public void run(){
        for (int i = 0; i <= 4; i++) {
            c.withdraw(10, getName());

        }
    }

}
