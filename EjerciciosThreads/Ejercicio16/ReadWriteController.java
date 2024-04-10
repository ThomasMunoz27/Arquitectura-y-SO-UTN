package EjerciciosThreads.Ejercicio16;

public class ReadWriteController {
    Recurso elRecurso;
    int writerWaiting = 0;
    int readerInside = 0;
    int writerInside = 0;

    public Recurso get() {
        goInReader();//obtiene acceso
        return (elRecurso);
        //goOutReader();//libera recurso
    }

    public void write(Recurso newValue) {
        goInWriter();//obtiene acceso
        elRecurso = newValue;
        goOutWriter();//libera recurso
    }

    public synchronized void goInReader(){
        try{
            while ((writerWaiting+writerInside) != 0) wait();
        }catch (InterruptedException e){};
        readerInside=readerInside+1;}
    public synchronized void goOutReader(){
        readerInside=readerInside-1;
        notifyAll();}
    public synchronized void goInWriter(){
        writerWaiting=writerWaiting+1;
        try{
            while((writerInside+readerInside)!=0) wait();
        }catch (InterruptedException e){};
        writerWaiting=writerWaiting-1;
        writerInside=writerInside+1; }
    public synchronized void goOutWriter(){
        writerInside=writerInside-1;
        notifyAll();}
}


