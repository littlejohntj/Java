public class Fraction {

    public static void main(String[] args) {
        
        Fraction f1 = new Fraction(2,4);
        Fraction f2 = new Fraction(2,6);

        f1.simplify();
        f2.simplify();

        f1.printSelf();
        System.out.print("\n");
        f2.printSelf();
        System.out.print("\n");

        System.out.printf("%f\n", f1.valueOf());
        System.out.printf("%f\n", f2.valueOf());

        Fraction fa = f1.add(f2);
        Fraction fs = f1.subtract(f2);
        Fraction fm = f1.multiply(f2);
        Fraction fd = f1.divide(f2);

        fa.printSelf();
        System.out.print("\n");
        fs.printSelf();
        System.out.print("\n");
        fm.printSelf();
        System.out.print("\n");
        fd.printSelf();
        System.out.print("\n");

    }

    private int numerator;
    private int denominator;

    /* 
        default constructor
        will create a fraction with numerator 0 and denominator 1
    */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /*
        parameterized constructor
        will create a fraction with numerator n and denominator d
    */
    public Fraction(int n, int d) {
        numerator = n;
        denominator = d;

        if (denominator < 0 && numerator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    // numberator accessor 
    public int getNumerator() {
        return numerator;
    }

    // denominator accessor 
    public int getDenominator() {
        return denominator;
    }

    // numerator mutator 
    public void setNumerator(int n) {
        numerator = n;
    }

    // denominator mutator
    public void setDenominator(int d) {
        denominator = d;
    }

    // will return the simplified version of the fraction 
    public void simplify() {
        int i;
        for (i = 2; i <= Math.max(numerator, denominator); i++) {
            while (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;    
            }
        }
    }

    public void printSelf() {
        System.out.printf("%d/%d", numerator, denominator);
    }

    public float valueOf() {
        return ((float)numerator) / ((float)denominator);
    }

    public Fraction multiply(Fraction f) {
        int newNumerator = f.getNumerator() * numerator;
        int newDenominator = f.getDenominator() * denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        newFraction.simplify();
        return newFraction;
    }
    
    public Fraction divide(Fraction f) {
        int newNumerator = numerator * f.getDenominator();
        int newDenominator = denominator * f.getNumerator();
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        newFraction.simplify();
        return newFraction;
    }
    
    public Fraction add(Fraction f) {
        int newNumerator = (numerator * f.getDenominator()) + (denominator*f.getNumerator());
        int newDenominator = denominator * f.getDenominator();
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        newFraction.simplify();
        return newFraction;
    }

    public Fraction subtract(Fraction f) {
        int newNumerator = (numerator * f.getDenominator()) - (denominator*f.getNumerator());
        int newDenominator = denominator * f.getDenominator();
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        newFraction.simplify();
        return newFraction;
    }
    

}