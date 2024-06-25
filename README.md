
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

## Estrutura do Projeto

### Classe Principal (Main)
A classe principal contém um loop que exibe um menu para o usuário com opções para abrir conta, fechar conta, fazer depósito, sacar, pagar mensalidade e exibir informações da conta. Dependendo da escolha do usuário, o método correspondente na classe `Conta` é chamado.

### Classe Conta
Esta classe gerencia os atributos e métodos relacionados às operações da conta bancária. Ela contém métodos para abrir e fechar contas, fazer depósitos e saques, pagar mensalidades e exibir informações da conta.

---
