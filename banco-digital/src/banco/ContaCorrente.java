package banco;

public class ContaCorrente extends Conta{
	
	//construtor para clientes
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	//imprime extrato da conta corrente
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Corrente ===");
		super.imprimirInfosComuns();
	}
}
