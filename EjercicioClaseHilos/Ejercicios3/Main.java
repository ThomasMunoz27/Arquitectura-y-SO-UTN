package EjercicioClaseHilos.Ejercicios3;

public class Main {
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(50);
        SacarDinero h1 = new SacarDinero("Pablo",c1);
        SacarDinero h2 = new SacarDinero("Ruth", c1);
        h1.start();
        h2.start();

    }
}
