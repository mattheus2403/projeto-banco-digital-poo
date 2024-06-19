package banco;

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
	
	//saca determinado valor da conta
	//m�todos
	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	//deposita determinado valor da conta
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	//transfere valor de uma conta para outra
	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	//imprime informa��es comuns da conta
	protected void imprimirInfosComuns() {
	System.out.println(String.format("Titular: %s", this.cliente.getNome()));		
	System.out.println(String.format("Agencia: %d", this.agencia));	
	System.out.println(String.format("Conta: %d", this.numero));	
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
