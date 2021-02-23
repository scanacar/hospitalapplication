public class Outpatient implements Examination {
    // Attributes
    final int OUTPATIENT_COST = 15;

    // Overrided functions
    @Override
    public int cost() {
        return OUTPATIENT_COST;
    }

    @Override
    public Examination addoperation(Examination examination){
        return examination;
    }

    @Override
    public String printoperations() {
        return "Outpatient";
    }

}
