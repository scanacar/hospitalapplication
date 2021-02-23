public class DoctorVisit extends ExaminationDecorator {
    // Attributes (cost, totalCost, operations)
    final int DOCTOR_VISIT_COST = 15;
    int totalCost;
    String operations;

    public DoctorVisit(Examination decoratedExamination) {
        super(decoratedExamination);
        totalCost = DOCTOR_VISIT_COST + super.cost();
        operations = super.printoperations() + " doctorvisit";
    }

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
