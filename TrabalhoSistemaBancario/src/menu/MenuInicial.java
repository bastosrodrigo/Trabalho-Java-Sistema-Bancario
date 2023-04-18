package menu;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import contas.Conta;
import pessoas.Funcionario;

public class MenuInicial {

	public void menuInicial(List<Conta> contas, List<Funcionario> funcionarios, Map<String, Integer> credenciais,
			Map<String, Conta> validacao_conta, Map<String, Funcionario> validacao_funcionario) {
		Scanner scanner = new Scanner(System.in);

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
		System.out.println("|*********************** MENU CONTA ********************|");
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
			//movimentacoes();
			break;
		case 2:
			//relatorios();
			break;
		case 3:
			
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
}
