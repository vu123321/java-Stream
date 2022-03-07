package demo;

import bean.Apple;


// class Ex03 >> contains method main,
public class Ex03 {
    public static void main(String[] args) {
        final  int a = 10;
        // a =20; // not allowed

        final Apple b = new Apple();
        final Apple c = new Apple();
        // b = c >> not allowed

        b.setColor("yellow"); // allowed

        // final >> primitive: cannot reassign value
        // final >> object   : cannot reassign reference's address
        Runnable runnable = running(2000);
        runnable.run();
    }

    private static  Runnable running(int time ){
        String job = "Queue Job";
        Apple jobDetail = new Apple(1,"black",100,"Lao");

        // anonymous class
        return  new Runnable() {
            @Override
            public void run() {
                // local variable
                // inner scope
                // even those variable are cleared after finish outer function
                //  nonlocal variable are explicitly final >> From version 1.8.

                jobDetail.setColor("While");
                System.out.println(job+" is running about "+time+ "ms");
                System.out.println("jobDetail: "+jobDetail);
            }
        };
    }
}

