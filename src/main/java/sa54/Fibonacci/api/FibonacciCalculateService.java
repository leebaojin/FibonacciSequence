package sa54.Fibonacci.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FibonacciCalculateService {
	
	public BigInteger[] getFibonacci(int elements){
		if(elements == 0) {
			//No elements
			return null;
		}
		BigInteger[] fiboarray = new BigInteger[elements];
		calculateFibo(elements, fiboarray);
		return fiboarray;
	}
	
	private BigInteger calculateFibo(int elements, BigInteger[] arr) {
		//Using recursive to populate array
		if(elements == 1) {
			arr[0] = new BigInteger("0");
			return arr[0];
		}
		else if(elements == 2) {
			arr[1] = new BigInteger("1");
			return arr[1];
		}
		else if(arr[elements-1] != null) {
			return arr[elements-1];
		}
		
		BigInteger result = calculateFibo(elements-1,arr).add(calculateFibo(elements-2,arr));
		arr[elements-1] = result;
		return result;
	}
	
	public List<BigInteger> sortFibo(BigInteger[] fiboarray){
		//Get even numbers
		List<BigInteger> evenNumList = new ArrayList<>();
		
		//Get Odd numbers
		List<BigInteger> oddNumList = new ArrayList<>();
		
		//Populate list
		for(int i = 0; i < fiboarray.length; i++) {
			if(fiboarray[i].remainder(new BigInteger("2")).equals(new BigInteger("0"))) {
				evenNumList.add(fiboarray[i]);
			}
			else {
				oddNumList.add(fiboarray[i]);
			}
		}
		
		evenNumList = evenNumList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		oddNumList = oddNumList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		//Add the list together
		evenNumList.addAll(oddNumList);
		return evenNumList;
	}

}
