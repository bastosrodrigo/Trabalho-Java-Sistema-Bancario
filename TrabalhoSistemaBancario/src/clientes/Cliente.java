package clientes;

public class Cliente {
	
	private String cargo;
	private String nome;
	private String cpf;
	private int senha;
	
	
	public Cliente() {
		
	}


	public Cliente(String cargo, String nome, String cpf, int senha) {
		super();
		this.cargo = cargo;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
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
		return "Cliente [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
	}
	
	
}
