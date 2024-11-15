package app.components;

public class PersonalLoan extends Loan implements Taxable {

    public PersonalLoan(double principal, float period) {
        super(principal, period);
    }

    @Override
    public float getRate() {
        return principal <= 500000 ? 15 : 16;
    }

    @Override
    public double getTax() {
        return getEMI() * 0.10;
    }
}