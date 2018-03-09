package main;

import functions.Rozenbroke;
import functions.System2;
import methods.*;

public class Main {
    public static void main(String[] args) {
        System2 function = new System2();
        SteffensenTwoStepModified newtonMethod = new SteffensenTwoStepModified(function);
        newtonMethod.calculate();
    }
}
