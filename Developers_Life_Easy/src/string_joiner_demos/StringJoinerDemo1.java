package string_joiner_demos;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerDemo1
{
   public static void main(String[] args)
   {


	StringJoiner sj = new StringJoiner(",");
        	sj.add("aaa");
        	sj.add("bbb");
        	sj.add("ccc");
        	String result = sj.toString(); //aaa,bbb,ccc
        	
        	System.out.println(result);


	//Join String by a delimiter and starting with a supplied prefix and ending with a supplied suffix.

	StringJoiner sj1 = new StringJoiner("/", "prefix-", "-suffix");
        	sj1.add("2016");
        	sj1.add("02");
        	sj1.add("26");
        	String result2 = sj1.toString(); //prefix-2016/02/26-suffix
        	System.out.println(result2);



 	//Collectors.joining
	//Two Stream and Collectors.joining examples.

	//Join List<String> example.

	List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");

	//java | python | nodejs | ruby
	String result3 = list.stream().map(x -> x).collect(Collectors.joining(" | "));

             System.out.println(result3);
     }
}