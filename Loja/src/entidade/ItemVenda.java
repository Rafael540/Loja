package entidade;

public class ItemVenda {


	private Produto produto;

	public ItemVenda( Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public double subTotal() {
		return produto.getPreco() * produto.getQuantidade();
	}
	
	@Override
	public String toString() {
		return produto.getName() 
				+ ", $" 
				+ String.format("%.2f", produto.getPreco()) 
				+ ", Quantidade: " 
				+ produto.getQuantidade() + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}
	
	 
}
