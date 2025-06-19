package entidade;

	public class ProdutoFisico extends Produto {

	   
	    public ProdutoFisico(String name, Double preco, Integer quantidade) {
			super(name, preco, quantidade);
		}

		@Override
	    public String tipoEntrega() {
	        return "Enviado por correios";
	    }
	}


