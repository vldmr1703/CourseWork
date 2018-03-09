package methods;

import functions.Function;
import system.solver.Gauss;

public class SteffensenTwoStepModified extends Method {

    public SteffensenTwoStepModified(Function function) {
        super(function);
    }

    public double[] calculate() {
        Gauss system;
        double[] x0 = function.getX0();
        int n = x0.length;
        double[] F;
        double[] mas;
        double[] x1 = new double[n];
        double[] y0 = new double[n];
        double[] xy = new double[n];
        for (int i = 0; i < n; i++) {
            x1[i] = x0[i];
            y0[i] = x0[i];
        }
        do {
            for (int i = 0; i < n; i++) {
                x0[i] = x1[i];
                xy[i] = (x0[i] + y0[i]) / 2;
            }
            F = function.getFunction(x0);
            double[][] jacobian = function.getJacobian(xy);
            system = new Gauss(jacobian, F);
            mas = system.getX();
            for (int i = 0; i < n; i++) {
                y0[i] = x0[i] - mas[i];
            }
            for (int i = 0; i < n; i++) {
                xy[i] = (x0[i] + y0[i]) / 2;
            }
            F = function.getFunction(y0);
            system = new Gauss(function.getJacobian(xy), F);
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
