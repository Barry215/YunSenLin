package cn.maijinta.yunsenlin.utils;

import java.math.BigDecimal;

/**
 * Created by frank on 17/1/26.
 */

public class MathTool {

    public static BigDecimal getBigDecimal(double number){
        return new BigDecimal(number);
    }
    public static BigDecimal add(double num1, double num2) {
        BigDecimal first = getBigDecimal(num1);
        BigDecimal second = getBigDecimal(num2);
        return first.add(second);
    }
    public static BigDecimal subtract(double num1, double num2) {
        BigDecimal first = getBigDecimal(num1);
        BigDecimal second = getBigDecimal(num2);
        return first.subtract(second);
    }
    public static BigDecimal multiply(double num1, double num2) {
        BigDecimal first = getBigDecimal(num1);
        BigDecimal second = getBigDecimal(num2);
        return first.multiply(second);
    }
    public static Double divide(double num1, double num2) {
        BigDecimal first = getBigDecimal(num1);
        BigDecimal second = getBigDecimal(num2);
        return first.divide(second,3,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
