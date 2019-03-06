package fr.iocean.dta.repository;

import java.util.List;

import fr.iocean.dta.model.Employee;

public interface EmployeeRepository {
	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	Employee findBySsn(String ssn);

	void updateEmployee(Employee employee);

	Employee findLastHired();
	
	void deleteEmployee (int id);

	void updateAllEmployees(List<Employee> employees);

	void deleteAllEmployee();

}
