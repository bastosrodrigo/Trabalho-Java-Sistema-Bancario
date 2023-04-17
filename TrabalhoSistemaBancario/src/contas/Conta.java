package contas;

import java.util.ArrayList;
import java.util.List;

import pessoas.Cliente;

public abstract class Conta extends Cliente{

	private static int id = 1;
	private double saldo;
	private int agencia;
	private double tributacaoSaque;
	private double tributacaoDeposito;
	private double tributacaoTransferencia;
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
	public double getTributacaoSaque() {
		return tributacaoSaque;
	}
	public void setTributacaoSaque(double tributacaoSaque) {
		this.tributacaoSaque = tributacaoSaque;
	}
	public double getTributacaoDeposito() {
		return tributacaoDeposito;
	}
	public void setTributacaoDeposito(double tributacaoDeposito) {
		this.tributacaoDeposito = tributacaoDeposito;
	}
	public double getTributacaoTransferencia() {
		return tributacaoTransferencia;
	}
	public void setTributacaoTransferencia(double tributacaoTransferencia) {
		this.tributacaoTransferencia = tributacaoTransferencia;
	}
	
	
}
