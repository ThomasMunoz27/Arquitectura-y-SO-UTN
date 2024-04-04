package EjemplosExcepciones.Ejercicio1;

public class main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Pablo", 15);
        try{
            p1 = null;
            p1.print();
            //p2.print();
        }catch (NullPointerException e){
            System.out.println("Ese objeto no existe");
        }
    }
}
