import java.util.List;

import javax.persistence.EntityManager;

public class Programa {

	public static void main(String[] args) {
		
		JPAUtil util = new JPAUtil();
		EntityManager manager = util.criarEntityManager();
		
		Vendedor anderson = new Vendedor("Anderson");
		
		Produto pinico = new Produto("Pinico");
		Produto esqueiro = new Produto("Esqueiro");
		
		Venda primeira = new Venda(10, anderson, pinico);
		Venda segunda = new Venda(11, anderson, esqueiro);
		Venda terceira = new Venda(9, anderson, esqueiro);
		
		manager.getTransaction().begin();
		manager.persist(anderson);
		manager.persist(pinico);
		manager.persist(esqueiro);
		manager.persist(primeira);
		manager.persist(segunda);
		manager.persist(terceira);
		manager.getTransaction().commit();
		
		Vendedor vendedorSalvo = manager.find(Vendedor.class, 23l);
		Produto produtoSalvo = manager.find(Produto.class, 25l);
		System.out.println("As vendas dele foi: " + vendedorSalvo.media(produtoSalvo));
		
		
		
		util.fecharManager();
		util.fecharFactory();

	}

}
