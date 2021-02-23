public class Admission {
    // Attributes (holding admissionId and Examination objects)
    private final int id;
    private final Examination examination;

    public Admission(int admissionId, Examination examination) {
        this.examination = examination;
        id = admissionId;
    }

    int getId(){return id;}

    Examination getExamination(){return examination;};


}
