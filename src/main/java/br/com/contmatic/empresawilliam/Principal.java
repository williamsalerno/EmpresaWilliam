package br.com.contmatic.empresawilliam;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		Endereco e1 = new Endereco();
		e1.setTipoLogradouro("Rua");
		e1.setNomeLogradouro("Exemplo");
		e1.setNumeroEndereco(10);
		e1.setCep("12345678");
		
		List <Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(e1);
		
		
		Empresa empresa1 = new Empresa();

	}

}
