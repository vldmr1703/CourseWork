package methods;

import functions.Function;
import system.solver.Gauss;

public class Newton extends Method {

    public Newton(Function function) {
        super(function);
    }

    public double[] calculate() {
        Gauss system;
        double[] x0 = function.getX0();
        int n = x0.length;
        double[] x1 = new double[n];
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

            system = new Gauss(function.getJacobian(x0), F);
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
