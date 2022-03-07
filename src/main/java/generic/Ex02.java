package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
        List<Double> doubleListList = Arrays.asList(1d,2d,3d,4d,5d,6d);
        List<Float> floats = Arrays.asList(1f,2f,3f,4f,5f,6f);
        List<String> stringList = Arrays.asList("a", "b", "c", "d", "e");
        List<Number> numberList = Arrays.asList(1d,2f,3);
        List<CharSequence> sequences = Arrays.asList("x","y");

        printf(intList);
//        printf(doubleListList);
//        printf(floats);
//        printf(stringList);

    }

    /**private static <E extends  CharSequence> void printf(List<E> elements){
        for (Object object : elements){
            System.out.print(object+" ");
        }
        System.out.println();
    }*/

    private static  void printf(List<? super  Integer> elements) {
        for (Object object : elements) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}
