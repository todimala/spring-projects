package com.todimala.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todimala.projects.service.FibonacciService;

@RestController
@RequestMapping(value = "/fibonacci")
public class FibonacciController {

	@Autowired
	FibonacciService fibonacciService;
	
	@RequestMapping(value="/getElement", method = RequestMethod.GET) 
	public int getNFibonacciNum(@RequestParam(value = "count", required=false, defaultValue = "1") Integer count) throws Exception {		
		return fibonacciService.getNFibonacciNum(count);	
	}
	
	@RequestMapping(value="/getSeries", method = RequestMethod.GET)
	public List<Integer> getFibonacciSeries(@RequestParam(value = "count", required=false, defaultValue = "5") Integer count) throws Exception {
		return fibonacciService.getFibonacciSeries(count);		
	}
}


