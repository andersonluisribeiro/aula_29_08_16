import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String produto;
	
	private Double valor;
	
	@ManyToOne
	private NotaFiscal notaFiscal;
	
	public Item(){
		
	}

	public Item(String produto, Double valor, NotaFiscal notaFiscal) {		
		this.produto = produto;
		this.valor = valor;
		this.notaFiscal = notaFiscal;
	}

	public Long getId() {
		return id;
	}

	public String getProduto() {
		return produto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}	

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	
	
}
