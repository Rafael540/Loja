package entidade;

public class ProdutoDigital extends Produto{



	    public ProdutoDigital(String name, Double preco, Integer quantidade) {
		super(name, preco, quantidade);
	}

		@Override
	    public String tipoEntrega() {
	        return "Link para download enviado por e-mail";
	    }
}
