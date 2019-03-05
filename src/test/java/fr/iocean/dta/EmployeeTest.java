package fr.iocean.dta;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.iocean.dta.exception.NoEmployeeException;
import fr.iocean.dta.model.Employee;
import fr.iocean.dta.repository.EmployeeRepository;
import fr.iocean.dta.service.CompanyService;
import fr.iocean.dta.service.EmployeeService;
import fr.iocean.dta.service.MailService;

public class EmployeeTest {

	@Test
	public void testEmployeeRepository() {
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		EmployeeRepository employeeRepository = (EmployeeRepository) context.getBean("employeeMockRepository");
		assertNotNull(employeeRepository.findAllEmployees());
		context.close();
	}

	@Test
	public void testEmployeeService() {
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeMockService");
		assertNotNull(employeeService.findAllEmployees());
		context.close();
	}

	@Test
	public void testCompanyService() {
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		CompanyService companyService = (CompanyService) context.getBean("companyService");
		assertNotNull(companyService.findAllEmployees());
		context.close();
	}

	@Test
	public void testMailService() {
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e = new Employee(1L, "mélanie", "Diligent", "279357687", new BigDecimal("2"), LocalDate.now());
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		MailService mailService1 = (MailService) context.getBean("mailService");
		MailService mailService2 = (MailService) context.getBean("mailService");
		mailService1.setMessage("CA ROULE !");
		mailService2.setMessage("A L'ARRET !");
		mailService1.sendMail(e);
		mailService2.sendMail(e);
		context.close();
	}
	
	@Test(expected = NoEmployeeException.class)
	public void testAppelSsn() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeMockService");
		employeeService.findBySsn("ytrdyryftiufyti");
	}
	

}
