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
