import java.io.IOException;
import java.util.Scanner;

public class Conta {
    public String numconta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status = false;
    Scanner scan = new Scanner(System.in);

    public Conta() {
        setSaldo(0);
        setStatus(false);
    }

    public void abrirConta(String dono, String numero, String tipo) {
        setDono(dono);
        setNumconta(numero);
        setTipo(tipo);
        while (true) {
            if (getTipo().equals("CC") || getTipo().equals("CP")) {
                setStatus(true);
                setTipo(tipo);
                break;
            } else {
                System.out.println("Por favor, selecione um tipo de conta valido (CC ou CP):");
                setTipo(scan.next());
            }
        }
    }

    public void fecharConta() {
        if (!isStatus()) {
            System.out.print("Por favor, crie ou reative a conta para realizar essa acao.");
        } else {
            if (getSaldo() != 0) {
                System.out.println("Por favor, retire todo o saldo ou pague suas pendencias para fechar sua conta.");
            } else {
                System.out.println("Conta fechada com sucesso.");
                setStatus(false);
            }
        }
    }

    public void fazerDeposito(float valor) {
        while (true) {
            if (valor > 0) {
                System.out.println("Deposito realizado com sucesso.");
                setSaldo(getSaldo() + valor);
                break;
            } else {
                System.out.println("Por favor, insira um valor valido.");
                valor = scan.nextFloat();
            }
        }
    }

    public void fazerSaque(float valor) {
        while (true) {
            if (valor > 0 && valor <= getSaldo()) {
                System.out.println("Saque realizado com sucesso.");
                setSaldo(getSaldo() - valor);
                break;
            } else if (valor > getSaldo()) {
                System.out.println("Saldo insuficiente.");
                break;
            } else {
                System.out.println("Por favor, insira um valor valido.");
                valor = scan.nextFloat();
            }
        }
    }

    public void pagarMensal() {
        float valor = getTipo().equals("CC") ? 12 : 20;
        System.out.println("Para pagar sua mensalidade, sera descontado um valor de R$" + valor + " da sua conta.");
        System.out.print("Deseja pagar agora? 1(sim) 2(nao): ");
        int opc = scan.nextInt();
        if (opc == 1) {
            System.out.println("Mensalidade paga com sucesso.");
            this.saldo -= valor;
        } else {
            System.out.println("Mensalidade adiada.");
        }
    }

    public void info() {
        System.out.println("Informacoes da conta");
        System.out.println("Dono da conta: " + getDono());
        System.out.println("Numero da conta: " + getNumconta());
        System.out.println("Tipo da conta: " + getTipo());
        System.out.println("Saldo da conta: " + getSaldo());
        String status = this.status ? "ativa" : "desativada";
        System.out.println("Status da conta: " + status);
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
