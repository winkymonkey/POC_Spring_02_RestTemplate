package org.example.spring.web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonService personService = applicationContext.getBean(PersonService.class);
		
		System.out.println("*****Get all person*****");
		personService.getAllPerson();
		
		System.out.println("*****Get person by Id*****");
		personService.getPersonById(2L);
		
		System.out.println("*****Add person*****");
		Person person = new Person();
		person.setAge(50);
		person.setFirstName("David");
		person.setLastName("Blain");
		personService.addPerson(person);
		
		applicationContext.close();
	}	
}
