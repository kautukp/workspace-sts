package streamsdemos;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ReductionExample_3 {

    public static void main(String... args) {
        
        List<Integer> list = Arrays.asList();
     //   List<Integer> list = Arrays.asList(-10,-8);
        Optional<Integer> red =     //Optional:needed because default values can't be always defined
        list.stream()
                .reduce(Integer::max);
        
        System.out.println("red = " + red);
        System.out.println("red = " + red.get());
        
    }
}

