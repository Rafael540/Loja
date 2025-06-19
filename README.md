# 🛒 Loja

A **Loja** é uma aplicação Java simples que simula o funcionamento básico de um sistema de vendas.  
Ela utiliza conceitos de orientação a objetos e é ideal para fins didáticos e prática com Java puro (sem frameworks).

## 📦 Funcionalidades

- Cadastro de produtos
- Criação de vendas com itens associados
- Controle de usuários
- Controle de status dos pedidos via enum (`StatusPedido`)
- Cálculo de total de vendas com base nos itens

## 🧱 Estrutura de Entidades
```mermaid
classDiagram
    class Produto {
        - String name
        - Double preco
        - Integer quantidade
      
    }

    class ItemVenda {
        - Produto produto
        + subTotal() double
        + toString()
    }

    class Usuario {
        - String nome
        - String cpf
        - String email
        - String telefone
    }

    class Venda {
        - LocalDate momento
        - StatusPedido status
        + adicionarItem()
        + removerItem()
        + total() double
        + toString()
    }

    class StatusPedido {
        <<enum>>
        AGUARDANDO
        PROCESSANDO
        ENVIADO
        ENTREGUE
    }
    class ProdutoDigital {
      +tipoEntrega(): String
    }
    
    class ProdutoFisico {
      +tipoEntrega(): String
    }

  
    Venda "1" --> "1" Usuario
    Venda "1" --> "*" ItemVenda
    ItemVenda "1" --> "1" Produto
    ProdutoDigital --|> Produto
    ProdutoFisico --|> Produto
    Venda --> StatusPedido
    
```
## 💻 Tecnologias Utilizadas

- Java (puro)

## 🚀 Como executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/loja.git
cd loja
