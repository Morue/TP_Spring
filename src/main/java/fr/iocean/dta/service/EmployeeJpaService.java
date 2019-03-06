package fr.iocean.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.dta.exception.NoEmployeeException;
import fr.iocean.dta.model.Employee;
import fr.iocean.dta.repository.EmployeeRepository;

@Service
@Transactional(rollbackFor = NoEmployeeException.class)
public class EmployeeJpaService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeJpaRepository;

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeJpaRepository.saveEmployee(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return employeeJpaRepository.findAllEmployees();
	}

	@Override
	@Transactional(rollbackFor = NoEmployeeException.class)
	public Employee findBySsn(String ssn) {
		// TODO Auto-generated method stub
		try {
			return employeeJpaRepository.findBySsn(ssn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return null;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeJpaRepository.updateEmployee(employee);
	}

	@Override
	public Employee findLastHired() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteEmployee(int id) {
		employeeJpaRepository.deleteEmployee(id);
		
	}

	@Override
	public void updateAllEmployees(List<Employee> employees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllEmployee() {
		employeeJpaRepository.deleteAllEmployee();
		
}

}
