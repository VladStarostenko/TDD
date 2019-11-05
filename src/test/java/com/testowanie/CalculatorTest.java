package com.testowanie;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void sum() {
        double expected = 2;
        double actual = calculator.sum(1,1);
        assertEquals(expected, actual, "The sum method sum two numbers");
    }

    @Test
    void sum2() {
        double expected = -2;
        double actual = calculator.sum(-1,-1);
        assertEquals(expected, actual, "The sum method sum two numbers");
    }

    @Test
    void subtraction() {
        double expected = 1;
        double actual = calculator.subtraction(2,1);
        assertEquals(expected, actual, "The subtraction method subtract two numbers");
    }

    @Test
    void subtraction2() {
        double expected = -1;
        double actual = calculator.subtraction(-2,-1);
        assertEquals(expected, actual, "The subtraction method subtract two numbers");
    }

    @Test
    void multiplication() {
        double expected = 10;
        double actual = calculator.multiplication(2,5);
        assertEquals(expected, actual, "The multiplication method multiply two numbers");
    }

    @Test
    void multiplication2() {
        double expected = 0;
        double actual = calculator.multiplication(0,5);
        assertEquals(expected, actual, "The multiplication method multiply two numbers");
    }

    @Test
    void division() {
        double expected = 2;
        double actual = calculator.division(10,5);
        assertEquals(expected, actual, "The division method divide two numbers");
    }

    @Test
    void division2() {
        double expected = 0;
        double actual = calculator.division(0,5);
        assertEquals(expected, actual, "The division method divide two numbers");
    }

    @Test
    void division3() {
        double actual = calculator.division(1,0);
        assertEquals(Infinity, actual, "The division method divide two numbers");
    }

    @Test
    void computeCircleArea() {
        double expected = 314.1592653589793;
        double actual = calculator.computeCircleArea(10);
        assertEquals(expected, actual, "The computeCircleArea method return circle area");
    }

    @Test
    void computeCircleArea1() {
        double expected = 0;
        double actual = calculator.computeCircleArea(0);
        assertEquals(expected, actual, "The computeCircleArea method return circle area");
    }

    @Test
    void computeCircleArea2() {
        double expected = Infinity;
        double actual = calculator.computeCircleArea(-5);
        assertEquals(expected, actual, "The computeCircleArea method return circle area");
    }

    @Test
    void computeRectangleArea() {
        double expected = 24;
        double actual = calculator.computeRectangleArea(4,6);
        assertEquals(expected, actual, "The computeRectangleArea method return rectangle area");
    }

    @Test
    void computeRectangleArea1() {
        double expected = 0;
        double actual = calculator.computeRectangleArea(4,0);
        assertEquals(expected, actual, "The computeRectangleArea method return rectangle area");
    }

    @Test
    void computeRectangleArea2() {
        double expected = Infinity;
        double actual = calculator.computeRectangleArea(4,-6);
        assertEquals(expected, actual, "The computeRectangleArea method return rectangle area");
    }

    @Test
    void logarithmE() {
        double expected = 2.302585092994046;
        double actual = calculator.logarithmE(10);
        assertEquals(expected, actual, "The logarithmE method return natural logarithm");
    }

    @Test
    void logarithmE1() {
        double expected = Infinity;
        double actual = calculator.logarithmE(0);
        assertEquals(expected, actual, "The logarithmE method return natural logarithm");
    }

    @Test
    void logarithmE2() {
        double expected = Infinity;
        double actual = calculator.logarithmE(-10);
        assertEquals(expected, actual, "The logarithmE method return natural logarithm");
    }

    @Test
    void logarithm() {
        double expected = 2;
        double actual = calculator.logarithm(3,9);
        assertEquals(expected,actual,"The logarithm method return logarithm");
    }

    @Test
    void logarithm1() {
        double expected = Infinity;
        double actual = calculator.logarithm(0,9);
        assertEquals(expected,actual,"The logarithm method return logarithm");
    }

    @Test
    void logarithm2() {
        double expected = Infinity;
        double actual = calculator.logarithm(1,9);
        assertEquals(expected,actual,"The logarithm method return logarithm");
    }

    @Test
    void logarithm3() {
        double expected = Infinity;
        double actual = calculator.logarithm(3,-1);
        assertEquals(expected,actual,"The logarithm method return logarithm");
    }

    @Test
    void quadraticEquation() {
        double [] expected =  {-1, 0.6428571428571429};
        double [] actual = calculator.quadraticEquation(14, 5, 0, 9);
        assertArrayEquals(expected,actual,"The quadraticEquation method return solutions of quadratic equation");
    }

    @Test
    void quadraticEquation1() {
        double [] expected = new double[]{Infinity};
        double [] actual = calculator.quadraticEquation(14, 1, 5, 0);
        assertArrayEquals(expected,actual,"The quadraticEquation method return solutions of quadratic equation");
    }

    @Test
    void cubicEquation() {
        double [] expected =  {-3, 1, 2};
        double [] actual = calculator.cubicEquation(1, 0, -7, 6, 0);
        assertArrayEquals(expected,actual,"The cubicEquation method return solutions of cubic equation");
    }

    @Test
    void cubicEquation1() {
        double [] expected =  {-20.35832};
        double [] actual = calculator.cubicEquation(1, 20, -7, 6, 0);
        assertArrayEquals(expected,actual,"The cubicEquation method return solutions of cubic equation");
    }
}