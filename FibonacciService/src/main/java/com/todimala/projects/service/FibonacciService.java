package com.todimala.projects.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.todimala.projects.service.InvalidInputException;

@Service
public class FibonacciService {

public int getNFibonacciNum(Integer count) throws Exception {
		
		if (count <= 0) {
			throw new InvalidInputException(count);
		}
				
		int i = 0, j = 1, k=0;
		if (count == 1) {
			return 0;
		}
		if (count == 2) {
			return 1;
		}
		count=count-2;
		while (count>0) {
			count--;
			k = i + j;
			i = j;
			j = k;
		}
		
		return k;	
	}
	

	public List<Integer> getFibonacciSeries(Integer count) throws Exception {
		
		if (count <= 0) {
			throw new InvalidInputException(count);
		}
		
		List<Integer> series = new ArrayList<Integer>(count);
		
		int i = 0, j = 1, k;
		if (count >= 1) {
			series.add(0);
		}
		if (count >= 2) {
			series.add(1);
		}
		count=count-2;
		while (count>0) {
			count--;
			k = i + j;
			i = j;
			j = k;
			series.add(k);
		}
		
		return series;		
	}

}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException(int n) {
		super("The user input is '" + n + "'. Give a positive number.");
	}
}
