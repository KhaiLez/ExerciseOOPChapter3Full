public class Test
{
    public static void main(String[] args)
    {
        MyPolynomial p1 = new MyPolynomial(5, 2, 3, 4);
        System.out.println(p1.coeffs.length);
        System.out.println(p1.getDegree());
        System.out.println(p1);
        System.out.println(p1.evaluate(2));
        MyPolynomial p2 = new MyPolynomial(4, 3, 2, 5);
        System.out.println(p1.add(p2));
        System.out.println(p1.multiply(p2));
    }
}
