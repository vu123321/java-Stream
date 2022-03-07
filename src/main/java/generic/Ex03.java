package generic;

import java.util.function.Predicate;

public class Ex03 {
    public static void main(String[] args) {
        IList<String> sequences = new JavaList<>();
        sequences.add("how are you");
        sequences.add("how are you");
        sequences.add("how are you");
        sequences.add("stay safe and take care");
        sequences.add("stay safe and take care");
        sequences.add("stay safe and take care");


        System.out.println("===============");
        System.out.println(sequences.size());
        sequences.show();

//        Condition<String > condition = new Condition<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("stay");
//            }
//        };

        Predicate<String> condition = e -> e.startsWith("how");
        int cont = sequences.count(condition );

        System.out.println("---------------------");
        System.out.println("count: "+cont);

    }
}
