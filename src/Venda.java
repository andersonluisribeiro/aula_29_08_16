import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer quantidade;
	
	@ManyToOne
	private Vendedor vendedor;	
	
	@ManyToOne
	private Produto produto;
	
	public Venda(){
		
	}
	
	public Venda(Integer quantidade, Vendedor vendedor, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.vendedor = vendedor;
		this.produto = produto;
	}
	
	public Long getId() {
		return id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
