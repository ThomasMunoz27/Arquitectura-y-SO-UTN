package EjercicioExtra;

import java.util.ArrayList;

public class SuperMercado {
    private ArrayList<Cliente> fila = new ArrayList<>();
    private String nombre;

    public SuperMercado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getFila() {
        return fila;
    }

    public void setFila(ArrayList<Cliente> fila) {
        this.fila = fila;
    }

    public void agregarClienteFila(Cliente cliente){
        fila.add(cliente);
    }

    public void mostrarFila(){
        for (Cliente c: fila) {
            System.out.println(c.getIdCliente());

        }
    }




}