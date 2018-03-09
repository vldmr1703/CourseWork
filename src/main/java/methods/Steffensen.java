package methods;

import functions.Function;
import system.solver.Gauss;

public class Steffensen extends Method {

    public Steffensen(Function function) {
        super(function);
    }

    public double[] calculate() {
        Gauss system;
        double[] x0 = function.getX0();
        int n = x0.length;
        double[] F;
        double[] mas;
        double[] x1 = new double[n];
        double[] d = new double[n];
        for (int i = 0; i < n; i++) {
            x1[i] = x0[i];
        }
        do {
            for (int i = 0; i < n; i++) {
                x0[i] = x1[i];
            }
            F = function.getFunction(x0);
            for (int i = 0; i < n; i++) {
                //if (Math.Abs(F[i]) < 1e-8)
                //    F[i] = 1e-8;
                d[i] = x0[i] + F[i];
            }
            system = new Gauss(divDifferences(x0, d), F);
            mas = system.getX();
            for (int i = 0; i < n; i++) {
                x1[i] = x0[i] - mas[i];
            }
            System.out.print("x0 = ");
            print(x0);
            System.out.print("x1 = ");
            print(x1);
        }
        while (comparing(x1));
        return x1;
    }
}
