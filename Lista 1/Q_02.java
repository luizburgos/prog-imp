import java.util.Scanner;

public class Q_02 {

    public static double calcularMaiorAltura(double[] alturas) {
        double maior = alturas[0];
        for (int i = 1; i < alturas.length; i++) {
            if (alturas[i] > maior) {
                maior = alturas[i];
            }
        }
        return maior;
    }

    public static double calcularMenorAltura(double[] alturas) {
        double menor = alturas[0];
        for (int i = 1; i < alturas.length; i++) {
            if (alturas[i] < menor) {
                menor = alturas[i];
            }
        }
        return menor;
    }

    public static double calcularMediaAlturaHomens(double[] alturas, int[] sexos) {
        double somaAlturas = 0;
        int quantidadeHomens = 0;

        for (int i = 0; i < alturas.length; i++) {
            if (sexos[i] == 2) {
                somaAlturas += alturas[i];
                quantidadeHomens++;
            }
        }

        if (quantidadeHomens == 0) {
            return 0.0;
        }

        return somaAlturas / quantidadeHomens;
    }

    public static int contarQuantidadeMulheres(int[] sexos) {
        int quantidadeMulheres = 0;

        for (int i = 0; i < sexos.length; i++) {
            if (sexos[i] == 1) {
                quantidadeMulheres++;
            }
        }

        return quantidadeMulheres;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPessoas = 10;
        double[] alturas = new double[totalPessoas];
        int[] sexos = new int[totalPessoas];

        for (int i = 0; i < totalPessoas; i++) {
            sexos[i] = scanner.nextInt();
            alturas[i] = scanner.nextDouble();
        }

        double maiorAltura = calcularMaiorAltura(alturas);
        double menorAltura = calcularMenorAltura(alturas);
        double mediaHomens = calcularMediaAlturaHomens(alturas, sexos);
        int qtdMulheres = contarQuantidadeMulheres(sexos);

        System.out.printf( "Maior altura: %.2f m%n", maiorAltura);
        System.out.printf( "Menor altura: %.2f m%n", menorAltura);
        System.out.printf( "Média de altura dos homens: %.2f m%n", mediaHomens);
        System.out.println("Número de mulheres: " + qtdMulheres);

        scanner.close();
    }
}