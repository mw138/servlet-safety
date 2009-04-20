package com.wesabe.servlet.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.servlet.BadResponseException;

@RunWith(Enclosed.class)
public class BadResponseExceptionTest {
	public static class Throwing_A_Bad_Response_Exception {
		private Exception cause;
		private HttpServletResponse response;
		private BadResponseException exception;

		@Before
		public void setup() throws Exception {
			this.response = mock(HttpServletResponse.class);
			
			this.cause = new Exception("on fire");
			this.exception = new BadResponseException(response, cause);
		}
		
		@Test
		public void itHasACause() throws Exception {
			assertEquals(cause, exception.getCause());
		}
		
		@Test
		public void itHasAMessage() throws Exception {
			assertEquals("Bad response", exception.getMessage());
		}
		
		@Test
		public void itHasABadResponse() throws Exception {
			assertSame(response, exception.getBadResponse());
		}
	}
}
