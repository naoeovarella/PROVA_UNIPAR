import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConcursoTalentos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Participantes e seus números
        Map<Integer, String> participantes = new HashMap<>();
        participantes.put(80, "Taffe");
        participantes.put(70, "Rodrigo");
        participantes.put(60, "Lucas");
        participantes.put(50, "Alessandro");

        // Solicitar a quantidade de votantes
        int quantidadeVotantes = 0;
        while (quantidadeVotantes <= 0) {
            System.out.print("Informe a quantidade de pessoas que irão votar: ");
            if (scanner.hasNextInt()) {
                quantidadeVotantes = scanner.nextInt();
                if (quantidadeVotantes <= 0) {
                    System.out.println("Por favor, insira um número positivo.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpar entrada inválida
            }
        }

        // Mapa para contar os votos
        Map<Integer, Integer> votos = new HashMap<>();
        for (int numero : participantes.keySet()) {
            votos.put(numero, 0);
        }

        // Coletar os votos
        for (int i = 1; i <= quantidadeVotantes; i++) {
            int voto = -1;
            while (voto != 80 && voto != 70 && voto != 60 && voto != 50) {
                System.out.println("\nVotante " + i + ":");
                System.out.println("Escolha um participante para votar:");
                for (Integer numero : participantes.keySet()) {
                    System.out.printf("Número: %d - Participante: %s%n", numero, participantes.get(numero));
                }
                System.out.print("Digite o número do participante: ");
                if (scanner.hasNextInt()) {
                    voto = scanner.nextInt();
                    if (votos.containsKey(voto)) {
                        votos.put(voto, votos.get(voto) + 1);
                    } else {
                        System.out.println("Voto inválido. Por favor, escolha um número válido.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.next(); // Limpar entrada inválida
                }
            }
        }

        // Exibir resultados
        System.out.println("\nResultados da votação:");
        int maxVotos = 0;
        int vencedor = -1;

        for (Map.Entry<Integer, Integer> entry : votos.entrySet()) {
            System.out.printf("Participante: %s - Votos: %d%n", participantes.get(entry.getKey()), entry.getValue());
            if (entry.getValue() > maxVotos) {
                maxVotos = entry.getValue();
                vencedor = entry.getKey();
            }
        }

        // Exibir vencedor
        if (vencedor != -1) {
            System.out.printf("%nO vencedor é: %s com %d votos!%n", participantes.get(vencedor), maxVotos);
        }

        scanner.close();
    }
}
