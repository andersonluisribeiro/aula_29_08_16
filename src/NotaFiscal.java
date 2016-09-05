import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String cliente;
	
	@OneToMany(mappedBy="notaFiscal", cascade=CascadeType.ALL)
	private List<Item> itens = new ArrayList<Item>();
	
	public NotaFiscal() {		
	}

	public NotaFiscal(String cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public Double valorTotal(){
		Double valorTotal = 0d;
		for (Item item : getItens()) {
			valorTotal += item.getValor();
		}
		return valorTotal;
	}
	
	
	
	
}
