package fr.iocean.dta;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

import fr.iocean.dta.model.Employee;
import fr.iocean.dta.service.EmployeeService;

@Configuration
@ComponentScan(basePackages = "fr.iocean.dta")
@EnableAspectJAutoProxy
public class App {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		LOG.info("Example log from {}", App.class.getSimpleName());

		Employee e1 = new Employee();
		e1.setDateEmbauche(LocalDate.of(2018, 3, 20));
		e1.setNomEmployee("lollll");
		e1.setNumSecu("5");
		e1.setPrenom("salut");
		e1.setSalaire(new BigDecimal(12.99));

		EmployeeService employeeJpaService = (EmployeeService) context.getBean("employeeJpaService");

		Employee e2 = employeeJpaService.findBySsn("5");
		System.out.println("YO : " + e2);
		context.close();

//		EmployeeService employeeJdbcService = (EmployeeService) context.getBean("employeeJdbcService");
//		Employee employee = new Employee();
//		employee.setDateEmbauche(LocalDate.now());
//		employee.setNomEmployee("Diligent");
//		employee.setPrenom("Mélanie");
//		employee.setNumSecu("286545868855");
//		employee.setSalaire(new BigDecimal("-1"));
//		employeeJdbcService.saveEmployee(employee);
//
//		employee.setIdentifiant(2L);
//		employee.setNomEmployee("Pichery");
//		employeeJdbcService.updateEmployee(employee);
//
//		System.out.println(employeeJdbcService.findAllEmployees());
//
//		System.out.println(employeeJdbcService.findLastHired());

	}

}
