package sequence;

import java.util.Scanner;
import java.util.Locale;

public class Main
{

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        double x = readData("x (-1 < x < 1)");
        int n = (int) readData("n");
        double e = readData("e");

        if (checkData(x))
        {
            SequenceCalculateResult SumOfSequence = calcSumOfSequence(x, n);
            SequenceCalculateResult SumGreaterThanEpsilon = calcSumGreaterThanEpsilon(x, n, e);
            SequenceCalculateResult SumGreaterThanEpsilonDividedByTen = calcSumGreaterThanEpsilon(x, n, e / 10);
            double ValueOfFunction = calcValueOfFunction(x);


            printEpsilonRelatedResult(": ", SumOfSequence);
            printEpsilonRelatedResult(" greater than epsilon: ", SumGreaterThanEpsilon);
            printEpsilonRelatedResult(" greater than epsilon/10: ", SumGreaterThanEpsilonDividedByTen);
            printResult("function value", ValueOfFunction);
        }
    }

    public static double readData(String variable)
    {
        System.out.printf("Input %s: ", variable);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static boolean checkData(double x)
    {
        boolean checkResult = true;
        if (Math.abs(x) >= 1)
        {
            System.out.print("Input problem: data is not correct. X need be (-1 < x < 1)");
            checkResult = false;
        }
         return checkResult;
    }

    public static SequenceCalculateResult calcSumOfSequence(double x, int n)
    {
        double nMember;
        double sum = 1;
        int iteration = 1;

        for (int i = 1; i < n; i++)
        {
            nMember = Math.pow(-x, i) * (i + 1) * (i + 2) / 2;

            sum += nMember;
            iteration++;
        }
        return new SequenceCalculateResult(iteration, sum);
    }

    public static SequenceCalculateResult calcSumGreaterThanEpsilon(double x, int n, double e)
    {
        double nMember;
        double sumGreaterThenEpsilon = 1;
        int iteration = 1;

        for (int i = 1; i < n; i++)
        {
            nMember = Math.pow(-x, i) * (i + 1) * (i + 2) / 2;
            if (Math.abs(nMember) > e)
            {
                sumGreaterThenEpsilon += nMember;
                iteration++;
            }
        }
        return new SequenceCalculateResult(iteration, sumGreaterThenEpsilon);
    }

    public static double calcValueOfFunction(double x)
    {
        return Math.pow((1 + x), -3);
    }

    public static void printResult(String text, double result)
    {
        System.out.printf("The %s: %.03f%n", text, result);
    }

    public static void printEpsilonRelatedResult(String phrase, SequenceCalculateResult sequenceCalculateResult)
    {
        System.out.println("The sum of of the first n elements" + phrase + sequenceCalculateResult.getEpsilonSum() +
                "  (Number of elements: " + sequenceCalculateResult.getIteration() + ")");
    }
}
