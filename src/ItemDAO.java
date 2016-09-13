import javax.persistence.EntityManager;

public class ItemDAO {

	private EntityManager manager;	
	
	public ItemDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Item item){
		manager.getTransaction().begin();
		manager.persist(item);
		manager.getTransaction().commit();		
	}
	
}
