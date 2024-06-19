package usuario;

import banco.Cliente;
import banco.Conta;
import banco.ContaCorrente;

public class App {
	
	public static void main(String[] args) {
		Cliente matheus = new Cliente();
		matheus.setNome("Matheus");
		
		Conta corrente = new ContaCorrente(matheus);
		corrente.depositar(50);
		
		Conta poupanca = new ContaCorrente(matheus);
		
		corrente.transferir(50, poupanca);
		
		corrente.imprimirExtrato();
		poupanca.imprimirExtrato();
	}
}
