package menu;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;
import pessoas.Funcionario;

public class MenuInicial {
	
	private static List<Conta> contas;
	private static List<Funcionario> funcionarios;
	private static Map<String, Integer> credenciais;
	private static Map<String, Conta> validacao_conta;
	private static Map<String, Funcionario> validacao_funcionario;

	public void menuInicial(List<Conta> contas, List<Funcionario> funcionarios, Map<String, Integer> credenciais,
			Map<String, Conta> validacao_conta, Map<String, Funcionario> validacao_funcionario) {
		Scanner scanner = new Scanner(System.in);
		
		MenuInicial.setContas(contas);
		MenuInicial.setFuncionarios(funcionarios);
		MenuInicial.setCredenciais(credenciais);
		MenuInicial.setValidacao_conta(validacao_conta);
		MenuInicial.setValidacao_funcionario(validacao_funcionario);
		
		System.out.println("Digite seu CPF");
		String cpf = scanner.next();
		System.out.println("Digite sua senha");
		int senha = scanner.nextInt();
		scanner.nextLine();

		if (credenciais.containsKey(cpf) && credenciais.get(cpf) == senha) {
			System.out.println("Login efetuado com sucesso");

			if (validacao_conta.containsKey(cpf)) {
				menuCliente(validacao_conta.get(cpf), validacao_conta);

			} else {
				switch (validacao_funcionario.get(cpf).getCargo()) {

				case "Presidente":
					//
					break;
				case "Diretor":
					//
					break;
				case "Gerente":
					//
					break;

				}

			}
		} else {
			System.out.println("Erro");
		}

	}

	public void menuCliente(Conta c, Map<String, Conta> validacao_conta) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("\n|*********************** MENU CONTA ********************|");
		System.out.println("|========================================================");
		System.out.println("| 1 -	Movimentações na conta				|");
		System.out.println("| 2  - 	Relatórios					|");
		System.out.println("| 3  -	Voltar ao menu inicial				|");
		System.out.println("| 4  -	Encerrar o programa				|");
		System.out.println("|========================================================");
		System.out.print("\n\nDigite a opção desejada: ");
		int opcaoConta = scanner.nextInt();

		switch (opcaoConta) {
		case 1:
			movimentacoes(c, validacao_conta);
			break;
		case 2:
			relatorios(c);
			break;
		case 3:
			menuInicial(MenuInicial.getContas(), MenuInicial.getFuncionarios(), MenuInicial.getCredenciais(), MenuInicial.getValidacao_conta(), MenuInicial.getValidacao_funcionario());
			break;
		case 4:
			System.out.println("Aplicação encerrada.");
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida. Digite novamente:");
			menuCliente(c, validacao_conta);
			break;
		}
	}
	
	public void movimentacoes(Conta c, Map<String, Conta> validacao_conta) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n|*************** MENU CONTA - MOVIMENTAÇÕES ************|");
		System.out.println("|========================================================");
		System.out.println("| 1 -	Saque						|");
		System.out.println("| 2  - 	Depósito					|");
		System.out.println("| 3  -	Transferência					|");
		System.out.println("| 4  -	Extrato						|");
		System.out.println("| 5  -	Voltar						|");
		System.out.println("|========================================================\n");
		
		System.out.print("\n\nDigite a opção desejada: ");
		int opcaoMovimentacao = scanner.nextInt();
		
		switch (opcaoMovimentacao) {
			case 1:
				System.out.println("Digite o valor que deseja sacar: ");
				double valorSaque = scanner.nextDouble();
				c.sacar(valorSaque);
				movimentacoes(c, validacao_conta);
				break;
			case 2:
				System.out.println("Digite o valor que deseja depositar: ");
				double valorDeposito = scanner.nextDouble();
				c.depositar(valorDeposito);
				movimentacoes(c, validacao_conta);
				break;
			case 3:
				System.out.println("Digite o valor que deseja transferir: ");
				double valorTransferencia = scanner.nextDouble();
				
				System.out.println("Digite o CPF da conta que deseja fazer a transferência: ");
				String destinatario = scanner.next();
				
				if (validacao_conta.containsKey(destinatario)) {
					c.transferir(valorTransferencia, validacao_conta.get(destinatario));
					movimentacoes(c, validacao_conta);
				} else {
					System.out.println("CPF inválido ou não cadastrado. Tente novamente.");
				}
				
				movimentacoes(c, validacao_conta);
				break;
			case 4:
				//extrato()
				break;
			case 5:
				menuCliente(c, validacao_conta);
				break;
			default:
				System.out.println("Opção inválida. Digite novamente:");
				movimentacoes(c, validacao_conta);
				break;
		}
	}
	public void relatorios (Conta c) {
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("\n|*********************** RELATÓRIOS ********************|");
	System.out.println("|========================================================");
	System.out.println("| 1 -	Saldo						|");
	System.out.println("| 2  - 	Relatório de tributações			|");
	System.out.println("| 3  -	Relatório de rendimentos			|");
	System.out.println("| 4  -	Voltar						|");
	System.out.println("|========================================================");
	System.out.print("\n\nDigite a opção desejada: ");
	
	int opcaoRelatorio = scanner.nextInt();
	
		switch (opcaoRelatorio) {
	
		case 1:
			System.out.println("Seu saldo é de: " + c.getSaldo() + "\n");
			relatorios (c);
			break;
		case 2:
				if (c instanceof ContaCorrente){
					
					double totalT = ((ContaCorrente) c).getTributacaoSaque()+((ContaCorrente) c).getTributacaoDeposito()+((ContaCorrente) c).getTributacaoTransferencia();
					
					System.out.println("\n|*********************** TRIBUTAÇÕES *******************|");
					System.out.println("|========================================================");
					System.out.println("|	Tributação de saques: "+ ((ContaCorrente) c).getTributacaoSaque()+"			|");
					System.out.println("|	Tributação de depósitos: " + ((ContaCorrente) c).getTributacaoDeposito()+"			|");
					System.out.println("|	Tributação de transferencias: " + ((ContaCorrente) c).getTributacaoTransferencia()+"		|");
					System.out.println("|	Total de tributação: " + totalT +"			|");
					System.out.println("|========================================================\n\n");
				}else {
				System.out.println("Opção não disponível para seu tipo de conta");
				}
			relatorios (c);
			break;
		case 3:
			relatorios (c);
			break;
		case 4:
			menuCliente (c, getValidacao_conta());
			break;
		default:
			System.out.println("Opção inválida. Digite novamente:");
			relatorios (c);
			break;
		}
	}

	public static List<Conta> getContas() {
		return contas;
	}

	public static void setContas(List<Conta> contas) {
		MenuInicial.contas = contas;
	}

	public static List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public static void setFuncionarios(List<Funcionario> funcionarios) {
		MenuInicial.funcionarios = funcionarios;
	}

	public static Map<String, Integer> getCredenciais() {
		return credenciais;
	}

	public static void setCredenciais(Map<String, Integer> credenciais) {
		MenuInicial.credenciais = credenciais;
	}

	public static Map<String, Conta> getValidacao_conta() {
		return validacao_conta;
	}

	public static void setValidacao_conta(Map<String, Conta> validacao_conta) {
		MenuInicial.validacao_conta = validacao_conta;
	}

	public static Map<String, Funcionario> getValidacao_funcionario() {
		return validacao_funcionario;
	}

	public static void setValidacao_funcionario(Map<String, Funcionario> validacao_funcionario) {
		MenuInicial.validacao_funcionario = validacao_funcionario;
	}
	
	
}
