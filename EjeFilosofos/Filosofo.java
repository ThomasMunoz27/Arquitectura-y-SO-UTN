package EjeFilosofos;
import java.util.Random;
public class Filosofo extends Thread{
    private int id;
    private static Cubierto[] cubiertos;
    public Filosofo(int id) {
        this.id = id;
    }

    public void run() {
        Cubierto c1 = new Cubierto(1);
        Cubierto c2 = new Cubierto(2);
        Cubierto c3 = new Cubierto(3);
        Cubierto c4 = new Cubierto(4);
        Cubierto c5 = new Cubierto(5);
        Cubierto[] cubiertosDeMesa = {c1,c2,c3,c4,c5};

        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            agarrarCubierto(cubiertosDeMesa);
        }

    }

    public synchronized void pensar(){
        Random random = new Random();
        int tiempoPensando = random.nextInt(1000,5001);
        System.out.println("El filosofo " + id + " está pensando");
        try {
            Thread.sleep(tiempoPensando);
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public synchronized void agarrarCubierto(Cubierto[] listCubiertos){
        switch (this.id){
            case 1:
                if (!listCubiertos[4].isOcupado() && !listCubiertos[0].isOcupado()) {
                    comer(listCubiertos, 4, 0);
                    try {
                        pensar();
                        wait();
                    }catch (InterruptedException ie){
                        System.out.println(ie);
                    }
                }

            case 2:
                if (!listCubiertos[0].isOcupado() && !listCubiertos[1].isOcupado()) {
                    comer(listCubiertos, 0, 1);
                    try {
                        pensar();
                        wait();
                    }catch (InterruptedException ie){
                        System.out.println(ie);
                    }
                }

            case 3:
                if (!listCubiertos[1].isOcupado() && !listCubiertos[2].isOcupado()) {
                    comer(listCubiertos, 1, 2);
                    try {
                        pensar();
                        wait();
                    }catch (InterruptedException ie){
                        System.out.println(ie);
                    }
                }

            case 4:
                if (!listCubiertos[2].isOcupado() && !listCubiertos[3].isOcupado()) {
                    comer(listCubiertos, 2, 3);
                    try {
                        pensar();
                        wait();
                    }catch (InterruptedException ie){
                        System.out.println(ie);
                    }
                }

            case 5:
                if (!listCubiertos[3].isOcupado() && !listCubiertos[4].isOcupado()) {
                    comer(listCubiertos, 3, 4);
                    try {
                        pensar();
                        wait();
                    }catch (InterruptedException ie){
                        System.out.println(ie);
                    }
                }
        }

    }
    public void comer(Cubierto[] listCubiertos, int i, int j){

        listCubiertos[i].setOcupado(true);
        listCubiertos[j].setOcupado(true);
        System.out.println("El Filosofo " + this.id + " está comiendo 🍔");
        listCubiertos[i].setOcupado(false);
        listCubiertos[j].setOcupado(false);
        System.out.println("El Filosofo " + this.id + " ya no está comiendo💀");
        notifyAll();

    }
}
