import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		//criando todos os daos
		NotaFiscalDAO notaFiscalDAO = new NotaFiscalDAO();
		ItemDAO itemDAO = new ItemDAO();
		
		//intanciar os objetos
		NotaFiscal nota = new NotaFiscal("Anderson");
		Item privada = new Item("Privada", 30.5d, nota);
		Item pinico = new Item("Pinico", 10.5d, nota);
		Item chupeta = new Item("Chupeta", 10.5d, nota);
		
		//salvando os objetos
		notaFiscalDAO.salvar(nota);
		itemDAO.salvar(privada);
		itemDAO.salvar(pinico);
		itemDAO.salvar(chupeta);
		
		//recuperando a nota fiscal
		NotaFiscal notaPersistida = notaFiscalDAO.encontrarPorId(1l);	
		System.out.println("Valor total da nota: " + notaPersistida.valorTotal());		
		
		notaFiscalDAO.fechaConexao();
		itemDAO.fechaConexao();
	
	}

}
