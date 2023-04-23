package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.SeguroVida;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;

public class Leitura {

	// Faz a leitura dos dados dos objetos
	public static void leitor(String path, List<Conta> contas, List<Funcionario> funcionarios, Map<String, String> credenciais, Map<String, Conta> validacao_conta, Map<String, Funcionario> validacao_funcionario) throws IOException {

		try {
			BufferedReader leitor = new BufferedReader(new FileReader(path));
			
			String linha = leitor.readLine();
			
				while ((linha = leitor.readLine()) != null) {
					String[] valores = linha.split(";");
					String cargo = valores[0];
					String nome = valores[1];
					String senha = valores[2];
					String cpf = valores[3];
					int ag = Integer.parseInt(valores[4]);
					
					switch (cargo) {
						case "Conta Poupança":
							ContaPoupanca cp = new ContaPoupanca(nome, senha, cpf, ag, Double.parseDouble(valores[5]));
							contas.add(cp);
							credenciais.put(cpf, senha);
							validacao_conta.put(cpf, cp);
							break;
						case "Conta Corrente":
							ContaCorrente cc = new ContaCorrente(nome, senha, cpf, ag, Double.parseDouble(valores[5]));
							contas.add(cc);
							credenciais.put(cpf, senha);
							validacao_conta.put(cpf, cc);
							break;
						case "Gerente":
							Gerente gerente = new Gerente(cargo, nome, senha, cpf, ag);
							funcionarios.add(gerente);
							credenciais.put(cpf, senha);
							validacao_funcionario.put(cpf, gerente);
							break;
						case "Diretor":
							Diretor diretor = new Diretor(cargo, nome, senha, cpf, ag);
							funcionarios.add(diretor);
							credenciais.put(cpf, senha);
							validacao_funcionario.put(cpf, diretor);
							break;
						case "Presidente":
							Presidente presidente = new Presidente(cargo, nome, senha, cpf, ag);
							funcionarios.add(presidente);
							credenciais.put(cpf, senha);
							validacao_funcionario.put(cpf, presidente);
							break;
					}
				}
		} catch (IOException IOe) {
			System.out.println("Houve um erro ao ler o arquivo: "+IOe.getCause());
		}
	}
	
	// Faz a leitura do seguro
	public static void leitorSeguro(String path) throws IOException {
		
		BufferedReader leitor = new BufferedReader(new FileReader(path));
		
		String linha = leitor.readLine();
		
		try {
			while ((linha = leitor.readLine()) != null) {
				String[] valores = linha.split(";");
				String cpf = valores[0];
				Double taxa = Double.parseDouble(valores[1]);
				SeguroVida.getListaContratos().put(cpf, taxa);
			}
		} catch (IOException IOe) {
			System.out.println("Houve um erro ao ler o arquivo: "+IOe.getCause());
		}
	}
}
