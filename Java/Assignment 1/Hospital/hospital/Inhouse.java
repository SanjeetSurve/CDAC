package hospital;

public class Inhouse extends Patient {

    public double Discount;

    public Inhouse (int patientId, String patientName, int noOfDays, BedType bed, double Dis) {
        super(patientId, noOfDays, patientName, bed);

        Discount = Dis;
    }

    @Override
    public int GetAmount() {
        double Amt = super.GetAmount();
        System.out.println("\nGross Amount: " + Amt);
        double Dis = Amt >= 5000 ? Amt * 0.05: 0;
        System.out.println("\nDiscount: "+Dis);
        return (int) (Amt - Dis);
    }
    
}
