package pessoas;

public abstract class Funcionario {

	private String cargo;
	private String nome;
	private String cpf;
	private int senha;
	
	public Funcionario () {
		
	}
	
	public Funcionario (String cargo, String nome, int senha, String cpf) {
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
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
	}
	
}
