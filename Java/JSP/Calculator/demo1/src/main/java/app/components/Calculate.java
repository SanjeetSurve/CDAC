package app.components;

public class Calculate {
    private int amt; // Changed to lowercase
    private int yr;  // Changed to lowercase

    // Getter and setter methods
    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public int getYr() {
        return yr;
    }

    public void setYr(int yr) {
        this.yr = yr;
    }

    public synchronized double getCal() {
        return amt * yr * 0.08;
    }
}