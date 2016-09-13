import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NotaFiscalDAO {
	
	private EntityManager manager;
	private EntityManagerFactory factory;
	
	public NotaFiscalDAO(){
		this.factory = Persistence.createEntityManagerFactory("loja");
		this.manager = factory.createEntityManager();
	}
	
	public void salvar(NotaFiscal notaFiscal){
		manager.getTransaction().begin();
		manager.persist(notaFiscal);
		manager.getTransaction().commit();
	}
	
	public NotaFiscal encontrarPorId(Long id){
		return manager.find(NotaFiscal.class, id);
	}
	
	public void fechaConexao(){
		this.manager.close();
		this.factory.close();
	}

}
