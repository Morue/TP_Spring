package fr.iocean.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.dta.exception.EmployeeErrorException;
import fr.iocean.dta.model.Employee;
import fr.iocean.dta.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeJdbcService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeJdbcRepository;

	@Override
	@Transactional(rollbackFor = EmployeeErrorException.class)
	public void saveEmployee(Employee employee) {
		employeeJdbcRepository.saveEmployee(employee);
//		throw new EmployeeErrorException("CA MERDE");

	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeJdbcRepository.findAllEmployees();
	}

	@Override
	public Employee findBySsn(String ssn) {
		return employeeJdbcRepository.findBySsn(ssn);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeJdbcRepository.updateEmployee(employee);
	}

	@Override
	public Employee findLastHired() {
		return employeeJdbcRepository.findLastHired();
	}

}
