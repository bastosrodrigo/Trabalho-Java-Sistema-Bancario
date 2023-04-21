package pessoas;

import java.text.NumberFormat;
import java.util.List;

import contas.Conta;

public class Gerente extends Funcionario {

	public Gerente() {

	}

	public Gerente(String cargo, String nome, String senha, String cpf, int agencia) {
		super(cargo, nome, senha, cpf);
		setAgencia(agencia);
	}

	public int totalContas(List<Conta> contas) {
		int numeroContas = 0;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getAgencia() == getAgencia()) {
				numeroContas++;
			}
		}
		return numeroContas;
	}
}
