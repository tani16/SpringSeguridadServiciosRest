package com.dani.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private Person personSUT;
    private Person personSUT2;

    @Before
    public void init() {
        personSUT = new Person(1L, "Pepe", "Ruiz", "666-444-333");
        personSUT2 = new Person(2L, "Pepe", "Ruiz", "666-444-333");
    }

    @Test
    public void shouldEqualsAnotherPersona() {
        personSUT2.setId(1L);
        assertThat(personSUT.equals(personSUT2), is(true));
    }

    @Test
    public void shouldNotEqualsAnotherPersonaWhenDifferentNames() {
        assertThat(personSUT.equals(personSUT2), is(false));
    }

    @Test
    public void shouldNotHaveSameHashCode() {
        assertThat(personSUT.hashCode(), not(equalTo(personSUT2.hashCode())));
    }

    @Test
    public void shouldHaveSameHashCodeWhenSameIds() {
        personSUT2.setId(1L);
        assertThat(personSUT.hashCode(), equalTo(personSUT2.hashCode()));
    }

    @Test
    public void shouldHaveMethodAccessors() {
        assertThat(personSUT.getName(), is(notNullValue()));
        assertThat(personSUT.getSurname(), is(notNullValue()));
        assertThat(personSUT.getPhoneNumber(), is(notNullValue()));
    }

}