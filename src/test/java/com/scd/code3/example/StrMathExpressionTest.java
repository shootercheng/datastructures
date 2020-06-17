package com.scd.code3.example;

import org.junit.Assert;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.List;

/**
 * @author James
 */
public class StrMathExpressionTest {

    private static String formatResult(double input) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format(input);
    }

    private static String formatResult(float input) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format(input);
    }

    @Test
    public void testNegative() {
        String exp4 = "-2 / (-2) * (-3) + (4.1 + 5.2) * 2";
        List<String> inputList = StrMathExpression.convertInputList(exp4);
        List<String> postFixList = StrMathExpression.convertToPostfix(inputList);
        double result = StrMathExpression.calExp(postFixList);
        System.out.println(result);
        Assert.assertEquals("15.6", formatResult(result));
    }

    @Test
    public void testNegativeOperator() {
        String exp4 = "-2 / -2 * -3 + (4.1 + 5.2) * 2";
        List<String> inputList = StrMathExpression.convertInputList(exp4);
        List<String> postFixList = StrMathExpression.convertToPostfix(inputList);
        double result = StrMathExpression.calExp(postFixList);
        System.out.println(result);
        Assert.assertEquals("15.6", formatResult(result));
    }
}
