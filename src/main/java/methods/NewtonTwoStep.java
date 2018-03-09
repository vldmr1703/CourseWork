package methods;

import functions.Function;
import system.solver.Gauss;

public class NewtonTwoStep extends Method {

    public NewtonTwoStep(Function function) {
        super(function);
    }

    public double[] calculate() {
        Gauss system;
        double[] x0 = function.getX0();
        int n = x0.length;
        double[] F;
        double[] x1 = new double[n];
        double[] y0 = new double[n];
        double[] xy = new double[n];
        double[] mas;
        F = function.getFunction(x0);
        for (int i = 0; i < n; i++) {
            x1[i] = x0[i];
            y0[i] = F[i];
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
                x1[i] = x0[i] - mas[i];
            }
            F = function.getFunction(x1);
            system = new Gauss(jacobian, F);
            mas = system.getX();
            for (int i = 0; i < n; i++) {
                y0[i] = x1[i] - mas[i];
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
