package sequence;

public class SequenceCalculateResult
{
    int iteration;
    double epsilonSum;

    public SequenceCalculateResult(int iteration, double epsilonSum)
    {
        this.iteration = iteration;
        this.epsilonSum = epsilonSum;
    }

    public int getIteration()
    {
        return iteration;
    }

    public double getEpsilonSum()
    {
        return epsilonSum;
    }
}


