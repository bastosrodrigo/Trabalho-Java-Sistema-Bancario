package pessoas;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import contas.Conta;

public class Diretor extends Gerente {

	public Diretor() {
		
	}
	
	public Diretor(String cargo, String nome, String senha, String cpf, int agencia) {
		super(cargo, nome, senha, cpf, agencia);
	}
	
	public void totalInfo(List<Conta> contas) {
		Collections.sort(contas);
		for(int i=0; i < contas.size(); i++) {
			System.out.println(contas.get(i).getNome() + " " + contas.get(i).getCpf() + " " + contas.get(i).getAgencia());
		}
	}
}
