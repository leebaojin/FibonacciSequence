package sa54.Fibonacci.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciOutputString {
	List<String> fibonacci;
	List<String> sorted;
	
	
	public FibonacciOutputString(List<String> fibonacci, List<String> sorted) {
		super();
		this.fibonacci = fibonacci;
		this.sorted = sorted;
	}
	
	public static FibonacciOutputString Create(List<BigInteger> fibonacciList, List<BigInteger> sortedList) {
		
		List<String> fibonacci = new ArrayList<String>();
		for(BigInteger x : fibonacciList) {
			fibonacci.add(x.toString());
		}
		
		List<String> sorted = new ArrayList<String>();
		for(BigInteger x : sortedList) {
			sorted.add(x.toString());
		}
		return new FibonacciOutputString(fibonacci, sorted);
	}
	
	public FibonacciOutputString() {
		super();
	}
	public List<String> getFibonacci() {
		return fibonacci;
	}
	public void setFibonacci(List<String> fibonacci) {
		this.fibonacci = fibonacci;
	}
	public List<String> getSorted() {
		return sorted;
	}
	public void setSorted(List<String> sorted) {
		this.sorted = sorted;
	}

}
