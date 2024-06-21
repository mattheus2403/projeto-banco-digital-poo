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
	//define uma agencia padr�o como uma constante e cria uma vari�vel 
	//sequencial para toda conta ter um n�mero diferente sequencial
	//come�ando no 1
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
//	private void sacarOperacao(double valor) {
//		saldo -= valor;
//	}
	
	//saca determinado valor da conta
	//m�todos
	@Override
	public void sacar(double valor) {
		if(saldo < valor) {
			throw new InputMismatchException("(voc� tentou sacar " + valor + "R$ - Saldo Insuficiente!)\n");
		}
		else if(valor < 1000) { 
			saldo -= valor;
			System.out.println("(Voc� sacou: " + valor + "R$)\n");
		}
		//opera��es para tarifa de 4,5% do valor se saque for maior que 1000
		else if(valor >= 1000) {
			saldo -= 0.045 * valor;
			System.out.println("(Voc� sacou: " + valor + 
			"R$ - Tarifa por saque acima de mil reais: " + (0.045 * valor) + "R$)\n");	
		}
	}
	

	//deposita determinado valor da conta
	@Override
	public void depositar(double valor) {
		if(valor < 1000) {
			saldo += valor;
			//System.out.println("(Voc� depositou: " + valor + "R$)\n");
		}
		//opera��es para tarifa de 4,5% do valor se dep�sito for maior que 1000
		else if(valor >= 1000) {
			saldo += valor;
			saldo -= (0.045 * valor);
			System.out.println("(Voc� depositou: " + valor + 
			"R$ - Tarifa por dep�sito acima de mil reais: " + (0.045 * valor) + "R$)\n");
		}
	}

	//transfere valor de uma conta para outra
	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(saldo < valor) {
			throw new InputMismatchException("(voc� tentou transferir " + valor + "R$ - Saldo Insuficiente!)\n");
		}
		else if(valor < 1000) {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("(Voc� transferiu: " + valor + "R$)\n");
		}
		//opera��es para tarifa de 4,5% do valor se transfer�ncia for igual ou maior que 1000
		else if(valor >= 1000) {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("(Voc� transferiu: " + valor + 
			"R$ - Tarifa por transfer�ncia acima de mil reais: " + (0.045 * valor) + "R$)\n");
		}
	}

	//imprime informa��es comuns da conta
	protected void imprimirInfosComuns() {
	System.out.println(String.format("Titular: %s", this.cliente.getNome()));		
	System.out.println(String.format("Agencia: %d", this.agencia));	
	System.out.println(String.format("N�mero: %d", this.numero));	
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
