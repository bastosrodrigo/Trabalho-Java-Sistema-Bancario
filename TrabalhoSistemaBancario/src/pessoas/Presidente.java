package pessoas;

import java.text.NumberFormat;
import java.util.List;

import contas.Conta;

public class Presidente extends Diretor{

	public Presidente() {
		
	}
	public Presidente(String cargo, String nome, String senha, String cpf, int agencia) {
		super(cargo, nome, senha, cpf, agencia);
	}
	
	public String totalCapital(List<Conta> contas) {
		double totalCapital = 0;
		for (int i = 0; i < contas.size(); i++) {
			totalCapital += contas.get(i).getSaldo();
			
		}
		return NumberFormat.getCurrencyInstance().format(totalCapital);
	}
}