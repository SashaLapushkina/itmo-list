public class Rational implements Comparable<Rational>{
    int numerator;
    int denominator;

    Rational(int numerator, int denominator){
        if (denominator == 0) throw new ArithmeticException();
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        int gcd = gcd(Math.abs(numerator), denominator);
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

    private String sign(int x) {
        return x >= 0 ? "" : "-";
    }

    @Override
    public String toString() {
        String total;
        String fraction;
        int num = Math.abs(numerator);
        if (num < denominator) total = "";
        else total = num / denominator + " ";
        if (num % denominator == 0) fraction = "";
        else fraction = num % denominator + "/" + denominator + " ";
        return sign(numerator) + total + fraction;
    }

    @Override
    public int compareTo(Rational num) {
        return this.numerator * num.denominator - num.numerator * this.denominator;
    }
}