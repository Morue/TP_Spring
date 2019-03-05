package fr.iocean.dta.exception;

public class NoEmployeeException extends RuntimeException {

	private static final long serialVersionUID = 152630840661453900L;
	
	public NoEmployeeException(String message) {
		super(message);
	}

}
