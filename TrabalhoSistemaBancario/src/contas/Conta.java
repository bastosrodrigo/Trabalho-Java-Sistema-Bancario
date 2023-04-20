package contas;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import pessoas.Cliente;

public abstract class Conta extends Cliente implements Operacoes, Comparable<Conta>{

	private static int id = 1;
	private double saldo;
	private int agencia;
	private List<String> movimentacoes = new ArrayList<>();

	public Conta() {

	}

	public Conta(String nome, String senha, String cpf, int agencia, double saldo) {
		id++;
		this.setNome(nome);
		this.setSenha(senha);
		this.setCpf(cpf);
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public double getId() {
		return id;
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

	public void sacar(double valor) {
		
		if (valor > 0 && this.getSaldo() >= valor) {
			this.saldo -= valor;
			System.out.println("\n" + NumberFormat.getCurrencyInstance().format(valor) + " foram sacados de sua conta com sucesso!");
				if (this instanceof ContaCorrente) {
				((ContaCorrente) this).setTributacaoSaque();
				movimentacoes.add("Saque de: " + NumberFormat.getCurrencyInstance().format(valor) + "\nCom tributação: " + NumberFormat.getCurrencyInstance().format((valor + 0.10)) );
				 
				}else {
					movimentacoes.add("Saque de: " + NumberFormat.getCurrencyInstance().format(valor));
				}
		} else {
			System.out.println("Saldo insuficiente");
		}
		
		

	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("\n" + NumberFormat.getCurrencyInstance().format(valor) + " foi adicionado ao seu saldo!");
			if (this instanceof ContaCorrente) {
				((ContaCorrente) this).setTributacaoDeposito();
				movimentacoes.add("Deposito de: " + NumberFormat.getCurrencyInstance().format(valor) + "\nCom tributação: " + NumberFormat.getCurrencyInstance().format((valor - 0.10)));
			}else {
				movimentacoes.add("Deposito de: " + NumberFormat.getCurrencyInstance().format(valor));
			}
		} else {
			System.out.println("Impossível depositar tal valor!");
		}

	}
	public void transferir (double valor, Conta c) {
		if (valor > 0 && this.getSaldo() >= valor) {
		this.saldo -= valor;
		c.setSaldo(c.getSaldo() + valor);
		
			System.out.println("\n" + NumberFormat.getCurrencyInstance().format(valor) + " foram transferidos de sua conta com sucesso!");
			if (this instanceof ContaCorrente) {
				((ContaCorrente) this).setTributacaoTransferencia();
				movimentacoes.add("Transferencia de: " + NumberFormat.getCurrencyInstance().format(valor) + " para: " + c.getCpf() + "\nCom tributação: " + NumberFormat.getCurrencyInstance().format((valor + 0.20)) );
			}else {
				movimentacoes.add("Transferencia de: " + NumberFormat.getCurrencyInstance().format(valor) + " para: " + c.getCpf());
			}
		} else {
			System.out.println("Saldo insuficiente");
		}	
	}
	public void extrato() {
		for(int i =0; i < movimentacoes.size(); i++) {
			System.out.println(movimentacoes.get(i));
		}
	}
	
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