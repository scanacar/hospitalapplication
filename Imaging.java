public class Imaging extends ExaminationDecorator{
    // Attributes
    final int IMAGING_COST = 10;
    int totalCost;
    String operations;

    public Imaging(Examination decoratedExamination) {
        super(decoratedExamination);
        totalCost = IMAGING_COST + super.cost();
        operations = super.printoperations() + " imaging";
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
