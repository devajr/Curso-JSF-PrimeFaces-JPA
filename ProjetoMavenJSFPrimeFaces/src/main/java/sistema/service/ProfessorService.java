package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



import sistema.modelos.Professor;


public class ProfessorService {

	private static EntityManagerFactory emf;
	
	public ProfessorService(){
	      emf = Persistence.createEntityManagerFactory("ProjetoMavenJSFPrimeFaces");
	}
	
	public void salvar(Professor professor)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(professor);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List <Professor> getProfessores()
	{
		
		List <Professor >professores;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Professor a");
		professores = q.getResultList();
		em.close();
		
		return professores;
		
	}

	public void alterar(Professor professor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(professor);
		em.getTransaction().commit();	
	    em.close();

		
		
	}

	
	public void remover(Professor professor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			professor = em.find(Professor.class,professor.getMatricula());
			em.remove(professor);
		em.getTransaction().commit();	
	    em.close();

		
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Professor> getAllProfessores(){
		
		EntityManager em = emf.createEntityManager();
		List <Professor> list = em.createQuery("Select c From Professor c").getResultList();
		em.close();
		return list;
	}
	
	
}
