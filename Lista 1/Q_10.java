import java.util.Scanner;
import java.util.ArrayList;

public class Q_10 {

    public static double calcularTotalCompra(ArrayList<Double> precos) {
        double total = 0;
        for (double preco : precos) {
            total += preco;
        }
        return total;
    }

    public static double calcularDesconto(double totalCompra) {
        if (totalCompra > 500.0) {
            return totalCompra * 0.15;
        } else if (totalCompra > 200.0) {
            return totalCompra * 0.10;
        } else {
            return 0.0;
        }
    }


    public static double calcularValorFinal(double totalCompra, double desconto) {
        return totalCompra - desconto;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> precos = new ArrayList<>();


        while (true) {
            double preco = scanner.nextDouble();
            if (preco == 0) {
                break;
            }
            precos.add(preco);
        }


        double totalCompra = calcularTotalCompra(precos);
        double desconto = calcularDesconto(totalCompra);
        double valorFinal = calcularValorFinal(totalCompra, desconto);


        System.out.printf("Total da compra: %.2f%n", totalCompra);
        System.out.printf("Desconto: %.2f%n", desconto);
        System.out.printf("Valor final: %.2f%n", valorFinal);

        scanner.close();
    }
}