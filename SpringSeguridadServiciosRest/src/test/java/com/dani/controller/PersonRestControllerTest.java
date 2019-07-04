package com.dani.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;

import com.dani.exception.PersonException;
import com.dani.model.Person;

public class PersonRestControllerTest {

	private PersonRestController personRestControllerSUT;
	private Principal principalTD;
	
	@Before
	public void init() {
		personRestControllerSUT = new PersonRestController();
		principalTD = mock(Principal.class);
	}
	
	@Test
	public void shouldReturnPersonWithId() throws PersonException{
		Person person = personRestControllerSUT.obtainPersonDetails(principalTD, 1L);
		
		assertThat(person.getId(), is(1L));
		assertThat(person.getName(), is("Pepe"));
		assertThat(person.getSurname(), is("Ruiz"));
		assertThat(person.getPhoneNumber(), is("666-555-444"));
		
	}
	
	@Test(expected = PersonException.class)
	public void shouldThrowPersonExceptionWhenPersonIsNotFound() throws PersonException{
		personRestControllerSUT.obtainPersonDetails(principalTD, 3L);
		
		fail("Person with ID:3 should have not been found");
	}
}
