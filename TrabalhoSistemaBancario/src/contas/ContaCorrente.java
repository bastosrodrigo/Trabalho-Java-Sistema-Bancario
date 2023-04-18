package contas;

public class ContaCorrente extends Conta {

	private String tipo = "Conta Corrente";
	
	private double tributacaoSaque;
	private double tributacaoDeposito;
	private double tributacaoTransferencia;
	
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String nome, int senha, String cpf, int agencia, double saldo) {
		super(nome,senha,cpf,agencia,saldo);
	}

	public double getTributacaoSaque() {
		return tributacaoSaque;
	}

	public void setTributacaoSaque() {
		this.tributacaoSaque += 0.10;
		this.setSaldo(getSaldo() - 0.10);
	}

	public double getTributacaoDeposito() {
		return tributacaoDeposito;
	}

	public void setTributacaoDeposito() {
		this.tributacaoDeposito += 0.10;
		this.setSaldo(getSaldo() - 0.10);
	}

	public double getTributacaoTransferencia() {
		return tributacaoTransferencia;
	}

	public void setTributacaoTransferencia() {
		this.tributacaoTransferencia += 0.20;
		this.setSaldo(getSaldo() - 0.20);
	}
	
}
