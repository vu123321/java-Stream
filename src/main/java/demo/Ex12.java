package demo;

import functional.Calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Ex12 {
    public static void main(String[] args) {
        // Operations: add, subtract,multiply,divide,max , mix, average of stream elements
        // AutoBoxing, Auto Unboxing
        List<Integer> digit = Arrays.asList(1,3,5,7,88,99);


        // traditional way : cach truyen thong
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (Integer integer : digit) {
            sum += integer;
            if (max < integer ){
                max = integer;
            }
        }
        System.out.println("max: "+max);
        System.out.println("sum: "+sum);


        System.out.println("==============");
        // Stream way >> reduce

        /** int total = operation(0, digit, new Calculator() {
            @Override
            public Integer perform(Integer a, Integer b) {
                return a + b;
            }
        });*/
        int maximum = operation(Integer.MIN_VALUE,digit,(a ,b) -> a > b ? a : b);
        int minimum = operation(Integer.MAX_VALUE,digit,Integer::min);
        int total = operation(0 ,digit, Integer::sum); //(a , b) -> a + b Integer::sum
        System.out.println("total: "+total);
        System.out.println("maximum: "+maximum);
        System.out.println("minimum: "+minimum);

        System.out.println("=================");
        int totalAll = digit.stream().reduce(0,Integer::sum);
        int minDigits = digit.stream().reduce(Integer.MAX_VALUE,Integer::min);
        int maxDigits = digit.stream().reduce(Integer.MIN_VALUE,Integer::max);

        System.out.println("totalAll: "+totalAll);
        System.out.println("minDigits: "+minDigits);
        System.out.println("maxDigits: "+maxDigits);
        System.out.println("=======Reduce none Initial  =======");
        Optional<Integer> opt = digit.stream().reduce(Integer::max);
        opt.ifPresent(value -> System.out.println("max: "+value));
        if (opt.isPresent()){
            System.out.println("max: "+opt.get());
        }

    }
    private static Integer operation(Integer initial , List<Integer> digits, Calculator c) {
        Integer result = initial;
        for (Integer digit : digits) {
            // sum >> result = result + digit
            initial += digit;
            // max >> result = digit > result ? digit : result
            // min >> result = digit < result ? digit : result

            result = c.perform(result,digit);
        }
        return result;

    }


}
