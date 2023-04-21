package menu;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import io.Gravacao;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;

public class MenuInicial {

	private static List<Conta> contas;
	private static List<Funcionario> funcionarios;
	private static Map<String, String> credenciais;
	private static Map<String, Conta> validacao_conta;
	private static Map<String, Funcionario> validacao_funcionario;
	Scanner scanner = new Scanner(System.in);
	public void menuInicial(List<Conta> contas, List<Funcionario> funcionarios, Map<String, String> credenciais,
			Map<String, Conta> validacao_conta, Map<String, Funcionario> validacao_funcionario){
		
		// IMPORTANTE: PARA QUE O CONSOLE EXECUTE AS CORES DE LINHA E FUNDO, PODE SER NECESSÁRIO ALTERAR AS CONFIGURAÇÕES DO SEU CONSOLE:
		// Botão direito sobre o console > Preferences > clicar na seta da opção CONSOLE (no menu à esquerda) > clicar em ANSI support > marcar ENABLE ANSI SUPPORT
		// Para não mostrar os códigos ao lado do terminal, DESMARQUE A OPÇÃO "SHOW ESCAPE SEQUENCES" 
		
		
		//Cores de linha
		String lPreto = "\u001B[30m";
		String lVermelho = "\u001B[31m";
		String lVerde = "\u001B[32m";
		String lAmarelo = "\u001B[33m";
		String lAzul = "\u001B[34m";
		String lRoxo = "\u001B[35m";
		String lCiano = "\u001B[36m";
		String lBranco = "\u001B[37m";
		String lReset = "\u001B[0m"; // volta para a cor padrão de LINHA do terminal
		
		// Cores de fundo
		String fPreto =  "\u001B[40m";
		String fVermelho = "\u001B[41m";
		String fVerde = "\u001B[42m";
		String fAmarelo = "\u001B[43m";
		String fAzul = "\u001B[44m";
		String fRoxo = "\u001B[45m";
		String fCiano = "\u001B[46m";
		String fBranco = "\u001B[47m";
		String fReset = "\u001B[0m"; // volta para a cor padrão de FUNDO do terminal
		
		String flReset = "\u001B[0m";// reseta cores de LINHA E FUNDO simultaneamente
		
		
		MenuInicial.setContas(contas);
		MenuInicial.setFuncionarios(funcionarios);
		MenuInicial.setCredenciais(credenciais);
		MenuInicial.setValidacao_conta(validacao_conta);
		MenuInicial.setValidacao_funcionario(validacao_funcionario);
		Scanner scannerLogin = new Scanner(System.in);
		System.out.println(lAzul + fPreto + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⣿⣿⣿⣿⣿⣿⣿⠟⢋⣡⣤⣤⣤⣌⡉⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⣿⣿⠟⢛⣛⣛⣁⠰⠿⢿⣿⣿⣿⣿⣿⣦⠄⢀⣤⣤⣄⡙⠻⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⡟⠐⠚⠛⠛⠛⠿⢿⣷⣦⣌⡙⠿⣿⣿⡿⣠⣿⠟⣉⡛⢿⣶⣌⠙⢿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⡇⢸⡏⠄⢀⣀⣤⣄⣀⠉⠻⢿⣦⡈⠩⣾⡿⠏⣬⣉⡛⠒⡈⠻⣷⣆⠙⢿⣿⣿");
		System.out.println(lAzul + fPreto + "⣷⠈⠇⠄⢈⣿⡛⠛⠻⢿⠄⣦⣍⠻⣷⡌⠐⠓⢒⣂⡐⢷⣌⠻⣦⡙⣷⡈⢻⣿");
		System.out.println(lAzul + fPreto + "⣿⣷⡀⠴⢿⣿⣇⣄⣈⠪⣦⡉⢡⣷⢌⢻⣦⡘⡗⠙⠻⣦⡙⢷⣌⠻⣌⠻⡄⢻");
		System.out.println(lAzul + fPreto + "⣿⣿⠇⡀⢀⢻⣿⣿⣿⣿⣿⣿⣆⢡⡾⠇⠙⣷⡀⣿⣿⡆⣬⣤⣭⣀⣬⣴⣬⣀");
		System.out.println(lAzul + fPreto + "⣿⠟⣈⠃⠙⢿⣿⣿⡏⠛⠻⠿⣿⣷⣶⢞⢹⠘⣷⠈⡿⢰⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⣿⢂⣉⣉⡛⣦⣿⣿⢃⣶⣶⣾⣿⣿⣏⣼⡟⠄⢹⡇⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⡇⠸⣿⣿⣿⣿⣿⣿⣾⣿⣿⡿⢻⣌⠛⢉⣴⡇⠈⡇⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⣿⣦⣄⣉⠉⠛⠛⠛⠛⠛⢉⣠⣿⡿⠄⢮⣽⡇⠄⠇⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⣿⣿⣿⣿⣷⣄⠄⢰⣶⣿⣿⣿⡿⠃⠺⠶⠟⠄⣀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⣿⣿⣿⣿⣿⡟⠄⣸⣿⡿⠟⠋⢀⣰⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(lAzul + fPreto + "⣿⣿⣿⣿⣿⠄⠄⣉⣀⣤⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + flReset);
		System.out.println(lVerde + fBranco + " H E R M E T I U S   B A N K  " + flReset);
		System.out.println(" ");
		System.out.println(lVerde + fBranco + "╔════════════════════════════╗");
		System.out.println("║   Digite CPF e SENHA:      ║");
		System.out.println("╚════════════════════════════╝");
		System.out.print(lVerde + fBranco + "CPF: " + flReset + lBranco + fVerde);
		String cpf = scannerLogin.nextLine();
		System.out.print(lVerde + fBranco + "SENHA: " + flReset + lBranco + fVerde);
		String senha = scannerLogin.nextLine();
		System.out.println(flReset);
		
		if (credenciais.containsKey(cpf) && credenciais.get(cpf).compareTo(senha) == 0) {
			System.out.println("Login efetuado com sucesso!");

			if (validacao_conta.containsKey(cpf)) {
				if (validacao_funcionario.containsKey(cpf)) {
					menuCliente(validacao_conta.get(cpf), validacao_conta, validacao_funcionario.get(cpf));
				} else {
					menuCliente(validacao_conta.get(cpf), validacao_conta, null);
				}

			} else {
				switch (validacao_funcionario.get(cpf).getCargo()) {

				case "Presidente":
					relatorios(null, validacao_funcionario.get(cpf));
					break;
				case "Diretor":
					relatorios(null, validacao_funcionario.get(cpf));
					break;
				case "Gerente":
					// Gerente sem conta
					relatorios(null, validacao_funcionario.get(cpf));
					break;

				}
			}

		} else {
			System.out.println(fVermelho + lBranco + "Erro! CPF e/ou SENHA incorretos!" + flReset);
			//Scanner scannerNext = new Scanner (System.in);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
			menuInicial(contas, funcionarios, credenciais, validacao_conta, validacao_funcionario);
			
		}
	}


	public void menuCliente(Conta c, Map<String, Conta> validacao_conta, Funcionario f) {


		System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ MENU ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println("╔═══════════════════════════════════════════╗");
		System.out.println("║ 1 -	Movimentações na conta		    ║");
		System.out.println("║ 2  - 	Relatórios			    ║");
		System.out.println("║ 3  -	Voltar ao login			    ║");
		System.out.println("║ 4  -	Encerrar o programa		    ║");
		System.out.println("╚═══════════════════════════════════════════╝");
		System.out.print("\n\nDigite a opção desejada: ");
		int opcaoConta = scanner.nextInt();

		switch (opcaoConta) {
		case 1:
			movimentacoes(c, validacao_conta, f);
			break;
		case 2:
			relatorios(c, f);
			break;
		case 3:
			menuInicial(MenuInicial.getContas(), MenuInicial.getFuncionarios(), MenuInicial.getCredenciais(),
					MenuInicial.getValidacao_conta(), MenuInicial.getValidacao_funcionario());
			break;
		case 4:
			System.out.println("Aplicação encerrada.");
			try {
				Gravacao.pessoas(getContas(), getFuncionarios());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida. Digite novamente:");
			menuCliente(c, validacao_conta, f);
			break;
		}
	}

	public void movimentacoes(Conta c, Map<String, Conta> validacao_conta, Funcionario f) {

		Scanner scannerMov = new Scanner(System.in);
		
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
				if (c.getSaldo() >= valorSaque) {
					c.sacar(valorSaque);
					System.out.println("Saque efetuado com sucesso! Pressione ENTER para continuar.");
					scannerMov.nextLine();
				}else {
					System.out.println("Saldo insuficiente");
					System.out.println("Pressione ENTER para continuar.");
					scannerMov.nextLine();
				}
			retornoMovimentacoes(c, f, validacao_conta);
			break;
		case 2:
			System.out.println("Digite o valor que deseja depositar: ");
			double valorDeposito = scanner.nextDouble();
			c.depositar(valorDeposito);
			System.out.println("Pressione ENTER para continuar.");
			scannerMov.nextLine();
			retornoMovimentacoes(c, f, validacao_conta);
			break;
		case 3:
			System.out.println("Digite o valor que deseja transferir: ");
			double valorTransferencia = scanner.nextDouble();

			System.out.println("Digite o CPF da conta que deseja fazer a transferência: ");
			String destinatario = scanner.next();

			if (validacao_conta.containsKey(destinatario)) {
				c.transferir(valorTransferencia, validacao_conta.get(destinatario));
				System.out.println("Pressione ENTER para continuar.");
				scannerMov.nextLine();
			} else {
				System.out.println("CPF inválido ou não cadastrado. Tente novamente.");
				System.out.println("Pressione ENTER para continuar.");
				scannerMov.nextLine();
			}

			retornoMovimentacoes(c, f, validacao_conta);
			break;
		case 4:
			c.extrato();
			System.out.println("Pressione ENTER para continuar.");
			scannerMov.nextLine();
			retornoMovimentacoes(c, f, validacao_conta);
			break;
		case 5:
			menuCliente(c, validacao_conta, f);
			break;
		default:
			System.out.println("Opção inválida. Digite novamente:");
			retornoMovimentacoes(c, f, validacao_conta);
			break;
		}
	}

	public void relatorios(Conta c, Funcionario f) {

		Scanner scannerRel = new Scanner(System.in);

		System.out.println("\n|*********************** RELATÓRIOS ********************|");
		System.out.println("|========================================================");
		System.out.println("| 1 -	Saldo						|");
		System.out.println("| 2  - 	Relatório de tributações			|");
		System.out.println("| 3  -	Relatório de rendimentos			|");
		System.out.println("| 4  -	Relatório de contas da agência			|");
		System.out.println("| 5  -	Relatório de informações			|");
		System.out.println("| 6  -	Relatório de capital				|");
		System.out.println("| 7  -	Voltar						|");
		System.out.println("|=======================================================|");
		System.out.print("\n\nDigite a opção desejada: ");

		int opcaoRelatorio = scanner.nextInt();

		switch (opcaoRelatorio) {

		case 1:
			if (c != null && f == null) {
				System.out.println("Seu saldo é de: " + NumberFormat.getCurrencyInstance().format(c.getSaldo()) + "\n");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				relatorios(c, null);
			} else if (c != null && f != null) {
				System.out.println("Seu saldo é de: " + NumberFormat.getCurrencyInstance().format(c.getSaldo()) + "\n");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				relatorios(c, f);
			} else {
				System.out.println("Você não possui conta cadastrada em seu CPF.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				relatorios(null, f);
			}
			break;
		case 2:
			if (c instanceof ContaCorrente) {
				double totalT = ((ContaCorrente) c).getTributacaoSaque() + ((ContaCorrente) c).getTributacaoDeposito()
						+ ((ContaCorrente) c).getTributacaoTransferencia();

				System.out.println("\n|*********************** TRIBUTAÇÕES *******************|");
				System.out.println("|========================================================");
				System.out.println("|	Tributação de saques: " + ((ContaCorrente) c).getTributacaoSaque() + "			|");
				System.out.println("|	Tributação de depósitos: " + ((ContaCorrente) c).getTributacaoDeposito() + "			|");
				System.out.println("|	Tributação de transferencias: " + ((ContaCorrente) c).getTributacaoTransferencia() + "		|");
				System.out.println("|	Total de tributação: " + NumberFormat.getCurrencyInstance().format(totalT) + "			|");
				System.out.println("|========================================================\n\n");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
			} else {
				System.out.println("Você não possui acesso a essa função.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				
			}
			retornoRelatorio(c, f);

			break;
		case 3:

			if (c instanceof ContaPoupanca) {
				System.out.println("Digite a quantidade de dias da aplicação:");
				int dias = scanner.nextInt();
				System.out.println("Digite o valor a ser aplicado:");
				double valor = scanner.nextDouble();
				double rendimento = valor * (dias / 30) * 0.01;
				System.out.println("O rendimento será de: " + NumberFormat.getCurrencyInstance().format(rendimento));
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
				break;
			} else {
				System.out.println("Você não possui acesso a essa função.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
			}

		case 4:
			if (f instanceof Gerente || f instanceof Presidente || f instanceof Diretor) {
				((Gerente) f).totalContas(getContas());
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f); 
			}else {
				System.out.println("Você não possui acesso a essa função.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
			}
			retornoRelatorio(c, f);
			break;
		case 5:
			if (f instanceof Diretor || f instanceof Presidente) {
				((Diretor) f).totalInfo(getContas());
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
			}else {
				System.out.println("Você não possui acesso a essa função.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
			}
			retornoRelatorio(c, f);
			break;
		case 6:
			if (f instanceof Presidente) {
				((Presidente) f).totalCapital(getContas());
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
			}else {
				System.out.println("Você não possui acesso a essa função.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
			}
			
			break;
		case 7:
			if (c != null && f == null) {
				menuCliente(c, getValidacao_conta(), null);
			} else if (c != null && f != null) {
				menuCliente(c, getValidacao_conta(), f);
			} else {
				menuInicial(getContas(), getFuncionarios(), getCredenciais(), getValidacao_conta(),
						getValidacao_funcionario());
			}
			break;
		default:
			System.out.println("Opção inválida. Digite novamente:");
			retornoRelatorio(c, f);
			break;
		}
	}

	public void retornoRelatorio(Conta c, Funcionario f) {


		if (c != null && f == null) {
			relatorios(c, null);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
		} else if (c != null && f != null) {
			relatorios(c, f);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
		} else {
			relatorios(null, f);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
		}
	}

	public void retornoMovimentacoes(Conta c, Funcionario f, Map<String, Conta> validacao_conta) {
		if (f == null) {

			
			movimentacoes(c, getValidacao_conta(), null);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
		} else {
			movimentacoes(c, getValidacao_conta(), f);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
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

	public static Map<String, String> getCredenciais() {
		return credenciais;
	}

	public static void setCredenciais(Map<String, String> credenciais) {
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
