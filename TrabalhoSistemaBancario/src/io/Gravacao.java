package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
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
	
	
	// Salva todas as movimentações realizadas no sistema durante a execução
	public static void movimentacoes(List<Conta> lista_contas) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\movimentacoes.txt"));
		
		buffWrite.append("|*********************** MOVIMENTAÇÕES TOTAIS ********************|\n");
		
		for (int i = 0; i < lista_contas.size(); i++) {
			if(lista_contas.get(i).getMovimentacoes() != null) {
				buffWrite.append("ID: " + lista_contas.get(i).getId() + " " + lista_contas.get(i).getMovimentacoes() + "\n");
			}
		}
		buffWrite.close();
	}
	
	
	// Gera relatório de tributação .txt
	// Nome do arquivo == RelTribut_ID_Data
	public static void tributacoes(Conta c) throws IOException {
		LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String dataFormatada = data.format(formatar);
        double totalT = ((ContaCorrente) c).getTributacaoSaque() + ((ContaCorrente) c).getTributacaoDeposito()
				+ ((ContaCorrente) c).getTributacaoTransferencia();
        
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\" + "RelTribut_" + c.getId() + "_" + dataFormatada + ".txt", true));
	
        buffWrite.append("|********************* RELATÓRIO DE TRIBUTAÇÃO ******************|\n");
        buffWrite.append("Nome: " + c.getNome() + "\n");
        buffWrite.append("CPF: " + c.getCpf() + "\n");
        buffWrite.append("ID da conta: " + c.getId() + "\n");
        buffWrite.append("Agência: " + c.getAgencia() + "\n\n");
        buffWrite.append("Tributação de saques: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoSaque()) + "\n");
        buffWrite.append("Tributação de depósitos: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoDeposito()) + "\n");
        buffWrite.append("Tributação de transferencias: " + NumberFormat.getCurrencyInstance().format(((ContaCorrente) c).getTributacaoTransferencia()) + "\n");
        buffWrite.append("Total de tributação: " + NumberFormat.getCurrencyInstance().format(totalT) + "\n");
        
        buffWrite.close();
	}
	
	// Gera relatório de rendimento .txt
	// Nome do arquivo == RelRend_ID_Data
	public static void rendimentos(int dias, double valor, double rendimento, Conta c) throws IOException {
		LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String dataFormatada = data.format(formatar);
        
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\" + "RelRend_" + c.getId() + "_" + dataFormatada + ".txt", true));
	
        buffWrite.append("|********************* RELATÓRIO DE RENDIMENTO ******************|\n");
        buffWrite.append("Nome: " + c.getNome() + "\n");
        buffWrite.append("CPF: " + c.getCpf() + "\n");
        buffWrite.append("ID da conta: " + c.getId() + "\n");
        buffWrite.append("Agência: " + c.getAgencia() + "\n\n");
        buffWrite.append("Valor a ser aplicado: " + NumberFormat.getCurrencyInstance().format(valor) + "\n");
        buffWrite.append("Quantidade de dias da aplicação: " + dias + "\n");
        buffWrite.append("Rendimento: " + NumberFormat.getCurrencyInstance().format(rendimento) + "\n");
        
        buffWrite.close();
	}
	
	// Gera relatório de informações .txt
	// Nome do arquivo == RelContas_Data
	public static void totalInfo(List<Conta> contas) throws IOException {
		LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String dataFormatada = data.format(formatar);
        
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\" + "RelContas_" + dataFormatada + ".txt", true));
		
        buffWrite.append("|***************** RELATÓRIO DE INFORMAÇÕES **************|\n");
        buffWrite.append("|======================================================|\n");
        buffWrite.append("Nome		CPF					Agência\n");
		
		for(int i=0; i < contas.size(); i++) {
			buffWrite.append(contas.get(i).getNome() + "		" + contas.get(i).getCpf() + "		" + contas.get(i).getAgencia() + "\n");
		}
		buffWrite.append("|======================================================|\n");
		
		buffWrite.close();
	}
	
	// Gera relatório de total de contas da agência .txt
	
	// Gera relatório de capital .txt
	
	
	// Atualiza o pessoas.txt
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
	
	// Gera Extrato em .txt
	// Nome do arquivo == Extrato_IDConta_Data
	public static void extrato(List<String> extrato, Conta c) throws IOException {
		LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String dataFormatada = data.format(formatar);
        
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(".\\src\\arquivos\\" + "Extrato_" + c.getId() + "_" + dataFormatada + ".txt", true));
        buffWrite.append("|********************* EXTRATO ******************|\n");
        buffWrite.append("Nome: " + c.getNome() + "\n");
        buffWrite.append("CPF: " + c.getCpf() + "\n");
        buffWrite.append("ID da conta: " + c.getId() + "\n");
        buffWrite.append("Agência: " + c.getAgencia() + "\n\n");
        
        for (int i = 0; i < extrato.size(); i++) {
    		buffWrite.append(c.getMovimentacoes().get(i) + "\n");
        }
        
        buffWrite.append("\nSaldo total: " + NumberFormat.getCurrencyInstance().format(c.getSaldo()));
    	buffWrite.close();
	}
}
