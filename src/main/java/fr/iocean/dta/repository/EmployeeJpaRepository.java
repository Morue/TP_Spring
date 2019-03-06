package fr.iocean.dta.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.iocean.dta.exception.NoEmployeeException;
import fr.iocean.dta.model.Employee;

public abstract class EmployeeJpaRepository extends AbstractJpaRepository implements EmployeeRepository {

	@Override
	public void saveEmployee(Employee employee) {
		this.em.persist(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = this.em.createQuery("select e from Employe e", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findBySsn(String ssn) {
		TypedQuery<Employee> query;
		try {
			query = this.em.createQuery("select e from Employee e where e.numsecu", Employee.class);
			query.setParameter(1, ssn);
		}
		catch (Exception e) {
			throw new NoEmployeeException ("Nope, nope, nope");
		}
		return query.getSingleResult();
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.em.persist(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		TypedQuery<Employee> query = this.em.createQuery("delete e from Employee e where e.id=:id", Employee.class);
		query.setParameter("id",id);
	}

	@Override
	public void updateAllEmployees(List<Employee> employees) {

	}

	@Override
	public void deleteAllEmployee(){
		TypedQuery<Employee> query = this.em.createQuery("delete e from Employee e", Employee.class);

	}

}
