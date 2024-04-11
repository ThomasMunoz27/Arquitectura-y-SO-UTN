package EjeFilosofos;

public class Cubierto {
    private int idCubierto;
    private boolean ocupado = false;

    public Cubierto(int idCubierto) {
        this.idCubierto = idCubierto;
    }

    public int getIdCubierto() {
        return idCubierto;
    }

    public void setIdCubierto(int idCubierto) {
        this.idCubierto = idCubierto;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
