package fr.iocean.dta.service;

import org.springframework.stereotype.Service;

import fr.iocean.dta.model.Employee;

@Service
//@Scope(value = "prototype")
public class MailService {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void sendMail(Employee e) {
		System.out.println("wesh" + e.getPrenom() + ", " + message);
	}
}
