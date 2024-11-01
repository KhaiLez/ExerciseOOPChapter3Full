public class Test
{
    public static void main(String[] args)
    {
        MyComplex c1= new MyComplex(3.0,4.0);
        System.out.println(c1.conjugate());
        MyComplex c2= new MyComplex(1.5, -2.5);
        System.out.println(c1);
        System.out.println(c2);

        System.out.println("c1 is real: "+c1.isReal());
        System.out.println("c1 is imaginary: "+c1.isImaginary());
        System.out.println("c2 is real: "+c1.isReal());
        System.out.println("c2 is imaginary: "+c2.isImaginary());

        MyComplex c3=c1.addNew(c2);
        System.out.println(c3);
        System.out.println(c1.addInto(c2));

        MyComplex c4=c1.subtractionNew(c2);
        System.out.println(c4);

        System.out.println(c1.subtraction(c2));
        System.out.println(c1.multiply(c2));
        System.out.println(c1.divide(c2));
    }
}