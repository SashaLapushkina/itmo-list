public class Rational implements Comparable{
    int numerator;
    int denominator;

    Rational(int numerator, int denominator){
        if (denominator == 0) throw new ArithmeticException();
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    Rational(int numerator){
        this.numerator = numerator;
        denominator = 1;
    }

    //НОД
    private int gcd(int a, int b){
        while (b !=0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    @Override
    public String toString() {

        return " " + "/";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
