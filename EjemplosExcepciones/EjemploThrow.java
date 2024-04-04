package EjemplosExcepciones;

import java.util.ArrayList;
import java.util.List;

public class EjemploThrow {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        try {
            agregarNumeroLista(lista,1);
            agregarNumeroLista(lista, 1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void agregarNumeroLista(List<Integer> lista, int numero) throws Exception {
        if(lista.contains(numero)){
// Si lo tiene tiramos un excepción de tipo Exception, poniéndole un mensaje entre los paréntesis
            throw new Exception("El numero ya está en la lista");
        }
        lista.add(numero);

    }
}
