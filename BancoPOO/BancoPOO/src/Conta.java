import java.io.IOException;
import java.util.Scanner;

public class Conta {
    public String numconta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status = false;
    public int opc;
    Scanner scan = new Scanner(System.in);

    public void Menu() throws IOException, InterruptedException {
        clear();
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
    }

    public void abrirConta() {
        if (this.status) {
            System.out.println("Conta ja esta aberta.");
            System.out.println("\n qualquer tecla para sair...");
            opc = scan.nextInt();
        } else {
            System.out.println("CRIAR CONTA");
            System.out.println("Nome: ");
            this.dono = scan.nextLine();
            System.out.println("Numero da conta: ");
            this.numconta = scan.nextLine();
            System.out.print("Tipo da conta CC (conta corrente) ou CP (conta poupanca): ");
            while (true) {
                this.tipo = scan.nextLine();
                if (this.tipo.equals("CC") || this.tipo.equals("CP")) {
                    if (this.tipo.equals("CC")) {
                        this.saldo = 50f;
                    } else {
                        this.saldo = 150f;
                    }
                    System.out.println("Conta aberta com sucesso!");
                    System.out.println("\nPressione qualquer tecla para sair...");
                    opc = scan.nextInt();
                    this.status = true;
                    break;
                } else {
                    System.out.print("Por favor, selecione um tipo de conta valido (CC ou CP): ");
                }
            }
        }
    }

    public void fecharConta() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa acao.");
        } else {
            if (this.saldo > 0 || this.saldo < 0) {
                System.out.println("Por favor, retire todo o saldo ou pague suas pendencias para fechar sua conta.");
            } else {
                System.out.println("Conta fechada com sucesso.");
                System.out.println("\nPressione qualquer tecla para sair...");
                opc = scan.nextInt();
                this.status = false;
            }
        }
    }

    public void fazerDeposito() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa acao.");
        } else {
            System.out.println("REALIZAR DEPOSITO");
            System.out.print("Informe o valor do deposito: ");
            while (true) {
                float deposito = scan.nextFloat();
                if (deposito < 0) {
                    System.out.println("Por favor, insira um valor valido.");
                } else {
                    System.out.println("Deposito realizado com sucesso.");
                    System.out.println("\nPressione qualquer tecla para sair...");
                    opc = scan.nextInt();
                    this.saldo += deposito;
                    break;
                }
            }
        }
    }

    public void fazerSaque() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa acao.");
        } else {
            System.out.println("REALIZAR SAQUE");
            System.out.print("Informe o valor do saque: ");
            float saque = scan.nextFloat();
            while (true) {
                if (saque > this.saldo) {
                    System.out.print("Valor invalido, informe novamente: ");
                    saque = scan.nextFloat();
                } else {
                    System.out.println("Saque realizado com sucesso!");
                    System.out.println("\nPressione qualquer tecla para sair...");
                    opc = scan.nextInt();
                    this.saldo -= saque;
                    break;
                }
            }
        }
    }

    public void pagarMensal() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa acao.");
        } else {
            float valorm = this.tipo.equals("CC") ? 12 : 20;
            System.out.println("Para pagar sua mensalidade, sera descontado um valor de R$" + valorm + " da sua conta.");
            System.out.print("Deseja pagar agora? 1(sim) 2(nao): ");
            int opc = scan.nextInt();
            if (opc == 1) {
                System.out.println("Mensalidade paga com sucesso.");
                System.out.println("\nPressione qualquer tecla para sair...");
                opc = scan.nextInt();
                this.saldo -= valorm;
            } else {
                System.out.println("Mensalidade adiada.");
                System.out.println("\nPressione qualquer tecla para sair...");
                opc = scan.nextInt();
            }
        }
    }

    public void info() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa acao.");
        } else {
            System.out.println("Informacoes da conta");
            System.out.println("Dono da conta: " + this.getDono());
            System.out.println("Numero da conta: " + this.getNumconta());
            System.out.println("Tipo da conta: " + this.getTipo());
            System.out.println("Saldo da conta: " + this.getSaldo());
            String status = this.status ? "ativa" : "desativada";
            System.out.println("Status da conta: " + status);
            System.out.println("\nPressione qualquer tecla para sair...");
            opc = scan.nextInt();
        }
    }

    public void clear() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    public String getNumconta() {return numconta;}

    public String getTipo() {return tipo;}

    public String getDono() {return dono;}

    public float getSaldo() {return saldo;}

    public boolean isStatus() {return status;}

    public void setNumconta(String numconta) {this.numconta = numconta;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public void setDono(String dono) {this.dono = dono;}

    public void setSaldo(float saldo) {this.saldo = saldo;}

    public void setStatus(boolean status) {this.status = status;}
}
