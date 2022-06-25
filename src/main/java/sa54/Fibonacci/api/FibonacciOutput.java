package sa54.Fibonacci.api;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FibonacciOutput {
	List<BigInteger> fibonacci;
	List<BigInteger> sorted;
	
	public FibonacciOutput(List<BigInteger> fibonacci,List<BigInteger> sorted) {
		super();
		this.sorted = sorted;
		this.fibonacci = fibonacci;
	}
	public FibonacciOutput() {
		super();
	}
	
	@JsonProperty
	public List<BigInteger> getSorted() {
		return sorted;
	}
	@JsonProperty
	public void setSorted(List<BigInteger> sorted) {
		this.sorted = sorted;
	}
	@JsonProperty
	public List<BigInteger> getFibonacci() {
		return fibonacci;
	}
	@JsonProperty
	public void setFibonacci(List<BigInteger> fibonacci) {
		this.fibonacci = fibonacci;
	}
}
