package contas;

public class ContaCorrente extends Conta {

	private String tipo = "Conta Corrente";
	
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String nome, int senha, String cpf, int agencia, double saldo) {
		super(nome,senha,cpf,agencia,saldo);
	}
}
