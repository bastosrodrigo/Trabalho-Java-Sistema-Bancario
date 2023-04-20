package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import pessoas.Funcionario;

public class Gravacao {
	
	
	public static void teste() throws IOException {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\" + data + ".txt", true));
		buffWrite.append("teste");
	}
	
	public static void movimentacoes(String movimentacao) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\log.txt", true));
		buffWrite.append(movimentacao + "\n");
		buffWrite.close();
	}
	
	public static void pessoas(List<Conta> contas, List<Funcionario> funcionarios) throws IOException{
		BufferedWriter limpa = new BufferedWriter(new FileWriter(".\\src\\arquivos\\pessoas.txt"));
		
		limpa.append("TIPO;NOME;SENHA;CPF;AGENCIA;SALDO\n");
		
		limpa.close();
		
		for (int i = 0; i < contas.size(); i++) {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\pessoas.txt", true));
			
			if (contas.get(i) instanceof ContaCorrente) {
				buffWrite.append(((ContaCorrente) contas.get(i)).reescreveContaCorrente() + "\n");
			} else {
				buffWrite.append(((ContaPoupanca) contas.get(i)).reescreveContaPoupanca() + "\n");
			}
			buffWrite.close();
		}
		
		for (int i = 0; i < funcionarios.size(); i++) {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\pessoas.txt", true));
			
			buffWrite.append(funcionarios.get(i).reescreveFuncionario() + "\n");
			buffWrite.close();
		}
	}
}
