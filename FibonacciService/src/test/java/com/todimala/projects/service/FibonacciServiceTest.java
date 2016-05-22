package com.todimala.projects.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FibonacciServiceTest {

	private FibonacciService service;
	
	@Before
	public void Setup() {
		service = new FibonacciService();
	}
	
	@Test
	public void getFirstFibonacciElement() throws Exception {
		assertEquals(0, this.service.getNFibonacciNum(1));
	}

	@Test
	public void getSecondFibonacciElement() throws Exception {
		assertEquals(1, this.service.getNFibonacciNum(2));
	}
	
	@Test
	public void getFifthFibonacciElement() throws Exception {
		assertEquals(3, this.service.getNFibonacciNum(5));
	}
}
