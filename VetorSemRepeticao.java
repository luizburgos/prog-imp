import java.util.Scanner;

public class VetorSemRepeticao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vetor = new int[10];
        
        System.out.println("Digite 10 números diferentes!");

        for (int i = 0; i < 10; i++) {
            boolean repetido;
            do {
                int valor = scan.nextInt();
                
                repetido = false;
                for (int j = 0; j < i; j++) {
                    if (vetor[j] == valor) {
                        repetido = true;
                        break;
                    }
                }
                
                if (repetido) {
                    System.out.println("Digite um número diferente.");
                } else {
                    vetor[i] = valor;
                }
            } while (repetido);
        }

        scan.close();

        for (int i = 0; i < 10; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}