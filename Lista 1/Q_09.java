import java.util.Scanner;

public class Q_09 {

    public static double calcularMediaAluno(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    public static String determinarSituacao(double media) {
        if (media >= 7.0) {
            return "Aprovado";
        } else if (media >= 5.0) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public static double calcularMediaTurma(double[] mediasAlunos) {
        if (mediasAlunos.length == 0) {
            return 0.0;
        }

        double somaMedias = 0.0;
        for (int i = 0; i < mediasAlunos.length; i++) {
            somaMedias += mediasAlunos[i];
        }

        return somaMedias / mediasAlunos.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int qtdAlunos = scanner.nextInt();

        double[] mediasAlunos = new double[qtdAlunos];
        String[] situacoesAlunos = new String[qtdAlunos];

        for (int i = 0; i < qtdAlunos; i++) {
            double nota1 = scanner.nextDouble();
            double nota2 = scanner.nextDouble();
            double nota3 = scanner.nextDouble();

            double mediaIndividual = calcularMediaAluno(nota1, nota2, nota3);
            String situacao = determinarSituacao(mediaIndividual);

            mediasAlunos[i] = mediaIndividual;
            situacoesAlunos[i] = situacao;
        }

        double mediaGeral = calcularMediaTurma(mediasAlunos);

        for (int i = 0; i < qtdAlunos; i++) {
            System.out.printf("Aluno %d - Média: %.1f - %s%n", (i + 1), mediasAlunos[i], situacoesAlunos[i]);
        }
        System.out.printf("Média geral da turma: %.1f%n", mediaGeral);

        scanner.close();
    }
}