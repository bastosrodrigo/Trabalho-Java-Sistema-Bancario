package pessoas;

public abstract class Funcionario {

	private String cargo;
	private String nome;
	private String cpf;
	private String senha;
	private int agencia;
	
	public Funcionario () {
		
	}
	
	public Funcionario (String cargo, String nome, String senha, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getAgencia() {
		return agencia;
	}
	public String reescreveFuncionario() {
		return getCargo() + ";" + getNome() +  ";" + getSenha() +  ";" + getCpf() +  ";" + getAgencia();
	}
	
}
