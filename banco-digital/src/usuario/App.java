package usuario;

import banco.Cliente;
import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;

public class App {
	
	public static void main(String[] args) {
		Cliente matheus = new Cliente();
		matheus.setNome("Matheus");
		
		Conta corrente = new ContaCorrente(matheus);
		corrente.depositar(2094.24);
		
		
		Conta poupanca = new ContaPoupanca(matheus);
		//poupanca.depositar(50);
		
		corrente.transferir(1000, poupanca);
		
		corrente.imprimirExtrato();
		poupanca.imprimirExtrato();
	}
}
