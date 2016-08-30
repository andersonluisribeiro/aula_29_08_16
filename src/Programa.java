import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager manager = factory.createEntityManager();
		
		Pessoa anderson = new Pessoa();
		anderson.setNome("Anderson");		
		
		
		Atividade trabalhar = new Atividade();
		trabalhar.setDescricao("Trabalhar");
		
		Atividade estudar = new Atividade();
		estudar.setDescricao("Estudar");
		
		anderson.getAtividades().add(trabalhar);
		anderson.getAtividades().add(estudar);
		
		manager.getTransaction().begin();			
		manager.persist(anderson);		
		manager.getTransaction().commit();		
		
		manager.close();
		factory.close();
	
	}

}
