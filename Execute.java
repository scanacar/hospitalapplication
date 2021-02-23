import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Execute {

    public static void printTotalCost(int admissionId, PrintStream output) {  // Printing totalCost
        int totalCost = 0;
        System.setOut(output);
        System.out.println("TotalCost for admission " + admissionId);
        for (Admission admission: Main.admissionList){
            if (admission.getId() == admissionId){
                System.setOut(output);
                System.out.println("\t" + admission.getExamination().printoperations() + " " + admission.getExamination().cost()+"$");
                totalCost += admission.getExamination().cost();
            }
        }
        System.setOut(output);
        System.out.println("\tTotal: " + totalCost+ "$");

    }

    public static void addExamination(int admissionId, String[] admissionInfo) { // Adding examination and creating object like
                                                                                // inpatient,outpatient,tests,imaging e.g
        Examination examination = null;

        if (admissionInfo[0].equals("Inpatient")){
            examination = new Inpatient();
        }else if (admissionInfo[0].equals("Outpatient")){
            examination = new Outpatient();
        }
        if (examination == null){
            return;
        }

        for (int i = 1; i < admissionInfo.length; i++) {
            if (admissionInfo[i].equals("tests")){
                examination = new Test(examination);
            }else if (admissionInfo[i].equals("doctorvisit")){
                examination = new DoctorVisit(examination);
            }else if (admissionInfo[i].equals("measurements")){
                examination = new Measurement(examination);
            }else if (admissionInfo[i].equals("imaging")){
                examination = new Imaging(examination);
            }
        }
        Admission admission = new Admission(admissionId, examination); // creating admission object
        Main.admissionList.add(admission); // adding admissions to admissionList
    }

    public static void listPatient(PrintStream output, PrintStream patientOut) { // printing list of patients
        ArrayList<Patient> patientArrayList = Main.patientDAO.listPatient();

        patientArrayList.sort(Comparator.comparing(Patient::getName)); // sorting by name
        System.setOut(output);
        System.out.println("Patient List:");
        for (Patient patient: patientArrayList){  // for output.txt
            System.setOut(output);
            System.out.println(patient.getId() +" "+ patient.getName() +" "+ patient.getSurname() +" "+
                    patient.getPhone_number() +" "+ patient.getAddress());
        }
        patientArrayList.sort(Comparator.comparing(Patient::getId)); // sorting by id
        for (Patient patient: patientArrayList){ // for patient.txt
            System.setOut(patientOut);
            System.out.println(patient.getId() +"\t"+ patient.getName() +" "+ patient.getSurname() +"\t"+
                    patient.getPhone_number() +"\t"+ patient.getAddress());
        }
    }

    public static void addPatient(String[] patientInfo) { // adding patient
        StringBuilder patientAddress = new StringBuilder();
        // address concatenate
        if (!patientInfo[4].equals("Address:")){
            patientAddress.append("Address: ");
        }
        for (int i = 4; i < patientInfo.length; i++) {
            patientAddress.append(patientInfo[i]);
            if(i != patientInfo.length-1){
                patientAddress.append(" ");
            }
        }
        //creating new patient
        Patient patient = new Patient(Integer.parseInt(patientInfo[0]), patientInfo[1], patientInfo[2], patientInfo[3], patientAddress.toString());
        Main.patientDAO.addPatient(patient); // adding patient
    }

    public static ArrayList<String> readFile(String path){ // reading file
        ArrayList<String> lines = new ArrayList<>();
        try{
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                lines.add(sc.nextLine());
            }
            sc.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }
}
