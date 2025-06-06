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
		for(ItemVenda item : list) {
			soma += item.subTotal();
			}
		return soma;
		}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: ");
		sb.append(momento + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(usuario.getNome() + "\n");
		sb.append("Itens solicitados \n");
		for (ItemVenda item : list) {
			sb.append(item + "\n");
		}
		sb.append("Preco total $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
	
	
	
	
	}
	
	


