package banco;

public interface IConta {

	//m�todos que ser�o utilizados na classe Conta
	void sacar(double valor);
	void depositar(double valor);
	void transferir(double valor, Conta contaDestino);
	void imprimirExtrato();
}
