package com.dani.exception;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PersonExceptionTest {

    private PersonException personExceptionSUT = new PersonException();

    @Test
    public void shouldExtendException() {
        assertThat(personExceptionSUT instanceof Exception, is(true));
    }

    @Test
    public void shouldHaveConstructorWithParams() {

        personExceptionSUT = new PersonException("Message");

        assertThat(personExceptionSUT.getMessage(), notNullValue());
    }
}