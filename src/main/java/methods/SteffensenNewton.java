package methods;

import functions.Function;
import system.solver.Gauss;

public class SteffensenNewton extends Method {

    public SteffensenNewton(Function function) {
        super(function);
    }

    public double[] calculate() {
        Gauss system;
        double[] x0 = function.getX0();
        int n = x0.length;
        double[] x1 = new double[n];
        double[] a = new double[n];
        double[] b = new double[n];
        double[] y0 = new double[n];
        double[] F;
        double[] mas;
        for (int i = 0; i < n; i++) {
            x1[i] = x0[i];
        }
        do {
            for (int i = 0; i < n; i++) {
                x0[i] = x1[i];
            }
            F = function.getFunction(x0);
            for (int i = 0; i < n; i++) {
                //x1[i] = x0[i] - mas[i];
                a[i] = x0[i] - F[i];
                b[i] = x0[i] + F[i];
            }
            system = new Gauss(divDifferences(a, b), F);
            mas = system.getX();
            for (int i = 0; i < n; i++) {
                y0[i] = x0[i] - mas[i];
            }
            F = function.getFunction(y0);
            system = new Gauss(function.getJacobian(y0), F);
            mas = system.getX();
            for (int i = 0; i < n; i++) {
                x1[i] = y0[i] - mas[i];
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
