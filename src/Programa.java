import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager manager = factory.createEntityManager();
		
		NotaFiscal nota = new NotaFiscal("Anderson");
		
		Item privada = new Item("Privada", 10.5d, nota);
		Item pinico = new Item("Pinico", 10.5d, nota);
		Item chupeta = new Item("Chupeta", 10.5d, nota);		
		
		manager.getTransaction().begin();
		manager.persist(nota);
		manager.persist(privada);
		manager.persist(pinico);
		manager.persist(chupeta);
		manager.getTransaction().commit();
	
		System.out.println("Valor total da nota: " + nota.valorTotal());
		
		manager.close();
		factory.close();
	
	}

}
