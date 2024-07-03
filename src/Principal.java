import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		SessaoAtual s1 = new SessaoAtual();
		
		while(true) {
			System.out.println("Menu de Seleção:");
			System.out.println("1 - Cadastrar Funcionario");
			System.out.println("2 - Inserir Funcionários da tabela repassada na ordem passada");
			System.out.println("3 - Remover Funcionário");
			System.out.println("4 - Remover Funcionário João");
			System.out.println("5 - Imprimir todos os funcionários");
			System.out.println("6 - Imprimir funcionários de um mês específico");
			System.out.println("7 - Imprimir Funcionários ordenados por ordem alfabética");
			System.out.println("8 - Imprimir o salario total dos funcionarios");
			System.out.println("9 - Imprimir o quantitativo de salarios minimos de cada funcionario");
			System.out.println("10 - Inserir aumento de 10% nos salários");
			System.out.println("11 - Inserir um aumento X% nos salários");
			System.out.println("12 - Imprimir Funcionários que fazem aniversário nos meses 10 e 12");
			System.out.println("13 - Agrupar funcionários por função");
			System.out.println("14 - Imprimir Funcionários agrupados por função");
			System.out.println("15 - Imprimir funcionário com a maior idade");
			System.out.println("0 - Encerrar");
			System.out.print("Escolha a opção desejada: ");
			
			int i = scan.nextInt();
			scan.nextLine();
			
			if(i==1) {
				System.out.print("Insira o nome: ");
				String nome = scan.nextLine();
				System.out.print("Insira a data de nascimento (Formato:dd/mm/aaaa): ");
				String data = scan.nextLine();
				LocalDate date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.print("Insira a Funcao: ");
				String funcao = scan.nextLine();
				System.out.print("Insira o Salário: ");
				BigDecimal salario = scan.nextBigDecimal();
				
				Funcionario func = new Funcionario(nome,date,funcao,salario);
				
				s1.inserirFuncionario(func);
				System.out.println("Funcionário " + nome + " adicionado com Sucesso!");
			}
			else if (i==2) {
				s1.inserirFuncionariosPassados();
				System.out.println("Funcionarios adicionados!");
			}
			else if (i==3) {
				System.out.print("Digite o nome do funcionario a ser removido: ");
				String nome = scan.nextLine();
				
				s1.removerFuncionario(s1.getFuncionario(nome));
				System.out.println("Funcionario " + nome + " removido com sucesso!");
			}
			else if (i==4) {
				s1.removerFuncionario(s1.getFuncionario("João"));
				System.out.println("Funcionario João removido com sucesso!");
			}
			else if (i==5) {
				System.out.println(s1.imprimirFuncionarios());
			}
			else if (i == 6) {
				System.out.print("Insira o mês desejado: ");
				int mes = scan.nextInt();
				System.out.println(s1.imprimirFuncionarios(mes));
			}
			else if (i == 7) {
				s1.ordenarFuncionariosPorNome();
				System.out.println(s1.imprimirFuncionarios());
			}
			else if (i == 8) {
				System.out.println(s1.imprimirSalarios());
			}
			else if (i == 9) {
				System.out.println(s1.imprimirSalariosMinimos());
			}
			else if (i == 10) {
				s1.inserirAumento();
				System.out.println("Aumento de 10% inserido!");
			}
			else if (i==11) {
				System.out.println("Insira a porcentagem a aumentar nos salários: (INSIRA APENAS O PERCENTUAL, EX: 10% INSIRA SOMENTE 10)");
				double perc = (scan.nextDouble())/100.0;
				String percentual = Double.toString(perc);
				s1.inserirAumento(percentual);
				System.out.println("Aumento de " + perc*100.0 + "% inserido!");
			}
			else if (i==12) {
				System.out.println(s1.imprimirFuncionarios(10, 12));
			}
			else if (i==13) {
				s1.agruparFuncao();
				System.out.println("Agrupamento Atualizado!");
			}
			else if (i==14) {
				System.out.println(s1.imprimirAgrupados());
			}
			else if (i==15) {
				System.out.println(s1.imprimirOlder());
			}
			else if (i == 0) {
				System.out.println("Encerrando...");
				scan.close();
				System.exit(0);
			}
			else {
				System.out.println("Opção inválida, tente novamente!");
			}
		}
	}
}
