package io;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Leitura {

	public static void leitor(String path, List<Conta> contas, List<Funcionario> funcionarios, Map<String, Integer> credenciais, Map<String, Conta> validacao_conta, Map<String, Funcionario> validacao_funcionario) throws IOException {

		try {
			BufferedReader leitor = new BufferedReader(new FileReader(path));
			
			String linha = leitor.readLine();
			
				while ((linha = leitor.readLine()) != null) {
					String[] valores = linha.split(";");
					String cargo = valores[0];
					String nome = valores[1];
					int senha = Integer.parseInt(valores[2]);
					String cpf = valores[3];
					
					switch (cargo) {
						case "Conta Poupança":
							ContaPoupanca cp = new ContaPoupanca(nome, senha, cpf, Integer.parseInt(valores[4]), Double.parseDouble(valores[5]));
							contas.add(cp);
							credenciais.put(cpf, senha);
							validacao_conta.put(cpf, cp);
							break;
						case "Conta Corrente":
							ContaCorrente cc = new ContaCorrente(nome, senha, cpf, Integer.parseInt(valores[4]), Double.parseDouble(valores[5]));
							contas.add(cc);
							credenciais.put(cpf, senha);
							validacao_conta.put(cpf, cc);
							break;
						case "Gerente":
							Gerente gerente = new Gerente(cargo, nome, senha, cpf, Integer.parseInt(valores[4]));
							funcionarios.add(gerente);
							credenciais.put(cpf, senha);
							validacao_funcionario.put(cpf, gerente);
							break;
						case "Diretor":
							Diretor diretor = new Diretor(nome, cpf, senha, cargo);
							funcionarios.add(diretor);
							credenciais.put(cpf, senha);
							validacao_funcionario.put(cpf, diretor);
							break;
						case "Presidente":
							Presidente presidente = new Presidente(cargo, nome, senha, cpf);
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
}
