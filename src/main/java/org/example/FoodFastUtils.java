package org.example;

public class FoodFastUtils {
    public static String deliveryPlanner(int n) {
        if(n%3 == 0) {
            System.out.println("Fizz !");
        }
        else if(n%5 == 0) {
            System.out.println("Buzz !");
        }
        else if(n%2 == 0) {
            System.out.println("FizzBuzz !");
        }else{
            System.out.println(n);
        }
        return "";
    }
}
