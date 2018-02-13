package com.atguigu.spring.aop.helloworld;

public class Main {


    public static void main(String[] args) {
//        ArithmeticCalculatorLoggingImpl arithmeticCalculator = null;
//        arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();

        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        System.out.println(proxy.getClass().getName());
        System.out.println(proxy instanceof ArithmeticCalculator);
        int result = proxy.add(1, 2);
        System.out.println("-->" + result);

        result = proxy.div(4, 2);
        System.out.println("-->" + result);
    }
}
