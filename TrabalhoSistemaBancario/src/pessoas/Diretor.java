package pessoas;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import contas.Conta;

public class Diretor extends Funcionario {

	public Diretor() {
		
	}
	
	public Diretor(String nome, String cpf, int senha, String cargo) {
		super(nome, cpf, senha, cargo);
	}
	
	public void totalInfo(List<Conta> contas) {
		Collections.sort(contas);
		for(int i=0; i < contas.size(); i++) {
			System.out.println(contas.get(i));
		}
	}
}
