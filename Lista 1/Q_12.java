import java.util.Scanner;
import java.util.ArrayList;

public class Q_12 {

    public static int contarQuantidade(ArrayList<Integer> numeros) {
        return numeros.size();
    }

    public static int calcularSoma(ArrayList<Integer> numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        return soma;
    }

    public static double calcularMedia(ArrayList<Integer> numeros) {
        if (numeros.isEmpty()) {
            return 0.0;
        }
        int soma = calcularSoma(numeros);
        return (double) soma / numeros.size();
    }

    public static int encontrarMaior(ArrayList<Integer> numeros) {
        int maior = numeros.get(0);
        for (int num : numeros) {
            if (num > maior) {
                maior = num;
            }
        }
        return maior;
    }

    public static int encontrarMenor(ArrayList<Integer> numeros) {
        int menor = numeros.get(0);
        for (int num : numeros) {
            if (num < menor) {
                menor = num;
            }
        }
        return menor;
    }

    public static int contarPares(ArrayList<Integer> numeros) {
        int pares = 0;
        for (int num : numeros) {
            if (num % 2 == 0) {
                pares++;
            }
        }
        return pares;
    }

    public static int contarImpares(ArrayList<Integer> numeros) {
        int impares = 0;
        for (int num : numeros) {
            if (num % 2 != 0) {
                impares++;
            }
        }
        return impares;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        while (true) {
            int entrada = scanner.nextInt();
            if (entrada == -1) {
                break;
            }
            numeros.add(entrada);
        }

        if (numeros.isEmpty()) {
            System.out.println("Nenhum número válido foi digitado.");
            scanner.close();
            return;
        }

        int quantidade = contarQuantidade(numeros);
        int soma = calcularSoma(numeros);
        double media = calcularMedia(numeros);
        int maior = encontrarMaior(numeros);
        int menor = encontrarMenor(numeros);
        int pares = contarPares(numeros);
        int impares = contarImpares(numeros);

        System.out.println("Quantidade de números: " + quantidade);
        System.out.println("Soma: " + soma);
        System.out.printf("Média: %.1f%n", media);
        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);
        System.out.println("Quantidade de pares: " + pares);
        System.out.println("Quantidade de ímpares: " + impares);

        scanner.close();
    }
}