package EjercicioExtra.intento2;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();

        // Crear dos hilos representando a dos personas que intentan ingresar a la fila
        HiloPersona persona1 = new HiloPersona(fila, "Persona 1");
        HiloPersona persona2 = new HiloPersona(fila, "Persona 2");
        HiloPersona persona3 = new HiloPersona(fila, "Persona 3");
        HiloPersona persona4 = new HiloPersona(fila, "Persona 4");
        // Iniciar los hilos
        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();


    }}
