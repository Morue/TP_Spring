package fr.iocean.dta.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.iocean.dta.model.Employee;

@Repository
public class EmployeeJdbcRepository extends AbstractJdbcRepository implements EmployeeRepository {

	@Override
	public void saveEmployee(Employee employee) {
		this.jdbcTemplate.update(
				"insert into employee(firstname, lastname, hiredate, salary, ssn) values( ? , ? ,  ? ,  ? , ? )",
				employee.getNomEmployee(), employee.getPrenom(),
				Date.from(employee.getDateEmbauche().atStartOfDay(ZoneId.systemDefault()).toInstant()),
				employee.getSalaire(), employee.getNumSecu());
	}

	@Override
	public List<Employee> findAllEmployees() {
		return this.jdbcTemplate.query("select * from employee", new EmployeeMapper());
	}

	@Override
	public Employee findBySsn(String ssn) {
		return this.jdbcTemplate.queryForObject("select * from employee where ssn = ?", new Object[] { ssn },
				new EmployeeMapper());
	}

	@Override
	public void updateEmployee(Employee employee) {
		Date date = Date.valueOf(employee.getDateEmbauche());
		this.jdbcTemplate.update(
				"update employee set firstname = ?, lastname = ?, hiredate = ?,  salary = ?, ssn = ? where id = ?",
				employee.getPrenom(), employee.getNomEmployee(), date, employee.getSalaire(), employee.getNumSecu(),
				employee.getIdentifiant());
	}

	public class EmployeeMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setPrenom(rs.getString("firstname"));
			employee.setNomEmployee(rs.getString("lastname"));
			employee.setDateEmbauche(rs.getDate("hiredate").toLocalDate());
			employee.setIdentifiant(rs.getLong("id"));
			employee.setNumSecu(rs.getString("ssn"));
			employee.setSalaire(rs.getBigDecimal("salary"));
			return employee;
		}

	}

	@Override
	public Employee findLastHired() {
		return this.jdbcTemplate.queryForObject("select * from employee where id = (select max(id) from employee where hiredate = (select max(hiredate) from employee))", new EmployeeMapper());
	}
}
