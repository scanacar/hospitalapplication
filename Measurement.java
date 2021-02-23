public class Measurement extends ExaminationDecorator{
    // Attributes
    final int MEASUREMENT_COST = 5;
    int totalCost;
    String operations;

    public Measurement(Examination decoratedExamination) {
        super(decoratedExamination);
        totalCost = MEASUREMENT_COST + super.cost();
        operations = super.printoperations() + " measurements";
    }
    // overrided functions
    @Override
    public int cost() {
        return totalCost;
    }

    @Override
    public Examination addoperation(Examination examination) {
        return examination;
    }

    @Override
    public String printoperations() {
        return operations;
    }
}
