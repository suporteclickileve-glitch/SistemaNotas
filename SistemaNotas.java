import java.util.Scanner;

public class SistemaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Variáveis para as estatísticas da turma
        int totalAlunos = 0;
        double somaMediasTurma = 0;

        System.out.println("--- Sistema de Notas Acadêmicas ---");

        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Calcular Nota de Aluno");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Sua opção: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Erro: Digite uma opção válida (0 ou 1).");
                System.out.print("Sua opção: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.print("\nNome do Aluno: ");
                String nomeAluno = scanner.nextLine();

                System.out.print("Nome da disciplina: ");
                String disciplina = scanner.nextLine();

                double nota1 = obterNota(scanner, "Nota 1: ");
                double nota2 = obterNota(scanner, "Nota 2: ");
                double nota3 = obterNota(scanner, "Nota 3: ");

                // Cálculo da média inicial
                double media = (nota1 + nota2 + nota3) / 3.0;
                String situacao;

                // Nova Interação: Fluxo de Recuperação se a média for menor que 7.0
                if (media >= 7.0) {
                    situacao = "Aprovado";
                } else {
                    System.out.printf("\nMédia parcial (%.2f) abaixo de 7.0. O aluno está de Recuperação.\n", media);
                    double notaRecuperacao = obterNota(scanner, "Digite a nota da Recuperação: ");
                    
                    // Nova média considerando a recuperação (substitui a menor nota ou faz nova média simples)
                    media = (media + notaRecuperacao) / 2.0;
                    situacao = (media >= 5.0) ? "Aprovado pós Recuperação" : "Reprovado";
                }

                // Acumula os dados para o relatório final
                totalAlunos++;
                somaMediasTurma += media;

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

        // Nova Interação: Relatório Geral da Turma ao encerrar
        System.out.println("\n--- Estatísticas Finais da Turma ---");
        System.out.println("Total de alunos processados: " + totalAlunos);
        if (totalAlunos > 0) {
            double mediaGeral = somaMediasTurma / totalAlunos;
            System.out.printf("Média Geral da Turma: %.2f\n", mediaGeral);
        } else {
            System.out.println("Nenhum dado de aluno foi registrado nesta sessão.");
        }

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
        scanner.nextLine(); 
        return nota;
    }
}
