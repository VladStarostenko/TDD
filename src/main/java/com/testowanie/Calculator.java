package com.testowanie;
import com.sun.org.apache.bcel.internal.generic.RET;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class Calculator {

    public static double sum(double x, double y){
        return x + y;
    }

    public static double subtraction(double x, double y){
        return x - y;
    }

    public static double multiplication(double x, double y){
        return x * y;
    }

    public static double division(double x, double y){
        return x / y;
    }

    public static double computeCircleArea(double radius){
        if(radius < 0 ){
            System.out.println("Radius must be positive");
            return Infinity;
        }
        return Math.PI * radius * radius;
    }

    public static double computeRectangleArea(double x, double y){
        if(x < 0 || y < 0){
            System.out.println("Parameters must be positive");
            return Infinity;
        }
        return x * y;
    }

    public static double logarithmE(int x){
        if( x <= 0 ){
            System.out.println("Parameter must be positive");
            return Infinity;
        }
        return Math.log(x);
    }

    public static double logarithm(int x, int y){
        if(x <= 0 || x == 1 || y <= 0){
            System.out.println("Parameters must be positive");
            return Infinity;
        }
        double y1 = Math.log(y);
        double x1 = Math.log(x);
        return y1 / x1;
    }

    public static double [] quadraticEquation(double x1, double x2, double x3, double y) {
        double [] answers = new double[2];
        x3 = x3 - y;
        double d = x2 * x2 - 4 * x1 * x3;
        if(d < 0){
            System.out.println("No real solutions.");
            return new double[]{Infinity};
        }
        answers[0] = (0 - x2 + Math.sqrt(d)) / (2 * x1);
        answers[1] = (0 - x2 - Math.sqrt(d)) / (2 * x1);
        Arrays.sort(answers);
        return answers;
    }

    static double bigDecimal(double x) {
        BigDecimal bd = new BigDecimal(x).setScale(5, RoundingMode.HALF_UP);
        double xNew = bd.doubleValue();
        return xNew;
    }

    static double acosh(double x) {
        return Math.log(x + Math.sqrt(x*x - 1.0));
    }

    public static double [] cubicEquation(double x1, double x2, double x3, double x4, double y) {
        double [] answers = new double[3];
        x4 = x4 - y;
        if( x1 != 1) {
            x2 = x2 / x1;
            x3 = x3 / x1;
            x4 = x4 / x1;
            x1 = 1;
        }
        double q = (x2 * x2 - 3 * x3) / 9;
        double r = (2 * x2 * x2 * x2 - 9 * x2 * x3 + 27 * x4) / 54;
        double s = q * q * q - r * r;

        if(s > 0){
            double d = Math.acos(r / (Math.sqrt(q * q * q))) / 3;
            answers[0] = 0 - 2 * Math.sqrt(q) * Math.cos(d) - x2 / 3;
            answers[1] = 0 - 2 * Math.sqrt(q) * Math.cos(d + 2 * Math.PI / 3) - x2 / 3;
            answers[2] = 0 - 2 * Math.sqrt(q) * Math.cos(d - 2 * Math.PI / 3) - x2 / 3;
        }else if( s < 0 && q > 0){
            System.out.println("Just one real solution");
            double d = acosh(Math.abs(r)/Math.sqrt(Math.abs(q)*Math.abs(q)*Math.abs(q))) / 3;
            double answer = 0 - 2 * Math.signum(r) * Math.sqrt(q) * Math.cosh(d) - x2/3;
            answer = bigDecimal(answer);
            return new double[]{answer};
        }else if( s < 0 && q < 0){
            System.out.println("Just one real solution");
            double d = acosh(Math.abs(r)/Math.sqrt(Math.abs(q)*Math.abs(q)*Math.abs(q))) / 3;
            double answer = 0 - 2 * Math.signum(r) * Math.sqrt(q) * Math.sinh(d) - x2/3;
            answer = bigDecimal(answer);
            return new double[]{answer};
        }
        for (int i = 0; i < answers.length; i ++) {
            answers[i] = bigDecimal(answers[i]);
        }
        Arrays.sort(answers);
        return answers;
    }

    public static void main(String[] args) {
        System.out.println("1. Sum \n2. Subtraction \n3. Multiplication \n4. Division \n5. Compute Circle Area " +
                "\n6. Compute Rectangle Area \n7. Natural Logarithm \n8. Logarithm \n9. Quadratic Equation " +
                "\n10. Cubic Equation");
        System.out.println(" Please, enter the number of function:");
        Scanner in = new Scanner(System.in);
        int fun = in.nextInt();

        double result = 0;
        double [] results;

        if(fun == 1){
            System.out.println("Please, enter two parameters");
            double x = in.nextDouble();
            double y = in.nextDouble();
            result = sum(x,y);
        }else if(fun == 2){
            System.out.println("Please, enter two parameters");
            double x = in.nextDouble();
            double y = in.nextDouble();
            result = subtraction(x,y);
        }else if(fun == 3){
            System.out.println("Please, enter two parameters");
            double x = in.nextDouble();
            double y = in.nextDouble();
            result = multiplication(x,y);
        }else if(fun == 4){
            System.out.println("Please, enter two parameters");
            double x = in.nextDouble();
            double y = in.nextDouble();
            result = division(x,y);
        }else if(fun == 5) {
            System.out.println("Please, enter radius");
            double radius = in.nextDouble();
            result = computeCircleArea(radius);
        }else if(fun == 6){
            System.out.println("Please, enter two parameters");
            double x = in.nextDouble();
            double y = in.nextDouble();
            result = computeRectangleArea(x,y);
        }else if(fun == 7) {
            System.out.println("Please, enter one parameter");
            int x = in.nextInt();
            result = logarithmE(x);
        }else if(fun == 8){
            System.out.println("Please, enter two parameters");
            int x = in.nextInt();
            int y = in.nextInt();
            result = logarithm(x,y);
        }else if(fun == 9){
            System.out.println("Please, enter a, b, c and y parameters");
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            double y = in.nextDouble();
            results = quadraticEquation(a,b,c,y);
            System.out.println("x1 = " + results[0] + " x2 = " + results[1]);
        }else if(fun == 10){
            System.out.println("Please, enter a, b, c, d and y parameters");
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            double d = in.nextDouble();
            double y = in.nextDouble();
            results = cubicEquation(a,b,c,d,y);
            System.out.println("x1 = " + results[0] + " x2 = " + results[1] + " x3 = " + results[2]);
        } else{
            System.out.println("Function is incorrect");
        }
        System.out.println(result);
    }
}
