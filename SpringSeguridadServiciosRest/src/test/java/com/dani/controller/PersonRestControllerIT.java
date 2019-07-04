package com.dani.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.dani.app.Application;
import com.dani.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class PersonRestControllerIT {
	
	@Value("${local.server.port}")
	private int port;
	
	private RestTemplate restTemplate = new TestRestTemplate("user", "pass"); 

	@Test
    public void shouldReturnPersonDetails() {

        final ResponseEntity<Person> response = restTemplate.getForEntity(getBaseUrl() + "/person/{id}", Person.class, 1L);
        final Person person = response.getBody();

        assertThat(person.getId(), is(1L));
        assertThat(person.getName(), is("Pepe"));
        assertThat(person.getSurname(), is("Ruiz"));
        assertThat(person.getPhoneNumber(), is("666-555-444"));
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
    @Test
    public void shouldNotFindPersonDetailsWhenIdNotFound() {

        final ResponseEntity<Person> response = restTemplate.getForEntity(getBaseUrl() + "/person/{id}", Person.class, 3L);
        final Person person = response.getBody();

        assertThat(person, nullValue());
        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

    private String getBaseUrl() {
        return new StringBuilder("http://localhost:").append(port).toString();
    }

}
