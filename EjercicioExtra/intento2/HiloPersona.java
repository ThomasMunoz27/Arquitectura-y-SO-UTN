package EjercicioExtra.intento2;

class HiloPersona extends Thread {
    private Fila fila;
    private String nombrePersona;

    public HiloPersona(Fila fila, String nombrePersona) {
        this.fila = fila;
        this.nombrePersona = nombrePersona;
    }

    @Override
    public void run() {
        fila.agregarPersona(nombrePersona);
        fila.atenderPersona();
    }
}