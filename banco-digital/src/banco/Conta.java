package banco;

import java.util.InputMismatchException;

public abstract class Conta implements IConta{

	//atributos
	protected static final int AGENCIA_PADRAO = 1;
	protected static int SEQUENCIAL = 1;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	//construtor
	//define uma agencia padrão como uma constante e cria uma variável 
	//sequencial para toda conta ter um número diferente sequencial
	//começando no 1
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
//	private void sacarOperacao(double valor) {
//		saldo -= valor;
//	}
	
	//saca determinado valor da conta
	//métodos
	@Override
	public void sacar(double valor) {
		if(saldo < valor) {
			throw new InputMismatchException("(você tentou sacar " + valor + "R$ - Saldo Insuficiente!)\n");
		}
		else if(valor < 1000) { 
			saldo -= valor;
			System.out.println("(Você sacou: " + valor + "R$)\n");
		}
		//operações para tarifa de 4,5% do valor se saque for maior que 1000
		else if(valor >= 1000) {
			saldo -= 0.045 * valor;
			System.out.println("(Você sacou: " + valor + 
			"R$ - Tarifa por saque acima de mil reais: " + (0.045 * valor) + "R$)\n");	
		}
	}
	

	//deposita determinado valor da conta
	@Override
	public void depositar(double valor) {
		if(valor < 1000) {
			saldo += valor;
			//System.out.println("(Você depositou: " + valor + "R$)\n");
		}
		//operações para tarifa de 4,5% do valor se depósito for maior que 1000
		else if(valor >= 1000) {
			saldo += valor;
			saldo -= (0.045 * valor);
			System.out.println("(Você depositou: " + valor + 
			"R$ - Tarifa por depósito acima de mil reais: " + (0.045 * valor) + "R$)\n");
		}
	}

	//transfere valor de uma conta para outra
	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(saldo < valor) {
			throw new InputMismatchException("(você tentou transferir " + valor + "R$ - Saldo Insuficiente!)\n");
		}
		else if(valor < 1000) {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("(Você transferiu: " + valor + "R$)\n");
		}
		//operações para tarifa de 4,5% do valor se transferência for igual ou maior que 1000
		else if(valor >= 1000) {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("(Você transferiu: " + valor + 
			"R$ - Tarifa por transferência acima de mil reais: " + (0.045 * valor) + "R$)\n");
		}
	}

	//imprime informações comuns da conta
	protected void imprimirInfosComuns() {
	System.out.println(String.format("Titular: %s", this.cliente.getNome()));		
	System.out.println(String.format("Agencia: %d", this.agencia));	
	System.out.println(String.format("Número: %d", this.numero));	
	System.out.println(String.format("Saldo: %.2f", this.saldo));	
	System.out.println(String.format("Titular: %s", this.cliente.getNome()));		
	
	}

	//getters
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

}
