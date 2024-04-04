package EjemplosExcepciones;

public class Aritmetica {
    public static void main(String[] args) {

        try {
// Se intenta hacer la división
            int division = 10 / 0;
            System.out.println(division);
        } catch (ArithmeticException a) {
// Si la división falla el programa va al bloque catch y se ejecuta el

            System.out.println("Error: " + a.getMessage());
            System.out.println("Error: " + a);
            //System.out.println(a.fillStrakTrace());

        } finally {
// Si el programa hizo la división o no, este System.out.print se va a ejecutar igual
            System.out.println("Saliendo del try");
        }

    }
}