public class MyPolynomial
{
    double[] coeffs;

    public MyPolynomial(double... coeffs)
    {
        this.coeffs = coeffs;
    }

    public int getDegree()
    {
        return coeffs.length - 1;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length-1; i >= 0; i--)
        {
            if (coeffs[i] != 0)
            {
                if (sb.length() > 0)
                {
                    sb.append(" + ");
                }
                if (i == 0)
                {
                    sb.append(coeffs[i]);
                } else if (i == 1)
                {
                    sb.append(coeffs[i]).append("x");
                } else
                {
                    sb.append(coeffs[i]).append("x^").append(i);
                }
            }
        }
        return sb.toString();
    }

    public double evaluate(double x)
    {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right)
    {
        int maxDegree = Math.max(this.getDegree(), right.getDegree());
        double[] resultCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++)
        {
            if (i <= this.getDegree()) {
                resultCoeffs[i] += this.coeffs[i];
            }
            if (i <= right.getDegree()) {
                resultCoeffs[i] += right.coeffs[i];
            }
        }
        return new MyPolynomial(resultCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right)
    {
        int newDegree = this.getDegree() + right.getDegree();
        double[] resultCoeffs = new double[newDegree + 1];

        for (int i = 0; i <= this.getDegree(); i++)
        {

            for (int j = 0; j <= right.getDegree(); j++)
            {
                resultCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(resultCoeffs);
    }
}
