package fr.iocean.dta.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import fr.iocean.dta.model.Employee;

@Repository
public class EmployeeMockRepository implements EmployeeRepository {

	private List<Employee> employee;

	@PostConstruct
	public void init() {
		this.employee = new ArrayList<Employee>();
		employee.add(new Employee(1L, "Henry", "HardCore", "123456789", new BigDecimal(2500.12), LocalDate.now()));
		employee.add(new Employee(1L, "Micheline", "Gudule", "11223344", new BigDecimal(4500.82), LocalDate.now()));
		employee.add(new Employee(1L, "Yoann", "Plop", "55666778899", new BigDecimal(1500.52), LocalDate.now()));

	}

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	public List<Employee> findAllEmployees() {
		return employee;
	}

	public Employee findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee findLastHired() {
		// TODO Auto-generated method stub
		return null;
	}

}
