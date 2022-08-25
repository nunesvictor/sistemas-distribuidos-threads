import java.util.Random;

public class Principal extends Thread {

    public static final int THREADS = 32;
    public static final int MAX_NUMEROS = 1_000_000_000;

    public static final int QUANT = MAX_NUMEROS / THREADS;

    public static void main(String[] args) {
        new Principal();
    }

    public Principal() {
        for (int i = 0; i < THREADS; i++) {
            new Thread(this).start();
        }
    }

    @Override
    public void run() {
        var random = new Random();
        double soma = 0;

        for (int i = 0; i < QUANT; i++) {
            soma += Math.pow(random.nextDouble(), 10);
        }
    }
}
