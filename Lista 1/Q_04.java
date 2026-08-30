import java.util.Scanner;

public class Q_04 {

    public static int calcularQuantidadeAzulejos(double alturaParede, double larguraParede, double alturaAzulejo, double larguraAzulejo) {
        double areaParede = alturaParede * larguraParede;
        double areaAzulejo = alturaAzulejo * larguraAzulejo;

        double quantidadeExata = areaParede / areaAzulejo;
        return (int) Math.ceil(quantidadeExata);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Altura da parede: ");
        double alturaParede = scanner.nextDouble();

        System.out.print("Largura da parede: ");
        double larguraParede = scanner.nextDouble();

        System.out.print("Altura do azulejo: ");
        double alturaAzulejo = scanner.nextDouble();

        System.out.print("Largura do azulejo: ");
        double larguraAzulejo = scanner.nextDouble();

        int quantidadeAzulejos = calcularQuantidadeAzulejos(alturaParede, larguraParede, alturaAzulejo, larguraAzulejo);

        System.out.println("Quantidade de azulejos necessários: " + quantidadeAzulejos);

        scanner.close();
    }
}