package contas;

import java.util.ArrayList;
import java.util.List;

public abstract class SeguroVida {

	private static List<String> listaContratos = new ArrayList<>();
	
	public SeguroVida() {
		
	}

	public static List<String> getListaContratos() {
		return listaContratos;
	}
}
