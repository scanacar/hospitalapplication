public class Inpatient implements Examination {
    // Attributes
    final int INPATIENT_COST = 10;
    // overrided functions
    @Override
    public int cost() {
        return INPATIENT_COST;
    }

    @Override
    public Examination addoperation(Examination examination) {
        return examination;
    }

    @Override
    public String printoperations() {
        return "Inpatient";
    }

}
