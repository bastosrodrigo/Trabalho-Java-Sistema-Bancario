package io;

import clientes.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitura {

	public static void leitor(String path) throws IOException {

		String carregarArquivo = "C:\\Users\\Rodrigo Bastos\\eclipse-workspace\\TrabalhoSistemaBancario\\src\\arquivos\\logins.txt";
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(carregarArquivo))) {
			
			String linha = br.readLine();
			linha = br.readLine();
			while (linha != null) {
				String[] vetor = linha.split(";");
				String cargo = vetor[0];
				String nome = vetor[1];
				String cpf = vetor[2];
				int senha =  Integer.parseInt(vetor[3]);
				
				Cliente cliente = new Cliente(cargo, nome, cpf, senha);
				lista.add(cliente);
				
				linha = br.readLine();
			}
			for (Cliente cliente : lista) {
				System.out.println(cliente);
			}
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
