package main;

import com.sun.org.apache.bcel.internal.generic.NEW;
import functions.Function;
import functions.Rozenbroke;
import functions.System2;
import methods.*;

public class Main {
    public static void main(String[] args) {
//        Rozenbroke function = new Rozenbroke(10);
//        Newton newtonMethod = new Newton(function);
//        newtonMethod.calculate();
        Function func = new System2();
        Method newtonMethod = new Newton(func);
        double[] x1 = newtonMethod.calculate();
        for (int i = 0; i < 2; i++){
            System.out.println(x1[i] + " : " + func.getFunction(x1)[i]);
        }
    }
}
