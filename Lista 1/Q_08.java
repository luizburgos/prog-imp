import java.util.Scanner;

public class Q_08 {

    public static int calcularHoras(int totalSegundos) {
        return totalSegundos / 3600;
    }

    public static int calcularMinutos(int totalSegundos) {
        int segundosRestantes = totalSegundos % 3600;
        return segundosRestantes / 60;
    }

    public static int calcularSegundosRestantes(int totalSegundos) {
        return totalSegundos % 60;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSegundos = scanner.nextInt();

        int horas = calcularHoras(totalSegundos);
        int minutos = calcularMinutos(totalSegundos);
        int segundos = calcularSegundosRestantes(totalSegundos);

        System.out.println(horas + " hora(s)");
        System.out.println(minutos + " minuto(s)");
        System.out.println(segundos + " segundo(s)");

        scanner.close();
    }
}