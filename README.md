# FiapBank ATM - Caixa Eletrônico em Java

O **FiapBank ATM** é uma aplicação de terminal interativa que simula o funcionamento de um Caixa Eletrônico (ATM). O projeto foi desenvolvido aplicando conceitos avançados de **Programação Orientada a Objetos (POO)** e seguindo princípios de arquitetura limpa e padrões de projeto de mercado.

---

## Tecnologias e Conceitos Utilizados

* **Linguagem:** Java (Java SE)
* **Controle de Precisão Financeira:** `BigDecimal` para evitar problemas de arredondamento em cálculos monetários.
* **Arquitetura em Camadas:** Divisão clara de responsabilidades entre Apresentação, Aplicação e Domínio.
* **Padrões de Projeto (Design Patterns):**
    * **Singleton:** Garante uma única instância global da Fábrica de Contas.
    * **Factory Method:** Encapsula a lógica de criação de diferentes tipos de contas (`ContaCorrente` e `ContaPoupanca`).
    * **Value Objects (VO):** Encapsulamento de dados immutáveis com regras próprias, como `Dinheiro` e `Movimentacao`.

---

##  Arquitetura do Sistema

O projeto adota uma estrutura de pacotes baseada em responsabilidades técnicas, garantindo baixo acoplamento e alta coesão:

```text
br.com.fiap.atm/
│
├── presentation/                  # Camada de Interface/Terminal
│   └── TerminalBancarioController # Captura as entradas do usuário e interage com os serviços
│
├── application/                   # Camada de Serviços e Casos de Uso
│   ├── ContaService               # Gerencia as regras de negócio de saque, depósito e extrato
│   ├── AutenticacaoService        # Controle de acesso e segurança da conta
│   └── ContaFactory               # Fábrica Singleton para criação de contas
│
├── domain/                        # O Coração do Sistema (Regras de Negócio Core)
│   ├── entidades/
│   │   ├── Cliente                # Entidade que representa o titular
│   │   └── Conta                  # Classe mãe (Abstrata) com regras gerais bancárias
│   │       ├── ContaCorrente      # Implementação com taxa de manutenção fixa
│   │       └── ContaPoupanca      # Implementação com rendimento de 1%
│   │
│   └── valueObject/
│       ├── Dinheiro               # VO que encapsula operações com BigDecimal (somar, subtrair, menorQue)
│       └── Movimentacao           # VO que representa o histórico do extrato
│
└── Main.java                      # Ponto de entrada que inicializa o ecossistema dinamicamente
