package br.com.livelo.login.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UtilTest {
	
	@Test
	public void validateTrueEmptyColletionTest() {
		List<String> listTeste = new ArrayList<String>();
		assertTrue(ValidateUtil.isNullOrEmpty(listTeste));
	}
	
	@Test
	public void validateTrueNullColletionTest() {
		List<String> listTeste = null;
		assertTrue(ValidateUtil.isNullOrEmpty(listTeste));
	}

	@Test
	public void validateFalseColletionTest() {
		List<String> listTeste = new ArrayList<String>();
		listTeste.add("String");
		assertFalse(ValidateUtil.isNullOrEmpty(listTeste));
	}
	
	@Test
	public void parseDateToStringDateNullTest() {
		assertEquals(null,Util.parseDateToString(null)); 
	}
	
	@Test
	public void parseStringToZonedDateTimeNullTest() {
		assertEquals(null,Util.parseStringToZonedDateTime(null)); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void parseStringToZonedDateTimeExceptionTest() {
		Util.parseStringToZonedDateTime("data");
	}
	
}
