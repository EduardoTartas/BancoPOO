import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Conta conta = new Conta();
        int opc;
        while (true) {
            System.out.println("""
                    
                    GERENCIADOR DE CONTA
                    1 - Abrir Conta
                    2 - Fechar Conta
                    3 - Depositar
                    4 - Sacar
                    5 - Pagar Mensalidade
                    6 - Informações
                    7 - Sair""");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    conta.abrirConta();
                    break;
                case 2:
                    conta.fecharConta();
                    break;
                case 3:
                    conta.fazerDeposito();
                    break;
                case 4:
                    conta.fazerSaque();
                    break;
                case 5:
                    conta.pagarMensal();
                    break;
                case 6:
                    conta.info();
                    break;
                default:
                    System.out.println("Saindo...");
                    System.exit(0);
            }


        }
    }
}