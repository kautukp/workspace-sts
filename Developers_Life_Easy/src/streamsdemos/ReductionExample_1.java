package streamsdemos;

import java.util.Arrays;
import java.util.List;

public class ReductionExample_1 {
	
	
	public static void main(String[] args) {
		
		//List<Integer> list=Arrays.asList(10,10,10);
		List<Integer> list=Arrays.asList();// check with 1 and 2 parameters
		
		Integer red =
		list.stream()
		    .reduce(0,Integer::sum);				//reduce(0,(i1,i2)->i1+i2);
		
		System.out.println("red = "+red);
		
	}

}
