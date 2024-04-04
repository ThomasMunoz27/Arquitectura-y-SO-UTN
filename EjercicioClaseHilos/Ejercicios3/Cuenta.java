package EjercicioClaseHilos.Ejercicios3;

public class Cuenta {
    private double balance;

    public Cuenta(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void restar(double amount){
        balance -= amount;
    }

    synchronized public void withdraw(double amount, String name){
        if (getBalance()>=amount){
            System.out.println(name+ " VA A RETIRAR "+ amount+ " SALDO(ACTUAL ES : " + balance+")");

            try {
                Thread.sleep(1000);
            }catch (Exception E){}
            restar(amount);

            System.out.println(name + " retiró $"+ amount +" Su saldo actual es: " + this.getBalance());
        }else {
            System.out.println("No se puede retirar saldo. SALDO INSUFICIENTE");
        }


    }
}
