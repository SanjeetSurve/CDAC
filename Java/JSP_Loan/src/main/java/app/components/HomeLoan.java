package app.components;

public class HomeLoan extends Loan implements Discountable {

    public HomeLoan(double principal, float period) {
        super(principal, period);
    }

    @Override
    public float getRate() {
        if (principal <= 2000000) {
            return 10;
        } else if (principal > 2000000 && principal <= 5000000) {
            return 11;
        } else {
            return 12; 
        }
    }

    @Override
    public double getDiscount() {
        return getEMI() * 0.05; 
    }
}