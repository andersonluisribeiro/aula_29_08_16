import javax.persistence.EntityManager;

public class NotaFiscalDAO {
	
	private EntityManager manager;
	
	public NotaFiscalDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(NotaFiscal notaFiscal){
		manager.getTransaction().begin();
		manager.persist(notaFiscal);
		manager.getTransaction().commit();
	}
	
	public NotaFiscal encontrarPorId(Long id){
		return manager.find(NotaFiscal.class, id);
	}
	
	

}
