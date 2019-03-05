package fr.iocean.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iocean.dta.model.Employee;

@Service
public class CompanyService {

	@Autowired
	private EmployeeService employeeMockService;

	public List<Employee> findAllEmployees() {
		return employeeMockService.findAllEmployees();
	}

}
