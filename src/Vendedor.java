import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vendedor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	private String nome;
	
	@OneToMany(mappedBy="vendedor")
	private List<Venda> vendas;
	
	public Vendedor(){
		
	}

	public Vendedor(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Venda> getVendas() {
		return vendas;
	}
	
	public Integer media(Produto produto){
		Integer soma = 0;
		Integer quantidade = 0;
		for(Venda venda : getVendas()){
			if(venda.getProduto().equals(produto)){
				soma += venda.getQuantidade();
				quantidade = quantidade + 1;
			}
			
		}
		return soma / quantidade;
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
		Vendedor other = (Vendedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
