package fr.iocean.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iocean.dta.exception.NoEmployeeException;
import fr.iocean.dta.model.Employee;
import fr.iocean.dta.repository.EmployeeRepository;

@Service
public class EmployeeMockService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeMockRepository;

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeMockRepository.findAllEmployees();
	}

	@Override
	public Employee findBySsn(String ssn) {
		List<Employee> employees = employeeMockRepository.findAllEmployees();
		
		return employees.stream().filter(e -> e.getNumSecu().equals(ssn)).findFirst().orElseThrow(() -> new NoEmployeeException("khgfkfkgfkghfkhgf"));
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee findLastHired() {
		// TODO Auto-generated method stub
		return null;
	}

}
