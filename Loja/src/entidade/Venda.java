package entidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.enums.StatusPedido;

public class Venda {

    private LocalDate momento;
    private StatusPedido status;
    private Usuario usuario;

    List<ItemVenda> list = new ArrayList<>();

    public Venda(Date momento, StatusPedido status, Usuario usuario) {
        super();
        this.momento = LocalDate.now();
        this.status = status;
        this.usuario = usuario;
    }

    public LocalDate getMomento() {
        return momento;
    }

    public void setMomento(LocalDate momento) {
        this.momento = momento;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemVenda> getList() {
        return list;
    }

    public void adicionarItem(ItemVenda item) {
        list.add(item);
    }

    public void removerItem(ItemVenda item) {
        list.remove(item);
    }

    public double total() {
        double soma = 0.0;
        for (ItemVenda item : list) {
            soma += item.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ").append(momento).append("\n");
        sb.append("Status do pedido: ").append(status).append("\n");
        sb.append("Cliente: ").append(usuario.getNome()).append("\n");
        sb.append("Itens solicitados:\n");

        for (ItemVenda item : list) {
            Produto produto = item.getProduto();
            sb.append("- ").append(produto.getName())
              .append(", Quantidade: ").append(produto.getQuantidade())
              .append(", Preço unitário: R$").append(String.format("%.2f", produto.getPreco()))
              .append(", Subtotal: R$").append(String.format("%.2f", item.subTotal()))
              .append("\n  Entrega: ").append(produto.tipoEntrega())
              .append("\n");
        }

        sb.append("Preço total: R$").append(String.format("%.2f", total()));
        return sb.toString();
    }
}
