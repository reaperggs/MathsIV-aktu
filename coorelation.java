import java.util.Scanner;

public class coorelation{
    static void rel(int n,double sumX,double sumY,double sumXY,double sumX2,double sumY2){
        double res= ((n*sumXY)-(sumX*sumY))/(Math.sqrt((n*sumX2)-(sumX*sumX))*Math.sqrt((n*sumY2)-(sumY*sumY)));
        System.out.println("Correlation= "+res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of x and y values: ");
        int n = scanner.nextInt();

        double[] xValues = new double[n];
        double[] yValues = new double[n];
        double sumX=0,sumY=0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of x[" + (i+1) + "]: ");
            xValues[i] = scanner.nextDouble();
            System.out.print("Enter value of y[" + (i+1) + "]: ");
            yValues[i] = scanner.nextDouble();
            sumX=sumX+xValues[i];
            sumY=sumY+yValues[i];
        }

        double sumXY = 0, sumX2 = 0, sumY2 = 0;
        System.out.println("\n|   x   |   y   |   x*y   |   x^2   |   y^2   |");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < n; i++) {
            double xy = xValues[i] * yValues[i];
            double x2 = Math.pow(xValues[i], 2);
            double y2 = Math.pow(yValues[i], 2);

            
            System.out.printf("| %5.2f | %5.2f | %7.2f | %7.2f | %7.2f |\n", 
                              xValues[i], yValues[i], xy, x2, y2);
            sumXY += xy;
            sumX2 += x2;
            sumY2 += y2;
        }

        System.out.println("----------------------------------------------");
        System.out.printf("| %7.2f|%7.2f| %7.2f2 | %7.2f | %7.2f |\n",sumX,sumY, sumXY, sumX2, sumY2);
        rel(n, sumX, sumY, sumXY, sumX2, sumY2);
    }

}
