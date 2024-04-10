package EjeFilosofos;
import java.util.Random;
public class Filosofo extends Thread{
    private int id;
    private static Cubierto[] cubiertos;
    public Filosofo(int id) {
        this.id = id;
    }

    public void run() {

    }

    public void pensar(){
        Random random = new Random();
        int tiempoPensando = random.nextInt(5001);
        System.out.println("El filosofo " + id + " está pensando");
        try {
            wait(tiempoPensando);
        }catch (Exception e){
            System.out.println(e);
        }
        comer();
    }
    public void agarrarCubierto(){

    }
    public void comer(){
        //if ()
    }
}
