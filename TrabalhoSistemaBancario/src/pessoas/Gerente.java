package pessoas;

import java.util.List;

import contas.Conta;

public class Gerente extends Funcionario {

	private int agencia;

	public Gerente() {

	}

	public Gerente(String cargo, String nome, String senha, String cpf, int agencia) {
		super(cargo, nome, senha, cpf);
		this.agencia = agencia;
	}

	public void totalContas(List<Conta> contas) {
		int numeroContas = 0;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getAgencia() == this.agencia) {
				numeroContas++;
			}
		}
		System.out.println("O total de contas na sua agência é: " + numeroContas);
	}
}
