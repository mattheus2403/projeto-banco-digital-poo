package banco;

public class ContaPoupanca extends Conta{

	//construtor para clientes
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	//imprime extrato da conta poupança
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Poupança ===");
		super.imprimirInfosComuns();
	}
}
