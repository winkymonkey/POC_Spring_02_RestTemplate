package org.example.spring.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PersonService {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String URL = "http://localhost:8091/remoteApp/person";
	

	public void getAllPerson() {
		ResponseEntity<Person[]> response = restTemplate.getForEntity(URL, Person[].class);
		List<Person> personList = Arrays.asList(response.getBody());
		personList.forEach(person -> System.out.println(person));
	}

	public void getPersonById(Long id) {
		ResponseEntity<Person> response = restTemplate.getForEntity(URL+"/"+id, Person.class);
		Person person = response.getBody();
		System.out.println(person);
	}

	public void addPerson(Person person) {
		ResponseEntity<String> response = restTemplate.postForEntity(URL, person, String.class);
		HttpStatus status = response.getStatusCode();
		System.out.println(status);
	}

	public void updatePerson(Person person) {
		restTemplate.put(URL, person);
	}

	public void deletePerson(Long id) {
		restTemplate.delete(URL + id);
	}
	
}
