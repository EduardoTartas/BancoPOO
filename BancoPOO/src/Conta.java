import java.util.Scanner;

public class Conta {
    public String numconta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status = false;
    Scanner scan = new Scanner(System.in);

    public void abrirConta() {
        if (this.status) {
            System.out.println("Conta já está aberta.");
        } else {
            System.out.println("CRIAR CONTA");
            System.out.print("Nome: ");
            this.dono = scan.nextLine();
            System.out.print("Número da conta: ");
            this.numconta = scan.nextLine();
            System.out.print("Tipo da conta CC (conta corrente) ou CP (conta poupança): ");
            while (true) {
                this.tipo = scan.nextLine();
                if (this.tipo.equals("CC") || this.tipo.equals("CP")) {
                    if (this.tipo.equals("CC")) {
                        this.saldo = 50f;
                    } else {
                        this.saldo = 150f;
                    }
                    System.out.println("Conta aberta com sucesso!");
                    this.status = true;
                    break;
                } else {
                    System.out.print("Por favor, selecione um tipo de conta válido (CC ou CP): ");
                }
            }
        }
    }

    public void fecharConta() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa ação.");
        } else {
            if (this.saldo > 0 || this.saldo < 0) {
                System.out.println("Por favor, retire todo o saldo ou pague suas pendências para fechar sua conta.");
            } else {
                System.out.println("Conta fechada com sucesso.");
                this.status = false;
            }
        }
    }

    public void fazerDeposito() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa ação.");
        } else {
            System.out.println("REALIZAR DEPÓSITO");
            System.out.print("Informe o valor do depósito: ");
            while (true) {
                float deposito = scan.nextFloat();
                if (deposito < 0) {
                    System.out.println("Por favor, insira um valor válido.");
                } else {
                    System.out.println("Depósito realizado com sucesso.");
                    this.saldo += deposito;
                    break;
                }
            }
        }
    }

    public void fazerSaque() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa ação.");
        } else {
            System.out.println("REALIZAR SAQUE");
            System.out.print("Informe o valor do saque: ");
            float saque = scan.nextFloat();
            while (true) {
                if (saque > this.saldo) {
                    System.out.print("Valor inválido, informe novamente: ");
                    saque = scan.nextFloat();
                } else {
                    System.out.println("Saque realizado com sucesso!");
                    this.saldo -= saque;
                    break;
                }
            }
        }
    }

    public void pagarMensal() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa ação.");
        }
        else {
                float valorm =this.tipo.equals("CC")?12:20;
                System.out.println("Para pagar sua mensalidade, será descontado um valor de R$"+valorm+" da sua conta.");
                System.out.print("Deseja pagar agora? 1(sim) 2(não): ");
                int opc = scan.nextInt();
                if (opc == 1) {
                    System.out.println("Mensalidade paga com sucesso.");
                    this.saldo -= valorm;
                }
                else {
                    System.out.println("Mensalidade adiada.");
                }
        }
    }

    public void info() {
        if (!this.status) {
            System.out.println("Por favor, crie ou reative a conta para realizar essa ação.");
        } else {
            System.out.println("Informações da conta");
            System.out.println("Dono da conta: " + this.getDono());
            System.out.println("Número da conta: " + this.getNumconta());
            System.out.println("Tipo da conta: " + this.getTipo());
            System.out.println("Saldo da conta: " + this.getSaldo());
            String status = this.status ? "ativa" : "desativada";
            System.out.println("Status da conta: " + status);
        }
    }

    public String getNumconta() {
        return numconta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDono() {
        return dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setNumconta(String numconta) {
        this.numconta = numconta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
