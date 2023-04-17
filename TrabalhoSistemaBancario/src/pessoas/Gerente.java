package pessoas;

public class Gerente extends Funcionario{
	
	private int agencia;
	
	public Gerente() {
		
	}
	public Gerente(String cargo, String nome, int senha, String cpf, int agencia) {
		super(cargo,nome,senha,cpf);
		this.agencia = agencia;
	}
}
