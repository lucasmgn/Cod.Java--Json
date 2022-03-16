package com.curso.exemplo;

import java.util.ArrayList;
import java.util.List;

import com.curso.exemplo.modelo.Cliente;
import com.curso.exemplo.modelo.Endereco;
import com.curso.exemplo.modelo.Telefone;
import com.google.gson.Gson;

public class GerandoJson {

	public static void main(String[] args) {
		Endereco endereco = new Endereco("Rua Jairo Andrade Macedo, 10", "Aracaju", "Sergipe");
		
		Telefone telefoneResidencial = new Telefone("Residencial", "79 9 98464336");
		Telefone telefoneComercial = new Telefone("Comercial", "79 3365-4548");
		List<Telefone> telefones = new ArrayList<>();
		telefones.add(telefoneComercial);
		telefones.add(telefoneResidencial);
		
		Cliente cliente = new Cliente("Lucas Magno Peixoto Lima", 20, endereco, telefones);
		
		Gson gson = new Gson();
		String json = gson.toJson(cliente);
		
		System.out.println(json);
		
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println();
		
		Cliente c2 = gson.fromJson(json, Cliente.class);
		
		System.out.println(c2.getNome());
		System.out.println(c2.getIdade() + " anos");
		System.out.println(c2.getTelefones().get(0).getNumero());
	}

}
