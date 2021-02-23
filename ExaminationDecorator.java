public abstract class ExaminationDecorator implements Examination {
    // creating decorated object from Examination
    protected Examination decoratedExamination;
    // Constructor
    ExaminationDecorator(Examination decoratedExamination){
        this.decoratedExamination = decoratedExamination;
    }
    // cost function
    public int cost(){
        return decoratedExamination.cost();
    }
    // printoperations function
    public String printoperations(){
        return decoratedExamination.printoperations();
    }
}
