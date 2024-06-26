public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	private int agencia;
	private int numero;
	private double saldo;
	private String cliente;

	public Conta(String cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.saldo = 0.0; // Inicializa saldo como zero
	}

	@Override
	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente para saque.");
		}
	}

	@Override
	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
		} else {
			System.out.println("Valor de depósito deve ser positivo.");
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (valor > 0 && valor <= saldo) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} else {
			System.out.println("Transferência não realizada: saldo insuficiente.");
		}
	}

	// Getters para os atributos privados
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println("Informações da Conta:");
		System.out.println("Titular: " + cliente);
		System.out.println("Agência: " + agencia);
		System.out.println("Número: " + numero);
		System.out.println("Saldo: " + String.format("%.2f", saldo));
	}
}

