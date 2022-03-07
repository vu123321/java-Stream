package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
    public static void main(String[] args) {
        // 1, 2, 1, 4, 5, 8, 10, 4, 12
        int[] digits = {1, 2,15, 1, 16, 5, 8, 10, 4, 12};

        //1: is there any element that is divisible by 10

        boolean d10 = Arrays.stream(digits).anyMatch(i -> i % 10 == 0);
        System.out.println("d10: "+d10);

        //    2 : find the first element that is divisible by 4
        OptionalInt optionalInt = Arrays.stream(digits).filter(i -> i % 4 == 0).findFirst();
        System.out.println("d04: "+optionalInt);
        if (optionalInt.isPresent()){
            System.out.println("firstD4: "+optionalInt.getAsInt());
        }



        //      3: find the element that is divisible by 5 in the list

        OptionalInt optInt5 = Arrays.stream(digits).filter(i -> i % 5 == 0).findFirst();
        if (optionalInt.isPresent()){
            System.out.println("anyD5: "+optInt5.getAsInt());
        }

        //      4th: does all elements less than 100

        boolean d100 = Arrays.stream(digits).allMatch(i -> i < 100);
        System.out.println("d100: "+d100);

        //      5th: does no elements greater than 0 // kiem tra co phan tu nao < 0 phai khong : noneMatch

        boolean greater = Arrays.stream(digits).noneMatch(i -> i  < 0);
        System.out.println("greater: "+greater);
    }
}
