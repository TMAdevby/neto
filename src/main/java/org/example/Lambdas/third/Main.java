package org.example.Lambdas.third;

public class Main {
    public static void main(String[] args) {
        OnDoneListener listener = (v) -> System.out.println(v);
        Test test = new Test(listener);
        test.execute();
    }
}
