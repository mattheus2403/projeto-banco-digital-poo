package banco;

import java.util.List;

public class Banco {

	//atributo
	private String nome;
	private List<Conta> clientes;

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getClientes() {
		return clientes;
	}

	public void setClientes(List<Conta> clientes) {
		this.clientes = clientes;
	}
		
}
