import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ItemDAO {

	private EntityManager manager;
	private EntityManagerFactory factory;
	
	public ItemDAO(){
		this.factory = Persistence.createEntityManagerFactory("loja");
		this.manager = factory.createEntityManager();
	}
	
	public void salvar(Item item){
		manager.getTransaction().begin();
		manager.persist(item);
		manager.getTransaction().commit();		
	}
	
	public void fechaConexao(){
		this.manager.close();
		this.factory.close();
	}
	
}
