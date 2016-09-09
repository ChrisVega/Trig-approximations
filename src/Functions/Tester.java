package Functions;

import java.math.BigDecimal;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Trig trig = new Trig();
        //Approximates any trig function to 8 decimal places of accuracy
        //x should be in radians
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter an angle in radians:");
        float x = reader.nextFloat();
        BigDecimal TS;
        TS = trig.SinAprox(x).setScale(8, BigDecimal.ROUND_HALF_UP);
        System.out.println("Sin: "+TS);
        TS = trig.CosAprox(x).setScale(8, BigDecimal.ROUND_HALF_UP);
        System.out.println("Cos: "+TS);
        TS = trig.CscAprox(x).setScale(8, BigDecimal.ROUND_HALF_UP);
        System.out.println("Csc: "+TS);
        TS = trig.SecAprox(x).setScale(8, BigDecimal.ROUND_HALF_UP);
        System.out.println("Sec: "+TS);
        TS = trig.TanAprox(x).setScale(8, BigDecimal.ROUND_HALF_UP);
        System.out.println("Tan: "+TS);
        TS = trig.CotAprox(x).setScale(8, BigDecimal.ROUND_HALF_UP);
        System.out.println("Cot: "+TS);
        
    }

}
