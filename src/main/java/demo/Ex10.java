package demo;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Ex10 {

    public static void main(String[] args) {
        List<String>  s1 = Arrays.asList("a","b","c");
        List<String>  s2 = Arrays.asList("I","II","III");
        List<String>  s3 = Arrays.asList(".","*","^");

        List<List<String>> s = Arrays.asList(s1,s2,s3);

           s.stream()
                .flatMap(Collection::stream)
                .filter(item -> item.matches("[a-z]+"))
                .forEach(System.out::println);

        System.out.println("=============");
        int[][] arr = {{1,2,3},{2,4,6},{11,20,30}};
        Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)// arrays -> Arrays.stream(arrays) == Arrays::stream
                .filter(item -> item % 2 ==0)
                .sorted()
                .forEach(System.out::println);

        System.out.println("===================");

        System.out.println("The stream after applying "
                + "the function is : ");

        // Creating a list of Strings
        List<String> list = Arrays.asList("Geeks", "FOR", "GEEKSQUIZ",
                "Computer", "Science", "gfg");

        // Using Stream map(Function mapper) and
        // displaying the length of each String
        list.stream().map(String::length).forEach(System.out::println);




    }


}
