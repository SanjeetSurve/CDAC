package hospital;

public class Patient {
    protected int patientId;
    protected int noOfDays;
    protected String patientName;
    public BedType bed;

    public Patient(int patientId, int noOfDays, String patientName, BedType bed) {
        this.patientId = patientId;
        this.noOfDays = noOfDays;
        this.patientName = patientName;
        this.bed = bed;
    }

    // Getter Methods
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return patientName;
    }

    public int getNumOfDays() {
        return noOfDays;
    }

    public BedType getBedType() {
        return bed;
    }

    // Setter Methods
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDays(int days) {
        this.noOfDays = days;
    }

    public void setBed(BedType bed) {
        this.bed = bed;
    }

    // Methods
    public int GetAmount() {

        int pricePerDay;
        switch (bed) {
            case STANDARD:
                pricePerDay = 350;
                break;
            case LUXURY:
                pricePerDay = 500;
                break;
            default:
                pricePerDay = 200;
                break;
        }
        return pricePerDay * noOfDays;
    }
}