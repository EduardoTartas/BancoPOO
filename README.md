# BancoPOO
 Projeto em Java que funciona como um simulador de banco. Este projeto é um exercício prático para aprender Programação Orientada a Objetos (POO). A ideia é permitir que os usuários gerenciem suas contas bancárias de forma simples e intuitiva.
 
 Tecnologias Utilizadas:
Java: A linguagem de programação utilizada para implementar a lógica do simulador, aplicando os princípios de POO.
Funcionalidades Principais:
Gerenciamento de Contas:

Abrir Conta: O usuário pode abrir uma nova conta bancária fornecendo informações como nome, número da conta e tipo de conta (corrente ou poupança). Cada tipo de conta inicia com um saldo inicial (50 para corrente e 150 para poupança).
Fechar Conta: Permite que o usuário feche uma conta existente, desde que o saldo esteja zerado.
Exibir Informações da Conta: Mostra detalhes da conta, incluindo nome do titular, número da conta, tipo de conta, saldo e status (ativa ou inativa).
Operações Bancárias:

Depósito: O usuário pode depositar uma quantia na conta, aumentando o saldo.
Saque: O usuário pode sacar uma quantia, desde que o saldo seja suficiente para cobrir o saque.
Pagamento de Mensalidade: Cada tipo de conta tem uma mensalidade (12 para conta corrente e 20 para poupança) que pode ser paga pelo usuário.
Objetivos do Projeto:
Aprender POO: Aplicar conceitos fundamentais como encapsulamento, herança e polimorfismo.
Desenvolver a Lógica Bancária: Implementar funcionalidades de um banco real de forma simplificada.
Interação com o Usuário: Criar um menu interativo para que o usuário possa realizar operações bancárias através do console.
Simulação Realista: Fornecer uma experiência prática de como seria gerenciar uma conta bancária.
Estrutura do Projeto:
Classe Principal (Main):
A classe principal contém um loop que exibe um menu para o usuário com opções para abrir conta, fechar conta, fazer depósito, sacar, pagar mensalidade e exibir informações da conta. Dependendo da escolha do usuário, o método correspondente na classe Conta é chamado.

Classe Conta:
Esta classe gerencia os atributos e métodos relacionados às operações da conta bancária. Ela contém métodos para abrir e fechar contas, fazer depósitos e saques, pagar mensalidades e exibir informações da conta.
