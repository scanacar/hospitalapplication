import java.io.PrintStream;
import java.util.ArrayList;
// patient data access object
public interface PatientDAO {
    // prototype of functions
    void removePatient(int patientId, PrintStream output);
    ArrayList<Patient> listPatient();
    void addPatient(Patient patient);
    void createAdmission(int patientId, int admissionId);
}
