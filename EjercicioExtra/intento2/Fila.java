package EjercicioExtra.intento2;

import java.util.LinkedList;
import java.util.Queue;

class Fila {
    private Queue<String> fila;

    public Fila() {
        fila = new LinkedList<>();
    }

    // Método para agregar una persona a la fila
    public synchronized void agregarPersona(String nombrePersona) {
        fila.offer(nombrePersona);
        System.out.println(nombrePersona + " se unió a la fila.");
        notify(); // Notificar a cualquier hilo en espera
    }

    // Método para atender a una persona en la fila
    public synchronized void atenderPersona() {
        while (fila.isEmpty()) {
            try {
                System.out.println("La fila está vacía. Esperando a alguien...");
                wait(); // Esperar hasta que alguien se una a la fila
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String personaAtendida = fila.poll();
        System.out.println("Se atendió a " + personaAtendida + ".");
    }
}
