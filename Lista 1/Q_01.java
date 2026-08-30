import java.util.Scanner;

public class Q_01 {

    public static void exibirFahrenheit(double celsius) {
        double fahrenheit = celsius * 1.8 + 32;
        System.out.printf("Fahrenheit: %.3f%n", fahrenheit);
    }

    public static void exibirKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        System.out.printf("Kelvin: %.3f%n", kelvin);
    }

    public static void exibirReaumur(double celsius) {
        double reaumur = celsius * 0.8;
        System.out.printf("Réaumur: %.3f%n", reaumur);
    }

    public static void exibirRankine(double celsius) {
        double rankine = celsius * 1.8 + 491.67;
        System.out.printf("Rankine: %.3f%n", rankine);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double celsius = scanner.nextDouble();

        exibirFahrenheit(celsius);
        exibirKelvin(celsius);
        exibirReaumur(celsius);
        exibirRankine(celsius);

        scanner.close();
    }
}