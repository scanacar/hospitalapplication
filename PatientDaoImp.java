import java.io.PrintStream;
import java.util.ArrayList;

public class PatientDaoImp implements PatientDAO {
    // patient arraylist
    private ArrayList<Patient> patientList;

    public PatientDaoImp() {
        this.patientList = new ArrayList<>();
    } // initialize the arraylist

    // remove patient function
    @Override
    public void removePatient(int patientId, PrintStream output) {
        int index=-1;
        for (int i = 0; i < patientList.size() ; i++) {
            if (patientList.get(i).getId() == patientId){
                System.setOut(output);
                System.out.println("Patient "+patientList.get(i).getId()+" "+patientList.get(i).getName()+" removed");
                index = i;
            }
        }
        if(index == -1){
            return;
        }

        patientList.remove(index);  // remove from arraylist
    }

    @Override
    public ArrayList<Patient> listPatient() {
        return patientList;
    }

    @Override
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    @Override
    public void createAdmission(int patientId, int admissionId) {  // creating admission
        for (Patient patient: patientList){
            if(patient.getId() == patientId){
                patient.setAdmissionId(admissionId);
            }
        }
    }
}
