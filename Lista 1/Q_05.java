import java.util.Scanner;

public class Q_05
 {

    public static double calcularVolume(double raio, double altura) {
        return Math.PI * Math.pow(raio, 2) * altura;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Raio: ");
        double raio = scanner.nextDouble();

        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        double volume = calcularVolume(raio, altura);

        System.out.printf("Volume da lata de óleo: %.2f m³%n", volume);

        scanner.close();
    }
}