package demo;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

import java.util.function.Supplier;

public class Ex05 {
    public static void main(String[] args) {
        // Constructor reference

        Supplier<Apple>  supplier = Apple::new;
        Apple a1 = supplier.get();

        System.out.println(a1);

        // Full constructor :: Integer id, String color, Double weight , String country -> new Apple( id,  color,  weight , country)
        // = Apple :: new

       /** BuFunction<Apple,Integer,String,Double,String> buFunction = new BuFunction<Apple, Integer, String, Double, String>() {
            @Override
            public Apple get(Integer id, String color, Double weight , String country) {
                return new Apple(id,color,weight,country);
            }
        };

        Apple a2 = buFunction.get(1,"black",12d,"VietNam ");
        System.out.println(a2);
        */

       // Lambda express
       /** BuFunction<Apple,Integer,String,Double,String> buFunction = (Integer id, String color, Double weight , String country) ->  {
            return  new Apple(id, color,weight,country);
        };
        */
        BuFunction<Apple,Integer,String,Double,String> buFunction = Apple::new;
        Apple a2 = buFunction.get(1,"black",12d,"VietNam ");
        System.out.println(a2);

        System.out.println("-----------------------------");

        BiFunction<Apple,Integer ,String> biFunction = Apple::new;
        Apple a3 = biFunction.get(007,"Lào");
        System.out.println(a3);

    }
}
