package EjeFilosofos;

import java.util.concurrent.ThreadLocalRandom;

public class Filosofo extends Thread{
    private int id;
    private static Cubierto[] cubiertosDeMesa = new Cubierto[5];
    public Filosofo(int id) {
        this.id = id;
    }

    public synchronized void run() {
        Cubierto c1 = new Cubierto(1);
        Cubierto c2 = new Cubierto(2);
        Cubierto c3 = new Cubierto(3);
        Cubierto c4 = new Cubierto(4);
        Cubierto c5 = new Cubierto(5);
        cubiertosDeMesa[0] = c1;
        cubiertosDeMesa[1] = c2;
        cubiertosDeMesa[2] = c3;
        cubiertosDeMesa[3] = c4;
        cubiertosDeMesa[4] = c5;

        while (true){
            try {
                sleep(5000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            agarrarCubierto(cubiertosDeMesa);
        }

    }

    public void pensar(){
        System.out.println("El filosofo " + id + " está pensando 🧠");
        int tiempoPensando = ThreadLocalRandom.current().nextInt(1000);
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
                }else {
                    pensar();
                }
                break;

            case 2:
                if (!listCubiertos[0].isOcupado() && !listCubiertos[1].isOcupado()) {
                    comer(listCubiertos, 0, 1);
                }else {
                    pensar();
                }
                break;

            case 3:
                if (!listCubiertos[1].isOcupado() && !listCubiertos[2].isOcupado()) {
                    comer(listCubiertos, 1, 2);
                }else {
                    pensar();
                }
                break;

            case 4:
                if (!listCubiertos[2].isOcupado() && !listCubiertos[3].isOcupado()) {
                    comer(listCubiertos, 2, 3);
                }else {
                    pensar();
                }
                break;

            case 5:
                if (!listCubiertos[3].isOcupado() && !listCubiertos[4].isOcupado()) {
                    comer(listCubiertos, 3, 4);
                }else {
                    pensar();
                }
                break;
        }

    }
    public  void comer(Cubierto[] listCubiertos, int i, int j){
        if (!listCubiertos[i].isOcupado() && !listCubiertos[j].isOcupado()){
            listCubiertos[i].setOcupado(true);
            listCubiertos[j].setOcupado(true);
            System.out.println("El Filosofo " + this.id + " está comiendo 🍔");
        }

        try {
            Thread.sleep(2500);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        if (listCubiertos[i].isOcupado() && listCubiertos[j].isOcupado()){
            listCubiertos[i].setOcupado(false);
            listCubiertos[j].setOcupado(false);
            System.out.println("El Filosofo " + this.id + " ya no está comiendo💀");
            pensar();
        }


    }
}
