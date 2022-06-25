package sa54.Fibonacci.resources;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import sa54.Fibonacci.api.ElementRequest;
import sa54.Fibonacci.api.FibonacciCalculateService;
import sa54.Fibonacci.api.FibonacciOutput;
import sa54.Fibonacci.api.FibonacciOutputString;


@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class FiboResource {

	//using      java -jar target/FibonacciSequence-0.0.1-SNAPSHOT.jar server
	//Build     mvn package
    
    private FibonacciCalculateService fiboService;
    
    @Inject
	public FiboResource(FibonacciCalculateService fiboService) {
		super();
		this.fiboService = fiboService;
	}
	
	
    
    @POST
    public FibonacciOutput getFibo(ElementRequest eleRequest){
    	Integer elements = eleRequest.getElements();
		if(elements == null) {
			throw new WebApplicationException("Invalid input. No value", Status.REQUESTED_RANGE_NOT_SATISFIABLE);
			
		}else if(elements <= 0 || elements > 100) {
			throw new WebApplicationException("Invalid input. Number should be 1 to 100", Status.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
		BigInteger[] fiboArr = fiboService.getFibonacci(elements);
		List<BigInteger> sorted = fiboService.sortFibo(fiboArr);
		
		List<BigInteger>  fibonacci = Arrays.asList(fiboArr);
		
		return new FibonacciOutput(fibonacci, sorted);
    }
    
    @GET
    @Path("/{ele}")
    public FibonacciOutput getFiboByParam(@PathParam("ele") Integer elements){
		if(elements == null) {
			throw new WebApplicationException("Invalid input. No value", Status.REQUESTED_RANGE_NOT_SATISFIABLE);
			
		}else if(elements <= 0 || elements > 100) {
			throw new WebApplicationException("Invalid input. Number should be 1 to 100", Status.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
		BigInteger[] fiboArr = fiboService.getFibonacci(elements);
		List<BigInteger> sorted = fiboService.sortFibo(fiboArr);
		
		List<BigInteger>  fibonacci = Arrays.asList(fiboArr);
		
		return new FibonacciOutput(fibonacci, sorted);
    }
    
    @POST
    @Path("/string")
    public FibonacciOutputString getFiboStr(ElementRequest eleRequest){
    	Integer elements = eleRequest.getElements();
		if(elements == null) {
			throw new WebApplicationException("Invalid input. No value", Status.REQUESTED_RANGE_NOT_SATISFIABLE);
			
		}else if(elements <= 0 || elements > 100) {
			throw new WebApplicationException("Invalid input. Number should be 1 to 100", Status.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
		BigInteger[] fiboArr = fiboService.getFibonacci(elements);
		List<BigInteger> sorted = fiboService.sortFibo(fiboArr);
		
		List<BigInteger>  fibonacci = Arrays.asList(fiboArr);
		
		return FibonacciOutputString.Create(fibonacci, sorted);
    }
    
    

}
