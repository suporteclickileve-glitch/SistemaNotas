import java.util.Scanner;

public class SistemaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("--- Sistema de Notas Acadêmicas ---");

        // Loop principal do programa
        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Calcular Nota de Aluno");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Sua opção: ");
            
            // Valida se a opção digitada é um número inteiro
            while (!scanner.hasNextInt()) {
                System.out.println("Erro: Digite uma opção válida (0 ou 1).");
                System.out.print("Sua opção: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado após ler o número inteiro

            if (opcao == 1) {
                System.out.print("\nNome do Aluno: ");
                String nomeAluno = scanner.nextLine();

                System.out.print("Nome da disciplina: ");
                String disciplina = scanner.nextLine();

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
                System.out.println("----------------------------");
                
            } else if (opcao != 0) {
                System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        System.out.println("\nSistema encerrado. Até mais!");
        scanner.close();
    }

    public static double obterNota(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.println("Erro: Digite um número válido.");
            System.out.print(mensagem);
            scanner.next();
        }
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer para evitar problemas com próximos nextLine()
        return nota;
    }
}
