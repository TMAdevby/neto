package org.example.Lambdas.first;

public class Main {
    public static void main(String[] args) {
        //Calc calc = new Calc(); через класс реализующий интерфейс

        /*ISum summer = new ISum(){
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };*/ // через анонимный класс

        ISum fn1 = (a, b) -> a + b;
        ISum fn2 = (a, b) -> a - b;
        ISum fn3 = (a, b) -> a * b;
        ISum fn4 = (a, b) -> a / b;

        System.out.println(fn1.fn(3, 2));
        System.out.println(fn2.fn(3, 2));
        System.out.println(fn3.fn(3, 2));
        System.out.println(fn4.fn(3, 2));
    }
}

@FunctionalInterface
interface ISum {
    int fn(int a, int b);
}

/*  через класс реализующий интерфейс
class Calc implements ISum {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}*/
