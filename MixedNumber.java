public class MixedNumber implements Comparable<MixedNumber>{

    private long integer;
    private Rational fraction;

    public MixedNumber() {

        this(0, 0, 1);

    }

    public MixedNumber(long i, long n, long d) {

        this.integer = i + (n / d);
        this.fraction = new Rational((n % d) / gcd(n % d, d), d / gcd(n % d, d));

    }

    public MixedNumber(long i, Rational r) {

        this(i, r.getNumerator(), r.getDenominator());

    }

    public long getInteger() {
        return integer;
    }

    public Rational getFraction() {
        return fraction;
    }

    public void setInteger(long integer) {
        this.integer = integer;
    }

    public void setFraction(Rational fraction) {
        this.fraction = fraction;
    }


    private static Rational convert(MixedNumber num) {
        return new Rational(num.getInteger() * num.getFraction().getDenominator() + num.getFraction().getNumerator(), num.getFraction().getDenominator());
    }

    @Override
    public String toString() {
        return getInteger() + " " + getFraction().getNumerator() + "/" + getFraction().getDenominator();
    }


    public MixedNumber add(MixedNumber num) {

        Rational r1 = convert(this);
        Rational r2 = convert(num);

        Rational res = r1.add(r2);

        return new MixedNumber(0, res);

    }

    public MixedNumber subtract(MixedNumber num) {

        Rational r1 = convert(this);
        Rational r2 = convert(num);

        Rational res = r1.subtract(r2);
        return new MixedNumber(0, res);

    }

    public MixedNumber multiply(MixedNumber num) {

        Rational r1 = convert(this);
        Rational r2 = convert(num);

        Rational res = r1.multiply(r2);
        return new MixedNumber(0, res);

    }

    public MixedNumber divide(MixedNumber num) {

        Rational r1 = convert(this);
        Rational r2 = convert(num);

        Rational res = r1.divide(r2);
        return new MixedNumber(0, res);

    }


    @Override
    public int compareTo(MixedNumber num) {
        if (this.subtract(num).getInteger() == 0 && this.subtract(num).getFraction().getNumerator() == 0)
            return 0;
        if (this.subtract(num).getInteger() >= 0 && this.subtract(num).getFraction().getNumerator() >= 0)
            return 1;
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass() != this.getClass())
            return false;
        return (this.getInteger() == ((MixedNumber) o).getInteger() && this.getFraction() == ((MixedNumber) o).getFraction());
    }


    private static long gcd(long n, long d) {
        long n1 = Math.abs(n);
        long n2 = Math.abs(d);
        int gcd = 1;

        for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
        }

        return gcd;
    }
}
