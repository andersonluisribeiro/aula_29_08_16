import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory;	
	
	//cria a factory quando eu acesso a classe
	static{
		factory = Persistence.createEntityManagerFactory("loja");
	}
	
	//cria e retorna um entity manager
	public static EntityManager criarEntityManager(){
		return factory.createEntityManager();
	}

}
