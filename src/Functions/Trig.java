package Functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Trig {

    private final BigDecimal accuracy = new BigDecimal(0.0000000005);
    //sets accuracy to the 9th decimal place then rounds to the 8th spot
    //Originally it was set to the 8th but on occation the 8th decimal would be 
    //off by 1, this returns the correct value when rounded to the 8th decimal 
    //place in the main function accourding to wolfram

    public BigDecimal SinAprox(double value) {//the approximation for the value of sin(x)
        return (TaylorSeries(value, 1, 1));
    }
    
    public BigDecimal CosAprox(double value) {//the approximation for the value of cos(x)
        return (TaylorSeries(value, 0, 1));
    }
    
    public BigDecimal CscAprox(double value) {//the approximation for the value of cos(x)
        return new BigDecimal(1.0).divide(SinAprox(value),15, RoundingMode.HALF_UP);
    }
    
    public BigDecimal SecAprox(double value) {//the approximation for the value of cos(x)
        return new BigDecimal(1.0).divide(CosAprox(value),15, RoundingMode.HALF_UP);
    }
    
    public BigDecimal TanAprox(double value) {//the approximation for the value of cos(x)
        return (SinAprox(value).divide(CosAprox(value),15, RoundingMode.HALF_UP));
    }
    public BigDecimal CotAprox(double value) {//the approximation for the value of cos(x)
        return (CosAprox(value).divide(SinAprox(value),15, RoundingMode.HALF_UP));
    }

    private BigDecimal TaylorSeries(double value, float k, int alt) {//returns the value of the taylor series
        if ((NextPn(value, k + 2, alt).abs().compareTo(accuracy)) == -1) {//checks for decimal place accuracy using the Alternating Series Therom
            //a of n+1 <= 0.0000000005
            return NextPn(value, k, alt);//if a of n+1 is accurate enough it returns a of n and ends the Taylor Series
        } else {
            //if a of n+1 was not accurate enough then add (x^(k+2))/k!
            //for ex. if n = 3 it would look like x - (x^(3))/3! + (x^(5))/5! for sin(x)
            return NextPn(value, k, alt).add(TaylorSeries(value, k + 2, (alt * -1)));
        }
    }

    private double Factorial(double n) {//simple factorial method
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }

    private BigDecimal NextPn(double value, float k, int alt) {//returns the value of a of n
        BigDecimal TS = new BigDecimal(alt * (Math.pow(value, k)) / Factorial(k));
        return TS;
    }

}
