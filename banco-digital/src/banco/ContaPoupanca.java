package banco;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	//imprime extrato da conta poupan�a
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Poupan�a ===");
		super.imprimirInfosComuns();
	}
}
