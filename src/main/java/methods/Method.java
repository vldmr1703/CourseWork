package methods;

import functions.Function;

public abstract class Method {

    protected Function function;
    private static final double EPS = 0.00001;

    public Method(Function function) {
        this.function = function;
    }

    public abstract double[] calculate();

    protected void print(double[] x) {
        for (double xi : x) {
            System.out.print(xi + " ");
        }
        System.out.println();
    }

    protected boolean comparing(double[] x) {
        double[] F = function.getFunction(x);
        for (int i = 0; i < x.length; i++) {
            if (Math.abs(F[i]) >= EPS)
                return true;
        }
        return false;
    }

    protected double[][] divDifferences(double[] x0, double[] x1) {
        int n = x0.length;
        double[][] jac = new double[n][n];
        double[] F0;
        double[] F1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[] mas0 = new double[n];
                for (int k = 0; k < j + 1; k++) {
                    mas0[k] = x0[k];
                }
                for (int k = j + 1; k < n; k++) {
                    mas0[k] = x1[k];
                }
                double[] mas1 = new double[n];
                for (int k = 0; k < j; k++)
                    mas1[k] = x0[k];
                for (int k = j; k < n; k++)
                    mas1[k] = x1[k];
                F0 = function.getFunction(mas0);
                F1 = function.getFunction(mas1);
                double r = (x0[j] - x1[j]);
                if (r == 0)
                    r = 1e-8;
                jac[i][j] = (F0[i] - F1[i]) / (r);
            }
        }
        return jac;
    }
}
