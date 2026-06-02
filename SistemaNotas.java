import java.util.Scanner;

public class SistemaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Sistema de Notas Acadêmicas ---");

        System.out.print("Nome do Aluno: ");
        String nomeAluno = scanner.nextLine();

        System.out.print("Nome da disciplina: ");
        String disciplina = scanner.nextLine();

        // Chamadas corrigidas da função obterNota
        double nota1 = obterNota(scanner, "Nota 1: ");
        double nota2 = obterNota(scanner, "Nota 2: ");
        double nota3 = obterNota(scanner, "Nota 3: ");

        // Processamento dos dados
        double media = (nota1 + nota2 + nota3) / 3.0;
        String situacao = (media >= 7.0) ? "Aprovado" : "Reprovado";

        // Exibição do resultado
        System.out.println("\n--- Resumo do Rendimento ---");
        System.out.println("Aluno: " + nomeAluno);
        System.out.println("Disciplina: " + disciplina);
        System.out.printf("Média Final: %.2f\n", media);
        System.out.println("Situação: " + situacao);

        scanner.close();
    }

    // Implementação do método auxiliar que você declarou no main
    public static double obterNota(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.println("Erro: Digite um número válido.");
            System.out.print(mensagem);
            scanner.next(); // Descarta a entrada inválida
        }
        return scanner.nextDouble();
    }
}
