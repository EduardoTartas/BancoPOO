import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        Conta conta = new Conta();
        while (true) {
            switch (conta.opc) {
                case 1:
                    conta.clear();
                    conta.abrirConta();
                    break;
                case 2:
                    conta.clear();
                    conta.fecharConta();
                    break;
                case 3:
                    conta.clear();
                    conta.fazerDeposito();
                    break;
                case 4:
                    conta.clear();
                    conta.fazerSaque();
                    break;
                case 5:
                    conta.clear();
                    conta.pagarMensal();
                    break;
                case 6:
                    conta.clear();
                    conta.info();
                    break;
                case 7:
                    conta.clear();
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    conta.clear();
                    conta.Menu();
                    break;
            }


        }
    }
}