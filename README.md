# Simulador de Banco em Java
 Claro, aqui está o texto formatado para um README no GitHub:

---

# Simulador de Banco em Java

Este projeto é um simulador de banco desenvolvido em Java como exercício prático para aprender Programação Orientada a Objetos (POO). A aplicação permite aos usuários gerenciar suas contas bancárias de forma simples e intuitiva.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação utilizada para implementar a lógica do simulador, aplicando os princípios de POO.

## Funcionalidades Principais

### Gerenciamento de Contas

- **Abrir Conta:** O usuário pode abrir uma nova conta bancária fornecendo informações como nome, número da conta e tipo de conta (corrente ou poupança). Cada tipo de conta inicia com um saldo inicial (R$50 para conta corrente e R$150 para conta poupança).
- **Fechar Conta:** Permite que o usuário feche uma conta existente, desde que o saldo esteja zerado.
- **Exibir Informações da Conta:** Mostra detalhes da conta, incluindo nome do titular, número da conta, tipo de conta, saldo e status (ativa ou inativa).

### Operações Bancárias

- **Depósito:** O usuário pode depositar uma quantia na conta, aumentando o saldo.
- **Saque:** O usuário pode sacar uma quantia, desde que o saldo seja suficiente para cobrir o saque.
- **Pagamento de Mensalidade:** Cada tipo de conta tem uma mensalidade (R$12 para conta corrente e R$20 para conta poupança) que pode ser paga pelo usuário.

## Objetivos do Projeto

- **Aprender POO:** Aplicar conceitos fundamentais como encapsulamento, herança e polimorfismo.
- **Desenvolver a Lógica Bancária:** Implementar funcionalidades de um banco real de forma simplificada.
- **Interação com o Usuário:** Criar um menu interativo para que o usuário possa realizar operações bancárias através do console.
- **Simulação Realista:** Fornecer uma experiência prática de como seria gerenciar uma conta bancária.

## Estrutura do Projeto

### Classe Principal (Main)
A classe principal contém um loop que exibe um menu para o usuário com opções para abrir conta, fechar conta, fazer depósito, sacar, pagar mensalidade e exibir informações da conta. Dependendo da escolha do usuário, o método correspondente na classe `Conta` é chamado.

```java
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
```

### Classe Conta
Esta classe gerencia os atributos e métodos relacionados às operações da conta bancária. Ela contém métodos para abrir e fechar contas, fazer depósitos e saques, pagar mensalidades e exibir informações da conta.

```java
import java.util.Scanner;

public class Conta {
    private String numconta;
    private String tipo;
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
            while (true) {
                System.out.print("Tipo da conta (CC para conta corrente ou CP para conta poupança): ");
                this.tipo = scan.nextLine();
                if (this.tipo.equals("CC") || this.tipo.equals("CP")) {
                    this.saldo = this.tipo.equals("CC") ? 50f : 150f;
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
            System.out.println("Conta já está fechada ou não existe.");
        } else {
            if (this.saldo != 0) {
                System.out.println("Por favor, retire todo o saldo ou pague suas pendências antes de fechar a conta.");
            } else {
                System.out.println("Conta fechada com sucesso.");
                this.status = false;
            }
        }
    }

    public void fazerDeposito() {
        if (!this.status) {
            System.out.println("Por favor, abra ou reative a conta para realizar esta ação.");
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
            System.out.println("Por favor, abra ou reative a conta para realizar esta ação.");
        } else {
            System.out.println("REALIZAR SAQUE");
            System.out.print("Informe o valor do saque: ");
            while (true) {
                float saque = scan.nextFloat();
                if (saque > this.saldo) {
                    System.out.print("Saldo insuficiente. Informe um valor válido: ");
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
            System.out.println("Por favor, abra ou reative a conta para realizar esta ação.");
        } else {
            float mensalidade = this.tipo.equals("CC") ? 12 : 20;
            System.out.println("Mensalidade de R$" + mensalidade + " será descontada da sua conta.");
            System.out.print("Deseja pagar agora? 1(sim) 2(não): ");
            int opc = scan.nextInt();
            if (opc == 1) {
                if (this.saldo >= mensalidade) {
                    System.out.println("Mensalidade paga com sucesso.");
                    this.saldo -= mensalidade;
                } else {
                    System.out.println("Saldo insuficiente para pagar a mensalidade.");
                }
            } else {
                System.out.println("Mensalidade adiada.");
            }
        }
    }

    public void info() {
        if (!this.status) {
            System.out.println("Por favor, abra ou reative a conta para realizar esta ação.");
        } else {
            System.out.println("Informações da conta:");
            System.out.println("Dono: " + this.getDono());
            System.out.println("Número da conta: " + this.getNumconta());
            System.out.println("Tipo: " + this.getTipo());
            System.out.println("Saldo: " + this.getSaldo());
            System.out.println("Status: " + (this.status ? "Ativa" : "Inativa"));
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
```

Este projeto me proporciona uma maneira prática de aprender e aplicar os conceitos de Programação Orientada a Objetos em Java, enquanto crio um simulador de banco funcional e educativo.

---
