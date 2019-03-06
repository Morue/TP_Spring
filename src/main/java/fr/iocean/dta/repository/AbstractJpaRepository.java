package fr.iocean.dta.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractJpaRepository<T> {
	
	@PersistenceContext
	 EntityManager em;
	
	protected Session getSession() {
		return em.unwrap(Session.class);
		}
	
	public void persist(T entity) {
		em.persist(entity);
		}
	
	public void delete(T entity) {
		em.remove(entity);
		}
	
	public void update(T entity) {
		em.persist(entity);
	}
}
