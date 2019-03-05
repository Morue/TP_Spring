package fr.iocean.dta.exception;

public class EmployeeErrorException extends RuntimeException {

	private static final long serialVersionUID = 5195080787271600925L;

	public EmployeeErrorException(String message) {
		super(message);
	}

}
