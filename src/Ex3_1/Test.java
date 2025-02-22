package Ex3_1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complex number 1 (real and imaginary part): ");
        double real1 = sc.nextDouble();
        double imag1 = sc.nextDouble();
        MyComplex c1 = new MyComplex(real1, imag1);

        System.out.print("Enter complex number 2 (real and imaginary part): ");
        double real2 = sc.nextDouble();
        double imag2 = sc.nextDouble();
        MyComplex c2 = new MyComplex(real2, imag2);

        System.out.println("Number 1 is: " + c1);
        System.out.println(c1 + " is " + (c1.isReal() ? "a pure real number" : "NOT a pure real number"));
        System.out.println(c1 + " is " + (c1.isImaginary() ? "a pure imaginary number" : "NOT a pure imaginary number"));
        System.out.println();

        System.out.println("Number 2 is: " + c2);
        System.out.println(c2 + " is " + (c2.isReal() ? "a pure real number" : "NOT a pure real number"));
        System.out.println(c2 + " is " + (c2.isImaginary() ? "a pure imaginary number" : "NOT a pure imaginary number"));
        System.out.println();
        System.out.println(c1 + " is " + (c1.equals(c2) ? "equal to" : "NOT equal to") + " " + c2);

        MyComplex sum = c1.addNew(c2);
        System.out.println(c1 + " + " + c2 + " = " + sum);
        MyComplex difference = c1.subtractNew(c2);
        System.out.println(c1 + " - " + c2 + " = " + difference);
        MyComplex product = c1.multiply(c2);
        System.out.println(c1 + " * " + c2 + " = " + product);
        MyComplex quotient = c1.divide(c2);
        System.out.println(c1 + " / " + c2 + " = " + quotient);

        MyComplex conjugate = c1.conjugate();
        System.out.println("Conjugate of " + c1 + " = " + conjugate);
    }
}
