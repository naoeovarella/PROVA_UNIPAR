import java.util.Scanner;

public class LIstaCarros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int quantidadeCarros = 0;
        while (quantidadeCarros <= 0) {
            System.out.print("Informe a quantidade de carros: ");
            if (scanner.hasNextInt()) {
                quantidadeCarros = scanner.nextInt();
                if (quantidadeCarros <= 0) {
                    System.out.println("Por favor, insira um número positivo.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();
            }
        }


        double[] avaliacoes = new double[quantidadeCarros];
        for (int i = 0; i < quantidadeCarros; i++) {
            double nota = -1;
            while (nota < 0 || nota > 10) {
                System.out.printf("Informe a nota para o carro %d (0 a 10): ", i + 1);
                if (scanner.hasNextDouble()) {
                    nota = scanner.nextDouble();
                    if (nota < 0 || nota > 10) {
                        System.out.println("Nota inválida. A nota deve estar entre 0 e 10.");
                    } else {
                        avaliacoes[i] = nota;
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.next();
                }
            }
        }


        double soma = 0;
        int carrosBons = 0;
        int carrosRuins = 0;

        for (double nota : avaliacoes) {
            soma += nota;
            if (nota >= 6) {
                carrosBons++;
            } else {
                carrosRuins++;
            }
        }

        double mediaAvaliacoes = soma / quantidadeCarros;


        System.out.printf("\nMédia das avaliações: %.2f%n", mediaAvaliacoes);
        System.out.printf("Quantidade de carros avaliados como bons (nota >= 6): %d%n", carrosBons);
        System.out.printf("Quantidade de carros avaliados como ruins (nota < 6): %d%n", carrosRuins);

        scanner.close();
    }
}
