import java.util.Scanner;

public class Q_03 {

    public static double calcularMediaSalarial(double[] salarios) {
        if (salarios.length == 0) {
            return 0.0;
        }

        double soma = 0;
        for (int i = 0; i < salarios.length; i++) {
            soma += salarios[i];
        }

        return soma / salarios.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int qtdFuncionarios = scanner.nextInt();

        double[] salarios = new double[qtdFuncionarios];

        for (int i = 0; i < qtdFuncionarios; i++) {
            salarios[i] = scanner.nextDouble();
        }

        double media = calcularMediaSalarial(salarios);

        System.out.printf( "Média salarial: %.2f%n", media);

        scanner.close();
    }
}