package com.todimala.projects.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.todimala.projects.FibonacciServiceApplication;
import com.todimala.projects.service.FibonacciService;

@SpringApplicationConfiguration(FibonacciServiceApplication.class)
@WebAppConfiguration
public class FibonacciControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	@Mock
	private FibonacciService service;
	
	@Autowired
	@InjectMocks
	private FibonacciController controller;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}
	
	@Test
	public void getFirstFibonacciElement() throws Exception {
		when(this.service.getNFibonacciNum(1))
			.thenReturn(0);
		
		MockHttpServletRequestBuilder request = get("/getFiboElement");
			request.param("count", "1");
			
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string("0"));
	}
	
	@Test
	public void getSecondFibonacciElement() throws Exception {
		when(this.service.getNFibonacciNum(2))
			.thenReturn(1);
		
		MockHttpServletRequestBuilder request = get("/getFiboElement");
			request.param("count", "2");
			
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string("1"));
	}
	
	@Test
	public void getFifthFibonacciElement() throws Exception {
		when(this.service.getNFibonacciNum(5))
			.thenReturn(3);
		
		MockHttpServletRequestBuilder request = get("/getFiboElement");
			request.param("count", "5");
			
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string("3"));
	}
	
}
