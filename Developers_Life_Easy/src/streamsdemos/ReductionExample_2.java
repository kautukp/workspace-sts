package streamsdemos;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ReductionExample_2 {

    public static void main(String... args) {
        
        List<Integer> list = Arrays.asList(-10,-8);
        
        Integer red = 
        list.stream()
                .reduce(0,Integer::max);    // return type of .reduce(Integer::max);  ?
        
        System.out.println("red = " + red);
        
    }
}

