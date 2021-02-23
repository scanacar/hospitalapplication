public class Test extends ExaminationDecorator {
    // Attributes
    final int TEST_COST = 7;
    int totalCost;
    String operations;

    public Test(Examination decoratedExamination) {
        super(decoratedExamination);
        totalCost = TEST_COST + super.cost();
        operations = super.printoperations() + " tests";
    }
    // Overrided functions
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
