package generic;

public class Ex01 {
    public static void main(String[] args) {
        // generic represents for object type only

        Integer[] ints = {1,2,3,4,5,6};

        Double[] doubles = {1d,2d,3d,4d,5d,6d};

        Float[] floats = {1f,2f,3f,4f,5f,6f};
        String[]  strings ={"a","b","c","d"};

        printf(ints);
        printf(doubles);
        printf(floats);
        // printf(strings);


    }

    private static <E extends Number> void printf(E[] element){
        for (E elements : element){
            System.out.print(elements+ " ");
        }
        System.out.println();
    }
}
