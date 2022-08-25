import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamJava {
    private static final int QUANT = 30_000_000;

    public StreamJava() {
        var random = new Random();
        List<Estudante> estudantes = new LinkedList<>();

//        for (int i = 0; i < QUANT; i++) {
//            estudantes.add(new Estudante(random.nextDouble()));
//        }

        estudantes = IntStream.range(0, QUANT)
                .mapToObj(i -> new Estudante(random.nextDouble()))
                .toList();

        double maiorNota = estudantes
                .stream()
                .mapToDouble(Estudante::getNota)
                .max()
                .orElse(0);

        System.out.println(maiorNota);
    }

    public static void main(String[] args) {
        new StreamJava();
    }
}
