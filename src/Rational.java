public class Rational implements Comparable<Rational>{
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
        String total;
        String fraction;
        if (numerator < denominator) total = "";
        else total = numerator / denominator + " ";
        if (numerator % denominator == 0) fraction = "";
        else fraction = numerator % denominator + "/" + denominator + " ";
        return total + fraction;
    }

    @Override
    public int compareTo(Rational num) {
        return this.numerator * num.denominator - num.numerator * this.denominator;
    }
}
