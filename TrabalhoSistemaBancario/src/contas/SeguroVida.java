package contas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SeguroVida {

	private static Map<String, Double> listaContratos = new HashMap<>();

	
	public SeguroVida() {
		
	}

	public static Map<String, Double> getListaContratos() {
		return listaContratos;
	}
}
