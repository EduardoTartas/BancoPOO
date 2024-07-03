import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        Conta conta = new Conta();
        int opc;
        while (true) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("""
                                        
                    GERENCIADOR DE CONTA
                    1 - Abrir Conta
                    2 - Fechar Conta
                    3 - Depositar
                    4 - Sacar
                    5 - Pagar Mensalidade
                    6 - Informacoes
                    7 - Sair""");
            opc = scan.nextInt();
            scan.nextLine(); // Consume the leftover newline
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            switch (opc) {
                case 1:
                    if (conta.isStatus()) {
                        System.out.println("Conta ja esta aberta.");
                    } else {
                        System.out.println("CRIAR CONTA");
                        System.out.print("Nome: ");
                        String nome = scan.nextLine();
                        System.out.print("Numero da conta: ");
                        String numero = scan.nextLine();
                        System.out.print("Tipo da conta (CC ou CP): ");
                        String tipo = scan.nextLine();
                        conta.abrirConta(nome, numero, tipo);
                        if (conta.getTipo().equals("CC")) {
                            conta.setSaldo(50);
                        } else {
                            conta.setSaldo(150);
                        }
                        System.out.println("Conta aberta com sucesso!");
                    }
                    break;
                case 2:
                    conta.fecharConta();
                    break;
                case 3:
                    if (!conta.isStatus()) {
                        System.out.print("Por favor, crie ou reative a conta para realizar essa acao.");
                    } else {
                        System.out.print("Digite o valor do deposito: ");
                        float valor = scan.nextFloat();
                        scan.nextLine();
                        conta.fazerDeposito(valor);
                    }
                    break;
                case 4:
                    if (!conta.isStatus()) {
                        System.out.print("Por favor, crie ou reative a conta para realizar essa acao.");
                    } else {
                        System.out.print("Digite o valor do saque: ");
                        float valor = scan.nextFloat();
                        scan.nextLine();
                        conta.fazerSaque(valor);
                    }
                    break;
                case 5:
                    if (!conta.isStatus()) {
                        System.out.print("Por favor, crie ou reative a conta para realizar essa acao.");
                    } else {
                        conta.pagarMensal();
                    }
                    break;
                case 6:
                    if (!conta.isStatus()) {
                        System.out.print("Por favor, crie ou reative a conta para realizar essa acao.");
                    }
                    else {
                        conta.info();
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Por favor, insira uma opcao valida.");
            }
            System.out.println("\nPressione Enter para continuar...");
            scan.nextLine();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
}
