package contas;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import io.Gravacao;
import pessoas.Cliente;

public abstract class Conta extends Cliente implements Operacoes, Comparable<Conta>{

	private static int id;
	private int id_conta;
	private double saldo;
	private int agencia;
	private List<String> movimentacoes = new ArrayList<>();

	public Conta() {

	}

	public Conta(String nome, String senha, String cpf, int agencia, double saldo) {
		id++;
		id_conta = id;
		this.setNome(nome);
		this.setSenha(senha);
		this.setCpf(cpf);
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public List<String> getMovimentacoes() {
		return movimentacoes;
	}

	public int getId() {
		return id_conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	// Método de saque
	public void sacar(double valor) {
		
		if (this.getSaldo() >= valor && valor > 0) {
			this.saldo -= valor;
			System.out.println("\n" + NumberFormat.getCurrencyInstance().format(valor) + " foram sacados de sua conta com sucesso!");
				if (this instanceof ContaCorrente) {
				((ContaCorrente) this).setTributacaoSaque();
				movimentacoes.add("Saque de: " + NumberFormat.getCurrencyInstance().format(valor) + " (Com tributação: " + NumberFormat.getCurrencyInstance().format((valor + 0.10)) + ")" );
				 
				}else {
					movimentacoes.add("Saque de: " + NumberFormat.getCurrencyInstance().format(valor));
				}
		} else if (valor < 0) {
			System.out.println("Impossível sacar tal valor!");
		} else {
			System.out.println("Saldo insuficiente");
		}
		
		

	}
	
	// Método de depósito
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("\n" + NumberFormat.getCurrencyInstance().format(valor) + " foi adicionado ao seu saldo!");
			if (this instanceof ContaCorrente) {
				((ContaCorrente) this).setTributacaoDeposito();
				movimentacoes.add("Deposito de: " + NumberFormat.getCurrencyInstance().format(valor) + " (Com tributação: " + NumberFormat.getCurrencyInstance().format((valor - 0.10)) + ")");
			}else {
				movimentacoes.add("Deposito de: " + NumberFormat.getCurrencyInstance().format(valor));
			}
		} else {
			System.out.println("Impossível depositar tal valor!");
		}

	}
	
	// Método de transferência
	public void transferir (double valor, Conta c) {
		if (this.getSaldo() >= valor && valor > 0 && this.getCpf() != c.getCpf()) {
		this.saldo -= valor;
		c.setSaldo(c.getSaldo() + valor);
		
			System.out.println("\n" + NumberFormat.getCurrencyInstance().format(valor) + " foram transferidos de sua conta com sucesso!");
			if (this instanceof ContaCorrente) {
				((ContaCorrente) this).setTributacaoTransferencia();
				movimentacoes.add("Transferencia de: " + NumberFormat.getCurrencyInstance().format(valor) + " para: " + c.getCpf() + " (Com tributação: " + NumberFormat.getCurrencyInstance().format((valor + 0.20))+ ")");
			}else {
				movimentacoes.add("Transferencia de: " + NumberFormat.getCurrencyInstance().format(valor) + " para: " + c.getCpf());
			}
			
		} else if (valor < 0 || this.getCpf() == c.getCpf()) {
			System.out.println("Impossível realizar tal transferência!");
		} else {
			System.out.println("Saldo insuficiente");
		}	
	}

	// Gera extrato (no terminal e .txt)
	public void extrato() {
		if(movimentacoes.size() != 0) {
			for(int i =0; i < movimentacoes.size(); i++) {
				System.out.println(movimentacoes.get(i));
			}
			
		}else {
			System.out.println("Ainda não foram feitas movimentações nesta conta.");
			
		}
		
		try {
			Gravacao.extrato(this.movimentacoes, this);
		} catch (IOException e) {
			System.out.println("Houve um erro ao gravar o arquivo.");
		}
	}
	
	// Coloca as contas em ordem alfabética
	public int compareTo(Conta c) {
		if (this.getNome().compareTo(c.getNome()) < 1) {
			return -1;
		}
		if (this.getNome().compareTo(c.getNome()) > 1) {
			return 1;
		}
		return 0;
	}
}