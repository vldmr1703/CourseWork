//public partial
//
//class e {
//    BackgroundWorker backgroundWorker = new BackgroundWorker();
//    delegate
//
//    double[] function(double[] x);
//
//    delegate double[,]
//
//    jac(double[] x);
//
//    delegate
//
//    void X0();
//
//    X0 MakeX0;
//    jac j;
//    function f;
//    int n;
//    double[] x0;
//    double[] x1;
//    double[] mas;
//    double eps = 0.00001;
//
//    public Form1() {
//        system2();
//        InitializeComponent();
//        backgroundWorker_Init();
//
//    }
//
//    void backgroundWorker_Init() {
//        this.backgroundWorker.WorkerReportsProgress = true;
//        this.backgroundWorker.WorkerSupportsCancellation = true;
//        this.backgroundWorker.DoWork += new System.ComponentModel.DoWorkEventHandler(this.backgroundWorker_DoWork);
//    }
//
//
//    void backgroundWorker_DoWork(object sender, DoWorkEventArgs e) {
//        Newton();
//        NewtonTwoStep();
//        NewtonTwoStep1();
//        Steffensen();
//        SteffensenTwoStep();
//        NewtonSteffensen();
//        SteffensenNewton();
//    }
//
//    void Rozenbroke(int n) {
//        this.n = n;
//        // n = 2;
//        MakeX0 = new X0(MakeX0Rozenbroke);
//        f = new function(fRozenbroke);
//        j = new jac(JacobianFRozenbroke);
//    }
//
//    void MakeX0Rozenbroke() {
//        x0 = new double[n];
//        x1 = new double[n];
//        for (int i = 0; i < n; i += 2) {
//            x0[i] = -1.2;
//            x0[i + 1] = 1;
//        }
//    }
//
//    void system() {
//        n = 2;
//        MakeX0 = new X0(MakeX0System);
//        f = new function(fSystem);
//        j = new jac(JacobianFSystem);
//    }
//
//    void MakeX0System() {
//        x0 = new double[n];
//        x1 = new double[n];
//        for (int i = 0; i < n; i += 2) {
//            x0[i] = -0.9;
//            x0[i + 1] = 0.5;
//        }
//    }
//
//    void system2() {
//        n = 2;
//        MakeX0 = new X0(MakeX0System2);
//        f = new function(fSystem2);
//        j = new jac(JacobianSystem2);
//    }
//
//    void MakeX0System2() {
//        x0 = new double[n];
//        x1 = new double[n];
//        x0[0] = 1.2;
//        x0[1] = 1.1;
//    }
//
//    void Pauell(int n) {
//        this.n = n;
//        MakeX0 = new X0(MakeX0Pauell);
//        f = new function(fPauell);
//        j = new jac(JacobianFPauell);
//    }
//
//    void MakeX0Pauell() {
//        x0 = new double[n];
//        x1 = new double[n];
//        for (int i = 0; i < n / 4; i++) {
//            x0[4 * i] = 3;
//            x0[4 * i + 1] = -1;
//            x0[4 * i + 3] = 1;
//        }
//    }
//
//    void Trygonom(int n) {
//        this.n = n;
//        MakeX0 = new X0(MakeX0Trygonom);
//        f = new function(fTrygonom);
//        j = new jac(JacobianFTrygonom);
//    }
//
//    void MakeX0Trygonom() {
//        x0 = new double[n];
//        x1 = new double[n];
//        for (int i = 0; i < n; i++)
//            x0[i] = 1.0 / n;
//    }
//
//
//    void Newton() {
//        textBox1.Text += "\r\n\r\nMethod of Newton: \r\n\r\n";
//        gauss system;
//        MakeX0();
//        double[] F;
//        for (int i = 0; i < n; i++) {
//            x1[i] = x0[i];
//        }
//        do {
//            for (int i = 0; i < n; i++) {
//                x0[i] = x1[i];
//            }
//            F = f(x0);
//
//            system = new gauss(j(x0), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                x1[i] = x0[i] - mas[i];
//            }
//
//            textBox1.Text += "\r\nx0 = ";
//            print(x0);
//            textBox1.Text += "\r\nx1 = ";
//            print(x1);
//        } //while (comparing(x1, x0, eps));
//        while (comparing(x1));
//    }
//
//    void NewtonTwoStep() {
//        textBox1.Text += "\r\n\r\nMethod of NewtonTwoStep: \r\n\r\n";
//        gauss system;
//        MakeX0();
//        double[] F;
//        double[] y0 = new double[n];
//        double[] xy = new double[n];
//        F = f(x0);
//        for (int i = 0; i < n; i++) {
//            x1[i] = x0[i];
//            y0[i] = F[i];/////
//        }
//        do {
//            for (int i = 0; i < n; i++) {
//                x0[i] = x1[i];
//                xy[i] = (x0[i] + y0[i]) / 2;
//            }
//            F = f(x0);
//            var jacobian = j(xy);
//            system = new gauss(jacobian, F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                x1[i] = x0[i] - mas[i];
//            }
//            F = f(x1);
//            system = new gauss(jacobian, F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                y0[i] = x1[i] - mas[i];
//            }
//            textBox1.Text += "\r\nx0 = ";
//            print(x0);
//            textBox1.Text += "\r\nx1 = ";
//            print(x1);
//        } //while (comparing(x1, x0, eps));
//        while (comparing(x1));
//    }
//
//    void NewtonTwoStep1() {
//        textBox1.Text += "\r\n\r\nMethod of NewtonTwoStepModified: \r\n\r\n";
//        //x_k+1 := y_k
//        //y_k+1 := x_k+1
//        gauss system;
//        MakeX0();
//        double[] F;
//        double[] y0 = new double[n];
//        double[] xy = new double[n];
//        for (int i = 0; i < n; i++) {
//            x1[i] = x0[i];
//            y0[i] = x0[i];
//        }
//        do {
//            for (int i = 0; i < n; i++) {
//                x0[i] = x1[i];
//                xy[i] = (x0[i] + y0[i]) / 2;
//            }
//            F = f(x0);
//            var jacobian = j(xy);
//            system = new gauss(jacobian, F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                y0[i] = x0[i] - mas[i];
//            }
//            for (int i = 0; i < n; i++) {
//                xy[i] = (x0[i] + y0[i]) / 2;
//            }
//            F = f(y0);
//            system = new gauss(j(xy), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                x1[i] = y0[i] - mas[i];
//            }
//            textBox1.Text += "\r\nx0 = ";
//            print(x0);
//            textBox1.Text += "\r\nx1 = ";
//            print(x1);
//        } //while (comparing(x1, x0, eps));
//        while (comparing(x1));
//    }
//
//    void Steffensen() {
//        textBox1.Text += "\r\n\r\nMethod of Steffensen: \r\n\r\n";
//        gauss system;
//        MakeX0();
//        double[] F;
//        double[] d = new double[n];
//        for (int i = 0; i < n; i++) {
//            x1[i] = x0[i];
//        }
//        do {
//            for (int i = 0; i < n; i++) {
//                x0[i] = x1[i];
//            }
//            F = f(x0);
//            for (int i = 0; i < n; i++) {
//                //if (Math.Abs(F[i]) < 1e-8)
//                //    F[i] = 1e-8;
//                d[i] = x0[i] + F[i];
//            }
//            textBox1.Text += "\r\nx0 = ";
//            print(x0);
//            textBox1.Text += "\r\nd = ";
//            print(d);
//            textBox1.Text += "\r\nF = ";
//            print(F);
//            system = new gauss(divDifferences(x0, d), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                x1[i] = x0[i] - mas[i];
//            }
//            textBox1.Text += "\r\nx0 = ";
//            print(x0);
//            textBox1.Text += "\r\nx1 = ";
//            print(x1);
//        }
//        //while (comparing(x1, x0, eps));
//        while (comparing(x1));
//    }
//
//    void SteffensenTwoStep() {
//        textBox1.Text += "\r\n\r\nMethod of Steffensen-Two-step:";
//        gauss system;
//        MakeX0();
//        double[] a = new double[n];
//        double[] b = new double[n];
//        double[] y0 = new double[n];
//        double[] F;
//        for (int i = 0; i < n; i++) {
//            x1[i] = x0[i];
//        }
//        do {
//            for (int i = 0; i < n; i++) {
//                x0[i] = x1[i];
//            }
//            F = f(x0);
//            for (int i = 0; i < n; i++) {
//                a[i] = x0[i] - F[i];
//                b[i] = x0[i] + F[i];
//            }
//            system = new gauss(divDifferences(a, b), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                y0[i] = x0[i] - mas[i];
//            }
//            F = f(y0);
//            system = new gauss(divDifferences(a, b), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                x1[i] = y0[i] - mas[i];
//            }
//            textBox1.Text += "\r\nx0 = ";
//            print(x0);
//            textBox1.Text += "\r\nx1 = ";
//            print(x1);
//
//        }
//        //while (comparing(x1, x0, eps));
//        while (comparing(x1));
//    }
//
//    void NewtonSteffensen() {
//        textBox1.Text += "\r\n\r\nMethod of Newton - Steffensen:";
//        gauss system;
//        MakeX0();
//        double[] a = new double[n];
//        double[] b = new double[n];
//        double[] y0 = new double[n];
//        double[] F;
//        for (int i = 0; i < n; i++) {
//            x1[i] = x0[i];
//        }
//        do {
//            for (int i = 0; i < n; i++) {
//                x0[i] = x1[i];
//            }
//            F = f(x0);
//            system = new gauss(j(x0), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                x1[i] = x0[i] - mas[i];
//                a[i] = x0[i] - F[i];
//                b[i] = x0[i] + F[i];
//            }
//            for (int i = 0; i < n; i++) {
//                y0[i] = x0[i] - mas[i];
//            }
//            F = f(y0);
//            system = new gauss(divDifferences(a, b), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                x1[i] = y0[i] - mas[i];
//            }
//            textBox1.Text += "\r\nx0 = ";
//            print(x0);
//            textBox1.Text += "\r\nx1 = ";
//            print(x1);
//
//        }
//        //while (comparing(x1, x0, eps));
//        while (comparing(x1));
//    }
//
//    void SteffensenNewton() {
//        textBox1.Text += "\r\n\r\nMethod of Steffensen - Newton:";
//        gauss system;
//        MakeX0();
//        double[] a = new double[n];
//        double[] b = new double[n];
//        double[] y0 = new double[n];
//        double[] F;
//        for (int i = 0; i < n; i++) {
//            x1[i] = x0[i];
//        }
//        do {
//            for (int i = 0; i < n; i++) {
//                x0[i] = x1[i];
//            }
//            F = f(x0);
//            for (int i = 0; i < n; i++) {
//                //x1[i] = x0[i] - mas[i];
//                a[i] = x0[i] - F[i];
//                b[i] = x0[i] + F[i];
//            }
//            system = new gauss(divDifferences(a, b), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                y0[i] = x0[i] - mas[i];
//            }
//            F = f(y0);
//            system = new gauss(j(y0), F);
//            mas = system.getX();
//            for (int i = 0; i < n; i++) {
//                x1[i] = y0[i] - mas[i];
//            }
//            textBox1.Text += "\r\nx0 = ";
//            print(x0);
//            textBox1.Text += "\r\nx1 = ";
//            print(x1);
//
//        }
//        //while (comparing(x1, x0, eps));
//        while (comparing(x1));
//    }
//
//    bool comparing(double[] x0, double[] x1, double eps) {
//        for (int i = 0; i < n; i++) {
//            if (Math.Abs(x1[i] - x0[i]) >= eps)
//                return true;
//        }
//        return false;
//    }
//
//    //bool comparing(double[] x0, double[] x1, double eps)
//    bool comparing(double[] x1) {
//        double[] F = f(x1);
//        for (int i = 0; i < n; i++) {
//            if (Math.Abs(F[i]) >= eps)
//                return true;
//        }
//        return false;
//    }
//
//    void print(double[] x) {
//        for (int i = 0; i < n; i++) {
//            textBox1.Text += x[i] + "\t";
//        }
//        textBox1.Text += "\r\n";
//    }
//
//    double[,]
//
//    divDifferences(double[] x0, double[] x1) {
//        double[,]Jac = new double[n, n];
//        double[] F0;
//        double[] F1;
//        // textBox1.Text += "\r\ndivDifferences:";
//        //textBox1.Text += "\r\nx0 = ";
//        //print(x0);
//        //textBox1.Text += "\r\nx1 = ";
//        //print(x1);
//        for (int i = 0; i < n; i++) {
//            //textBox1.Text += "\r\n";
//            for (int j = 0; j < n; j++) {
//                double[] mas0 = new double[n];
//                for (int k = 0; k < j + 1; k++) {
//                    mas0[k] = x0[k];
//                }
//                for (int k = j + 1; k < n; k++) {
//                    mas0[k] = x1[k];
//                }
//                double[] mas1 = new double[n];
//                for (int k = 0; k < j; k++)
//                    mas1[k] = x0[k];
//                for (int k = j; k < n; k++)
//                    mas1[k] = x1[k];
//                F0 = f(mas0);
//                F1 = f(mas1);
//                double r = (x0[j] - x1[j]);
//                if (r == 0)
//                    r = 1e-8;
//                //textBox1.Text += "\r\nr = " +  r + "\r\n";
//                Jac[i, j] =(F0[i] - F1[i]) / (r);
//                //textBox1.Text += Jac[i,j] + "\t\t";
//            }
//        }
//        return Jac;
//    }
//
//
//    double[] fRozenbroke(double[] x) {
//        double[] F = new double[n];
//        for (int i = 0; i < n; i++) {
//            if (i % 2 != 0) {
//                F[i] = 1 - x[i - 1];
//            } else {
//                F[i] = 10 * (x[i + 1] - Math.Pow(x[i], 2));
//            }
//        }
//        return F;
//    }
//
//    double[,]
//
//    JacobianFRozenbroke(double[] x0) {
//        double[,]Jac = new double[n, n];
//        for (int i = 0; i < n; i++) {
//            if (i % 2 != 0)
//                Jac[i, i - 1] =-1;
//        else
//            {
//                Jac[i, i + 1] =10;
//                Jac[i, i] =-20 * x0[i];
//            }
//        }
//        //for (int i = 0; i < n; i++)
//        //{
//        //    textBox1.Text += "\r\n";
//        //    for (int j = 0; j < n; j++)
//        //        textBox1.Text += Jac[i, j] + "\t\t";
//        //}
//        return Jac;
//    }
//
//    double[] fSystem(double[] x) {
//        double[] F = new double[n];
//        //for (int i = 0; i < n; i++)
//        {
//            //if (i == 0)
//            F[0] = 2 * x[1] - Math.Cos(x[0] + 1);
//            // else
//            F[1] = x[0] + Math.Sin(x[1]) + 0.4;
//        }
//        return F;
//    }
//
//    double[,]
//
//    JacobianFSystem(double[] x0) {
//        double[,]Jac = new double[n, n];
//        Jac[0, 0] =Math.Sin(x0[0] + 1);
//        Jac[0, 1] =2;
//        Jac[1, 0] =1;
//        Jac[1, 1] =Math.Cos(x0[1]);
//        return Jac;
//    }
//
//    double[] fPauell(double[] x0) {
//        double[] F = new double[n];
//        for (int i = 0; i < n / 4; i++) {
//            F[4 * i] = x0[4 * i] + 10 * x0[4 * i + 1];
//            F[4 * i + 1] = Math.Sqrt(5) * (x0[4 * i + 2] - x0[4 * i + 3]);
//            F[4 * i + 2] = Math.Pow(x0[4 * i + 1] - 2 * x0[4 * i + 2], 2);
//            F[4 * i + 3] = Math.Sqrt(10) * Math.Pow(x0[4 * i] - x0[4 * i + 3], 2);
//        }
//        return F;
//    }
//
//    double[,]
//
//    JacobianFPauell(double[] x0) {
//        double[,]Jac = new double[n, n];
//        for (int i = 0; i < n / 4; i++) {
//            Jac[4 * i, 4 * i] =1;
//            Jac[4 * i, 4 * i + 1] =10;
//            Jac[4 * i + 1, 4 * i + 2] =Math.Sqrt(5);
//            Jac[4 * i + 1, 4 * i + 3] =-Math.Sqrt(5);
//            Jac[4 * i + 2, 4 * i + 1] =2 * x0[4 * i + 1];
//            Jac[4 * i + 2, 4 * i + 2] =-4 * x0[4 * i + 2];
//            Jac[4 * i + 3, 4 * i] =2 * Math.Sqrt(10) * x0[4 * i];
//            Jac[4 * i + 3, 4 * i + 3] =-2 * Math.Sqrt(10) * x0[4 * i + 3];
//        }
//        return Jac;
//    }
//
//    double[] fTrygonom(double[] x0) {
//        double[] F = new double[n];
//        double sum = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++)
//                sum += Math.Cos(x0[j]) + (i + 1) * (1 - Math.Cos(x0[i])) - Math.Sin(x0[i]);
//            F[i] = n - sum;
//        }
//        return F;
//    }
//
//    double[,]
//
//    JacobianFTrygonom(double[] x0) {
//        double[,]Jac = new double[n, n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++)
//                if (i == j)
//                    Jac[i, j] =Math.Sin(x0[j]) - n * (i + 1) * Math.Sin(x0[i]) + n * Math.Cos(x0[i]);
//        else
//            Jac[i, j] =Math.Sin(x0[j]);
//
//        }
//        return Jac;
//    }
//
//    double[] fSystem2(double[] x0) {
//        double[] F = new double[n];
//        F[0] = x0[0] * x0[0] - 2 * x0[1] * x0[1] - x0[0] * x0[1] + 2 * x0[0] - x0[1] + 1;
//        F[1] = 2 * x0[0] * x0[0] - x0[1] * x0[1] + x0[0] * x0[1] + 3 * x0[1] - 5;
//        return F;
//    }
//
//    double[,]
//
//    JacobianSystem2(double[] x0) {
//        double[,]Jac = new double[n, n];
//        Jac[0, 0] =2 * x0[0] - x0[1] + 2;
//        Jac[0, 1] =-2 * x0[1] - x0[0] - 1;
//        Jac[1, 0] =2 * x0[0] + x0[1];
//        Jac[1, 1] =-2 * x0[1] + x0[0] + 3;
//        return Jac;
//    }
