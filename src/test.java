package src;
import java.util.*;
class test{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("enter length of data:");
        int N = in.nextInt();

        System.out.println("enter the " + N + " values of X");
        double[] X = new double[N];
        X = getData(N);

        System.out.println("enter the " + N + " values of Y");
        double[] Y = new double[N];
        Y = getData(N);

        double alpha = 0.0001;

        double m = 5;
        double b = 5;
        double loss = 5;
        while (loss > 0.00001){
            loss = loss(b, m, X, Y);
            System.out.println("m:" + m + ", b:" + b + ", loss:" + loss);
            double oldM = m;
            m = m - alpha * partialM(b, m, X, Y);
            b = b - alpha * partialB(b, oldM, X, Y);
        }



    }
    public static double[] getData(int N){
        double[] data = new double[N];
        for (int i = 0;i<N;i++){
            data[i] = in.nextDouble();
        }
        return data;
    }
    public static void printData(double[] data){
        System.out.print("[");
        System.out.print(data[0]);

        for (int i = 1;i<data.length;i++){
            System.out.print(data[i] + ",");

        }
    }
    public static double partialB(double b, double m,double[] X,double[] Y){
        double sum=0;
        for (int i = 0;i<X.length;i++){
            sum += m*X[i] + b - Y[i];
        }
        sum *= 2;
        return sum;
    }
    public static double partialM(double b, double m,double[] X,double[] Y){
        double sum=0;
        for (int i = 0;i<X.length;i++){
            sum += X[i]* (m*X[i] + b - Y[i]);
        }
        sum *= 2;
        return sum;
    }
    public static double loss(double b,double m,double[] X,double[] Y){
        double sum = 0;
        for (int i = 0;i<X.length;i++){
            sum += Math.pow((m*X[i] + b - Y[i]),2);
        }
        return sum;
    }

}