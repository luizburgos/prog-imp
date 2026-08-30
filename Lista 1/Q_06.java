import java.util.Scanner;

public class Q_06 {

    public static double calcularPotenciaHp(double massa, double altura, double tempo) {
        double g = 9.81;
        double potenciaWatts = (massa * g * altura) / tempo;
        double potenciaHp = potenciaWatts / 745.6999;
        
        return potenciaHp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Massa: ");
        double massa = scanner.nextDouble();

        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        System.out.print("Tempo: ");
        double tempo = scanner.nextDouble();

        double potenciaHp = calcularPotenciaHp(massa, altura, tempo);

        System.out.printf("Potência necessária: %.3f hp%n", potenciaHp);

        scanner.close();
    }
}