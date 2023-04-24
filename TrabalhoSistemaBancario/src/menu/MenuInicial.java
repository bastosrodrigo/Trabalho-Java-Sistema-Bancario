package menu;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.SeguroVida;
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
	private static Double taxaSeguro;
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
		
		// Guarda todas as listas/maps do SistemaBancario para facilitar acesso
		setContas(contas);
		setFuncionarios(funcionarios);
		setCredenciais(credenciais);
		setValidacao_conta(validacao_conta);
		setValidacao_funcionario(validacao_funcionario);
		
		
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
		System.out.println(lVerde + fAzul + " H E R M E T I U S   B A N K  " + flReset);
		System.out.println(" ");
		System.out.println(lVerde + fBranco + "╔════════════════════════════╗");
		System.out.println("║   Digite CPF e SENHA:      ║");
		System.out.println("╚════════════════════════════╝");
		System.out.print(lVerde + fBranco + "CPF: " + flReset + lBranco + fVerde);
		
		String cpf = scannerLogin.nextLine();
		
		System.out.print(lVerde + fBranco + "SENHA: " + flReset + lBranco + fVerde);
		String senha = scannerLogin.nextLine();
		
		System.out.println(flReset);
		
		// Validação de login
		if (credenciais.containsKey(cpf) && credenciais.get(cpf).compareTo(senha) == 0) {
			System.out.println("Login efetuado com sucesso!");

			if (validacao_conta.containsKey(cpf)) { // verifica se esse CPF está atrelado a uma conta
				if (validacao_funcionario.containsKey(cpf)) { // e se também está atrelado a um funcionário
					menuCliente(validacao_conta.get(cpf), validacao_conta, validacao_funcionario.get(cpf));
				} else {
					menuCliente(validacao_conta.get(cpf), validacao_conta, null);
				}

			} else {
				switch (validacao_funcionario.get(cpf).getCargo()) { // caso só estiver atrelado a um funcionário

				case "Presidente":
					relatoriosFuncionarios(null, validacao_funcionario.get(cpf));
					break;
				case "Diretor":
					relatoriosFuncionarios(null, validacao_funcionario.get(cpf));
					break;
				case "Gerente":
					relatoriosFuncionarios(null, validacao_funcionario.get(cpf));
					break;

				}
			}

		} else {
			System.out.println(fVermelho + lBranco + "Erro! CPF e/ou SENHA incorretos!" + flReset);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
			menuInicial(contas, funcionarios, credenciais, validacao_conta, validacao_funcionario);
			
		}
	}


	public void menuCliente(Conta c, Map<String, Conta> validacao_conta, Funcionario f) {
		
		String cargo;
		String nome;

		if (f != null) {
			cargo = f.getCargo();
			nome = f.getNome();
		} else {
			cargo = "Cliente";
			nome = c.getNome();
		}

		System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ MENU ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println("    Seja bem-vindo(a), " + cargo + " " + nome + "     ");
		System.out.println("╔═══════════════════════════════════════════╗");
		System.out.println("║ 1  -	Movimentações na conta		    ║");
		System.out.println("║ 2  - 	Relatórios			    ║");
		System.out.println("║ 3  - 	Contratar Seguro de Vida	    ║");
		System.out.println("║ 4  -	Voltar ao login			    ║");
		System.out.println("║ 5  -	Encerrar o programa		    ║");
		System.out.println("╚═══════════════════════════════════════════╝");
		System.out.print("\n\nDigite a opção desejada: ");
		int opcaoConta = scanner.nextInt();

		switch (opcaoConta) {
		case 1:
			movimentacoes(c, validacao_conta, f);
			break;
		case 2:
			if (f == null) {
				relatoriosClientes(c);
			} else {
				relatoriosFuncionarios(c, f);
			}
			break;
		case 3:
			seguroDeVida(c, validacao_conta, f);
			break;
		case 4:
			menuInicial(MenuInicial.getContas(), MenuInicial.getFuncionarios(), MenuInicial.getCredenciais(),
					MenuInicial.getValidacao_conta(), MenuInicial.getValidacao_funcionario());
			break;
		case 5:
			System.out.println("Aplicação encerrada.");
			
			// Geração de .txt
			try {
				Gravacao.pessoas(getContas(), getFuncionarios());
			} catch (IOException e) {
				System.out.println("Houve um erro ao gravar o arquivo.");
			}
			
			try {
				Gravacao.movimentacoes(getContas());
			} catch (IOException e) {
				System.out.println("Houve um erro ao gravar o arquivo.");
			}
			
			try {
				Gravacao.seguro(SeguroVida.getListaContratos());
			} catch (IOException e) {
				System.out.println("Houve um erro ao gravar o arquivo.");
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
				if (c.getSaldo() >= valorSaque && valorSaque >=2) {
					c.sacar(valorSaque);
					System.out.println("Pressione ENTER para continuar.");
					scannerMov.nextLine();
				}else if(valorSaque <2){
					System.out.println("Voce não pode sacar um valor menor que R$ 2.00");
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
			System.out.println("\n|********************* EXTRATO ******************|\n");
			c.extrato();
			System.out.println("\n|================================================|\n");
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
	
	public void relatoriosClientes(Conta c) {
		
		Scanner scannerRel = new Scanner(System.in);

		System.out.println("\n|*********************** RELATÓRIOS ********************|");
		System.out.println("|=======================================================|");
		System.out.println("| 1 -	Saldo						|");
		System.out.println("| 2  - 	Relatório de tributações			|");
		System.out.println("| 3  -	Relatório de rendimentos			|");
		System.out.println("| 4  -	Voltar						|");
		System.out.println("|=======================================================|");
		System.out.print("\n\nDigite a opção desejada: ");
		
		int opcaoRelatorio = scanner.nextInt();
		
		switch (opcaoRelatorio) {
		case 1:
			System.out.println("Seu saldo é de: " + NumberFormat.getCurrencyInstance().format(c.getSaldo()) + "\n");
			System.out.println("Pressione ENTER para continuar.");
			scannerRel.nextLine();
			relatoriosClientes(c);
			break;
		case 2:
			if (c instanceof ContaCorrente) {
				double totalT = ((ContaCorrente) c).getTributacaoSaque() + ((ContaCorrente) c).getTributacaoDeposito()
						+ ((ContaCorrente) c).getTributacaoTransferencia();

				System.out.println("\n|*********************** TRIBUTAÇÕES *******************|");
				System.out.println("|========================================================");
				System.out.println("|	Tributação de saques: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoSaque()) + "			|");
				System.out.println("|	Tributação de depósitos: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoDeposito()) + "			|");
				System.out.println("|	Tributação de transferencias: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoTransferencia()) + "		|");
				if (SeguroVida.getListaContratos().containsKey(c.getCpf())) {
					System.out.println("|	Tributação de seguro de vida: " + NumberFormat.getCurrencyInstance().format(SeguroVida.getListaContratos().get(c.getCpf())) + "		|");	
					System.out.println("|	Total de tributação: " + NumberFormat.getCurrencyInstance().format(totalT + SeguroVida.getListaContratos().get(c.getCpf())) + "			|");
					System.out.println("|========================================================\n\n");
				} else {
					System.out.println("|	Total de tributação: " + NumberFormat.getCurrencyInstance().format(totalT) + "			|");
					System.out.println("|========================================================\n\n");
				}
				
				try {
					Gravacao.tributacoes(c);
				} catch (IOException e) {
					System.out.println("Houve um erro ao gerar o arquivo.");
				}
				
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
			} else {
				System.out.println("Você não possui acesso a essa função.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				
			}
			relatoriosClientes(c);
			break;
		case 3:
			if (c instanceof ContaPoupanca) {
				System.out.println("Digite a quantidade de dias da aplicação:");
				int dias = scanner.nextInt();
				System.out.println("Digite o valor a ser aplicado:");
				double valor = scanner.nextDouble();
				double rendimento = valor * (dias / 30) * 0.01;
				System.out.println("O rendimento será de: " + NumberFormat.getCurrencyInstance().format(rendimento));
				
				try {
					Gravacao.rendimentos(dias, valor, rendimento, c);
				} catch (IOException e) {
					System.out.println("Houve um erro ao gerar o arquivo.");
				}
				
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				relatoriosClientes(c);
				break;
			} else {
				System.out.println("Você não possui acesso a essa função.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				relatoriosClientes(c);
			}
			break;
		case 4:
			menuCliente(c, getValidacao_conta(), null);
			break;
		default:
			System.out.println("Opção inválida. Digite novamente:");
			relatoriosClientes(c);
			break;
		}
	
	}

	public void relatoriosFuncionarios(Conta c, Funcionario f) {
		
		Scanner scannerRel = new Scanner(System.in);
		String cargo;
		String nome;

		System.out.println("\n|*********************** RELATÓRIOS ********************|");
		if (f != null && c == null) {
			cargo = f.getCargo();
			nome = f.getNome();
			System.out.println("    	  Seja bem-vindo(a), " + cargo + " " + nome + "     ");
		}
		System.out.println("|=======================================================|");
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
				relatoriosFuncionarios(c, null);
			} else if (c != null && f != null) {
				System.out.println("Seu saldo é de: " + NumberFormat.getCurrencyInstance().format(c.getSaldo()) + "\n");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				relatoriosFuncionarios(c, f);
			} else {
				System.out.println("Você não possui conta cadastrada em seu CPF.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				relatoriosFuncionarios(null, f);
			}
			break;
		case 2:
			if (c instanceof ContaCorrente) {
				double totalT = ((ContaCorrente) c).getTributacaoSaque() + ((ContaCorrente) c).getTributacaoDeposito()
						+ ((ContaCorrente) c).getTributacaoTransferencia();

				System.out.println("\n|*********************** TRIBUTAÇÕES *******************|");
				System.out.println("|========================================================");
				System.out.println("|	Tributação de saques: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoSaque()) + "			|");
				System.out.println("|	Tributação de depósitos: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoDeposito()) + "			|");
				System.out.println("|	Tributação de transferencias: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoTransferencia()) + "		|");
				if (SeguroVida.getListaContratos().containsKey(c.getCpf())) {
					System.out.println("|	Tributação de seguro de vida: " + NumberFormat.getCurrencyInstance().format(SeguroVida.getListaContratos().get(c.getCpf())) + "		|");	
					System.out.println("|	Total de tributação: " + NumberFormat.getCurrencyInstance().format(SeguroVida.getListaContratos().get(c.getCpf())) + "			|");
					System.out.println("|========================================================\n\n");
				} else {
					System.out.println("|	Total de tributação: " + NumberFormat.getCurrencyInstance().format(totalT) + "			|");
					System.out.println("|========================================================\n\n");
				}
				
				try {
					Gravacao.tributacoes(c);
				} catch (IOException e) {
					System.out.println("Houve um erro ao gerar o arquivo.");
				}
				
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
				
				try {
					Gravacao.rendimentos(dias, valor, rendimento, c);
				} catch (IOException e) {
					System.out.println("Houve um erro ao gerar o arquivo.");
				}
				
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
			} else {
				System.out.println("Você não possui acesso a essa função.");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				retornoRelatorio(c, f);
			}
			break;

		case 4:
			if (f instanceof Gerente || f instanceof Presidente || f instanceof Diretor) {
				System.out.println ("\nO total de contas na sua agência é: " + ((Gerente) f).totalContas(getContas()) + "\n");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				try {
					Gravacao.contasDaAgencia (getContas(), f);
				} catch (IOException e) {
					System.out.println("Houve um erro ao gerar o arquivo.");
				}
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
				
				
				try {
					Gravacao.totalInfo(getContas());
				} catch (IOException e) {
					System.out.println("Houve um erro ao gerar o arquivo.");
				}
				
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
				System.out.println("\nO total do capital é: " + ((Presidente) f).totalCapital(getContas()) + "\n");
				System.out.println("Pressione ENTER para continuar.");
				scannerRel.nextLine();
				try {
					Gravacao.relTotalCapital (getContas(), f);
				} catch (IOException e) {
					System.out.println("Houve um erro ao gerar o arquivo.");
				}
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
	
	public void seguroDeVida(Conta c, Map<String, Conta> validacao_conta, Funcionario f) {
		
		Scanner scanSeguro = new Scanner(System.in);

		if(c instanceof ContaCorrente) {
				System.out.println("\n|************ SEGURO DE VIDA ************|");
				System.out.println("Você deseja contratar o Seguro de Vida?\n");
				System.out.println("20% do valor total será cobrado de tributo\n"
								 + " no momento da confirmação.\n");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				
				System.out.println("\nDigite uma opção: ");
				int opcaoSeguro = scanSeguro.nextInt();
				scanSeguro.nextLine();
				
				switch (opcaoSeguro) {
				case 1:
						if (SeguroVida.getListaContratos().containsKey(c.getCpf())) {
							System.out.println("\nVocê já possui Seguro de Vida!\n");
							System.out.println("Pressione ENTER para continuar.");
							scanSeguro.nextLine();
							menuCliente(c, validacao_conta, f);
						} else {
							System.out.println("Qual valor deseja ser segurado?");
							taxaSeguro = scanSeguro.nextDouble();
							taxaSeguro = taxaSeguro * 0.20;
							
							if(c.getSaldo() >= taxaSeguro) {
								c.setSaldo(c.getSaldo() - taxaSeguro);
								System.out.println("\nSeguro de vida contratado com sucesso!");
								SeguroVida.getListaContratos().put(c.getCpf(), taxaSeguro);
								System.out.println("Pressione ENTER para continuar.");
								scanSeguro.nextLine();
								scanSeguro.nextLine();
								menuCliente(c, validacao_conta, f);
							} else {
								System.out.println("\nSaldo insuficiente!");
								System.out.println("Pressione ENTER para continuar.");
								scanSeguro.nextLine();
								scanSeguro.nextLine();
								menuCliente(c, validacao_conta, f);
							}
						}
					break;
				case 2:
					menuCliente(c, validacao_conta, f);
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
					seguroDeVida(c, validacao_conta, f);
					break;
				}
		} else {
			System.out.println("Serviço indisponível para seu tipo de conta!");
			menuCliente(c, validacao_conta, f);
		}
	}

	public void retornoRelatorio(Conta c, Funcionario f) {


		if (c != null && f == null) {
			relatoriosFuncionarios(c, null);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
		} else if (c != null && f != null) {
			relatoriosFuncionarios(c, f);
			System.out.println("Pressione ENTER para continuar.");
			scanner.nextLine();
		} else {
			relatoriosFuncionarios(null, f);
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

	public static void setTaxaSeguro(double taxaSeguro) {
		MenuInicial.taxaSeguro = taxaSeguro;
	}		
}
