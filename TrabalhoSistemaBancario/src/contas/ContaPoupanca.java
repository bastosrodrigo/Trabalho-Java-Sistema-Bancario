package contas;

public class ContaPoupanca extends Conta{

	private String tipo = "Conta Poupança";
	
	public ContaPoupanca() {
		
	}
	public ContaPoupanca(String nome, String senha, String cpf, int agencia, double saldo) {
		super(nome,senha,cpf,agencia,saldo);
	}
	public String reescreveContaPoupanca() {
		return tipo + ";" + getNome() + ";" + getSenha() + ";" + getCpf() + ";" + getAgencia() + ";" + getSaldo();
	}
}
