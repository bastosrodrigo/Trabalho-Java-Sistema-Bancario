package contas;

import java.util.ArrayList;
import java.util.List;

import pessoas.Cliente;

public abstract class Conta extends Cliente {

	private static int id = 1;
	private double saldo;
	private int agencia;
	private List<String> movimentacoes = new ArrayList<>();

	public Conta() {

	}

	public Conta(String nome, int senha, String cpf, int agencia, double saldo) {
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
			System.out.println(valor + "foram sacados de sua conta com sucesso!");
		} else {
			System.out.println("Saldo insuficiente");
		}

	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println(valor + "foi adicionado ao seu saldo!");
		} else {
			System.out.println("Impossível depositar tal valor!");
		}

	}
	public void transferir (double valor, Conta c) {
		if (valor > 0 && this.getSaldo() >= valor) {
		this.saldo -= valor;
		c.setSaldo(c.getSaldo() + valor);
		
			System.out.println(valor + "foram transferidos de sua conta com sucesso!");
		} else {
			System.out.println("Saldo insuficiente");
		}
	}
	//implementar método extrato
}