import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		JPAUtil util = new JPAUtil();
		
		//criando todos os daos
		NotaFiscalDAO notaFiscalDAO = new NotaFiscalDAO(util.criarEntityManager());
		ItemDAO itemDAO = new ItemDAO(util.criarEntityManager());
		
		//intanciar os objetos
		NotaFiscal nota = new NotaFiscal("Anderson");
		Item privada = new Item("Privada", 30.5d, nota);
		Item pinico = new Item("Pinico", 10.5d, nota);
		Item chupeta = new Item("Chupeta", 10.5d, nota);
		
		//salvando os objetos
		util.abrirTransacao();
		notaFiscalDAO.salvar(nota);
		itemDAO.salvar(privada);
		itemDAO.salvar(pinico);
		itemDAO.salvar(chupeta);
		util.commitarTransacao();
		
		//recuperando a nota fiscal
		NotaFiscal notaPersistida = notaFiscalDAO.encontrarPorId(1l);	
		System.out.println("Valor total da nota: " + notaPersistida.valorTotal());		
		
		util.fecharManager();
		util.fecharFactory();
	
	}

}
