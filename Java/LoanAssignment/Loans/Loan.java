package Loans;

public abstract class Loan {
    protected double principal;
    protected float period;

    public Loan(double principal, float period) {
        this.principal = principal;
        this.period = period;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public float getPeriod() {
        return period;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public abstract float getRate();

    public double getEMI() {
        double rate = getRate();
        return (principal * (1 + (rate * period) / 100)) / (12 * period);
    }
}