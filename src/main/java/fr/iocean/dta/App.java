package fr.iocean.dta;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan(basePackages = "fr.iocean.dta")
@EnableAspectJAutoProxy
public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
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
