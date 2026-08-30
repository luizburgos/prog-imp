import java.util.Scanner;

public class Q_07 {

    public static long calcularFatorial(int n) {
        long fatorial = 1;
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();

        long resultado = calcularFatorial(numero);

        System.out.println("Fatorial: " + resultado);

        scanner.close();
    }
}