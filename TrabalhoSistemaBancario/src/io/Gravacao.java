package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import pessoas.Funcionario;

public class Gravacao {
	
	
	public static void teste() throws IOException {
		
		LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String dataFormatada = data.format(formatar);
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\" + dataFormatada + ".txt", true));
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
	
	public static void extrato(List<String> extrato, Conta c) throws IOException {
		LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String dataFormatada = data.format(formatar);
        for (int i = 0; i < extrato.size(); i++) {
        	BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\" + "Extrato_" + c.getId() + "_" + dataFormatada + ".txt", true));
    		buffWrite.append(extrato.get(i) + "\n");
    		buffWrite.close();
        }
	}
}
