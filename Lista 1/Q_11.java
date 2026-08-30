import java.util.Scanner;

public class Q_11 {

    public static int encontrarMaior(int[] numeros) {
        int maior = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }
        return maior;
    }

    public static int encontrarMenor(int[] numeros) {
        int menor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        return menor;
    }

    public static int contarPares(int[] numeros) {
        int quantidadePares = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                quantidadePares++;
            }
        }
        return quantidadePares;
    }

    public static double calcularMedia(int[] numeros) {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return (double) soma / numeros.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumeros = 10;
        int[] numeros = new int[totalNumeros];

        for (int i = 0; i < totalNumeros; i++) {
            numeros[i] = scanner.nextInt();
        }

        int maior = encontrarMaior(numeros);
        int menor = encontrarMenor(numeros);
        int qtdPares = contarPares(numeros);
        double media = calcularMedia(numeros);

        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);
        System.out.println("Quantidade de pares: " + qtdPares);
        System.out.printf("Média: %.1f%n", media);

        scanner.close();
    }
}