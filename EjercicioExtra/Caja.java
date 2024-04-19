package EjercicioExtra;

public class Caja {
    private int idCaja;
    private boolean working = false;


    public Caja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public void atendiendo(int productos){
        this.setWorking(true);
        System.out.println("la caja " + this.idCaja + " está pasando " + productos + " productos");
        int timeSleep = 2000 + (1000 * productos);
        try {
            Thread.sleep(timeSleep);
        }catch (InterruptedException e){

        }
        System.out.println("La caja " + this.idCaja + " terminó de atender");
        this.setWorking(false);
    }
}
