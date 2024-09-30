import java.util.Scanner;

public class meanmoments {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of entries
        System.out.print("Enter the number of x and f values: ");
        int n = scanner.nextInt();

        // Declare arrays to store x and f values
        double[] xValues = new double[n];
        double[] fValues = new double[n];

        // Input x and f values
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of x[" + (i + 1) + "]: ");
            xValues[i] = scanner.nextDouble();
            System.out.print("Enter value of f[" + (i + 1) + "]: ");
            fValues[i] = scanner.nextDouble();
        }

        // Calculate summation of fx and f
        double sumX = 0, sumFX = 0, sumF = 0;
        for (int i = 0; i < n; i++) {
            sumX += xValues[i];
            sumFX += fValues[i] * xValues[i];
            sumF += fValues[i];
        }

        // Calculate mean of x
        double mean = sumFX / sumF;
        System.out.println("\nMean of x = " + mean);

        // Variables to store summations for moments about the mean
        double sumFXM1 = 0, sumFXM2 = 0, sumFXM3 = 0, sumFXM4 = 0;

        // Print the table for moments about the mean
        System.out.println("\nTable for Moments about the Mean:");
        System.out.println("|   x   |   f   |  f*x  | f*(x-mean) | f*(x-mean)^2 | f*(x-mean)^3 | f*(x-mean)^4 |");
        System.out.println("---------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            double fx = fValues[i] * xValues[i];
            double xMean = xValues[i] - mean;

            // Moments about the mean
            double fxM1 = fValues[i] * xMean;
            double fxM2 = fValues[i] * Math.pow(xMean, 2);
            double fxM3 = fValues[i] * Math.pow(xMean, 3);
            double fxM4 = fValues[i] * Math.pow(xMean, 4);

            // Accumulate summations for moments
            sumFXM1 += fxM1;
            sumFXM2 += fxM2;
            sumFXM3 += fxM3;
            sumFXM4 += fxM4;

            // Print the row for moments about mean
            System.out.printf("| %5.2f | %5.2f | %5.2f | %10.2f | %12.2f | %12.2f | %12.2f |\n",
                    xValues[i], fValues[i], fx, fxM1, fxM2, fxM3, fxM4);
        }

        // Print summation row for moments about the mean
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| Sum   | %5.2f | %5.2f | %10.2f | %12.2f | %12.2f | %12.2f |\n",
                sumF, sumFX, sumFXM1, sumFXM2, sumFXM3, sumFXM4);

        // Calculate first four moments about the mean
        double momentMean1 = sumFXM1 / sumF;
        double momentMean2 = sumFXM2 / sumF;
        double momentMean3 = sumFXM3 / sumF;
        double momentMean4 = sumFXM4 / sumF;

        // Print calculated moments about the mean
        System.out.println("\nFirst Four Moments about the Mean:");
        System.out.printf("μ1 = %.4f, μ2 = %.4f, μ3 = %.4f, μ4 = %.4f\n", momentMean1, momentMean2, momentMean3, momentMean4);

        // Calculate skewness (b₁) and kurtosis (b₂)
        double skewness = momentMean3 / Math.pow(momentMean2, 1.5); // Skewness b₁
        double kurtosis = momentMean4 / Math.pow(momentMean2, 2);   // Kurtosis b₂

        // Print skewness and kurtosis
        System.out.println("\nSkewness (b₁) = " + skewness);
        System.out.println("Kurtosis (b₂) = " + kurtosis);
    }
}
