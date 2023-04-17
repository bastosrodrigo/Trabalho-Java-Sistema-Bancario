package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contas.Conta;
import io.Leitura;
import pessoas.Funcionario;

public class SistemaBancario {

	public static void main(String[] args) throws IOException{
		
		List<Conta> contas = new ArrayList<>(); // guarda todas as contas/clientes
		List<Funcionario> funcionarios = new ArrayList<>(); //guarda todos os funcionários
		Map<String, Integer> credenciais = new HashMap<>(); // guarda CPF + senha
		Map<String, Conta> validacao_conta = new HashMap<>(); // relaciona o CPF com a conta
		Map<String, Funcionario> validacao_funcionario = new HashMap<>(); // relaciona o CPF com o funcionário
		
		Leitura.leitor(".\\src\\arquivos\\pessoas.txt", contas, funcionarios, credenciais, validacao_conta, validacao_funcionario);
	
		for(int i =0; i < contas.size(); i++) {
			System.out.println(contas.get(i).toString());
		}

	}

}
