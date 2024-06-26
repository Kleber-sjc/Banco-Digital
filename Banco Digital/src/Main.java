import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite seu nome: ");
            String cliente = scanner.nextLine();
            System.out.println("Olá " + cliente + ", Seja bem vindo(a)!");
            
            Conta cc = new ContaCorrente(cliente);
            Conta poupanca = new ContaPoupanca(cliente);

            cc.depositar(100);  // Exemplo de depósito inicial
            cc.transferir(100, poupanca);  // Exemplo de transferência entre contas
            
            System.out.println("\nExtratos:");
            cc.imprimirExtrato();
            poupanca.imprimirExtrato();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}

