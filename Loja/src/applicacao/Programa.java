package applicacao;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entidade.ItemVenda;
import entidade.Produto;
import entidade.ProdutoDigital;
import entidade.ProdutoFisico;
import entidade.Usuario;
import entidade.Venda;
import entidade.enums.StatusPedido;

public class Programa {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira os dados do cliente: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Telefone: ");
        String telefone = sc.next();

        Usuario usuario = new Usuario(nome, cpf, email, telefone);

        System.out.println("Entre com o status do pedido: ");
        System.out.print("Status (Pendente, Enviado, Entregue ou Aguardando): ");
        StatusPedido status = StatusPedido.valueOf(sc.next().toUpperCase());

        Venda venda = new Venda(null, status, usuario);

        System.out.print("Quantos itens terá nesse pedido? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Entre com o " + (i + 1) + "# da lista:");

            sc.nextLine();

            System.out.print("Tipo do produto (fisico/digital): ");
            String tipo = sc.nextLine().toLowerCase();

            System.out.print("Nome do produto: ");
            String name = sc.nextLine();

            System.out.print("Preço do produto: ");
            Double preco = sc.nextDouble();

            System.out.print("Quantidade de produtos: ");
            int quantidade = sc.nextInt();

            Produto produto;

            if (tipo.equals("fisico")) {
                produto = new ProdutoFisico(name, preco, quantidade);
            } else if (tipo.equals("digital")) {
                produto = new ProdutoDigital(name, preco, quantidade);
            } else {
                System.out.println("Tipo inválido. Item ignorado.");
                continue;
            }

            ItemVenda item = new ItemVenda(produto);
            venda.adicionarItem(item);
        }

        System.out.println();
        System.out.println("Resumo do pedido:");
        System.out.println(venda);

        sc.close();
    }
}
