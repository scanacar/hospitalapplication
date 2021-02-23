import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Main{

    final static PatientDAO patientDAO = new PatientDaoImp(); //Creating DAO
    final static ArrayList<Admission> admissionList = new ArrayList<>(); //Creating admissionList that holds admissions

    public static void main(String[] args) throws FileNotFoundException { //Main functions

        // Reading file into arraylists
        ArrayList<String> inputLines = Execute.readFile(args[0]);
        ArrayList<String> admissionLines = Execute.readFile("admission.txt");
        ArrayList<String> patientLines = Execute.readFile("patient.txt");
        // For output files
        PrintStream output = new PrintStream(new File("output.txt"));
        PrintStream patientOut = new PrintStream(new File("patient.txt"));

        // initilize the patientId and admissionId
        int patientId;
        int admissionId=-1;

        // Reading admission.txt and creating examination-admission
        for (String line: admissionLines){
            String[] tempLine = line.split("\\s+");
            if(tempLine[0].equals("Inpatient") || tempLine[0].equals("Outpatient") ){
                Execute.addExamination(admissionId, tempLine);
            }else {
                patientId = Integer.parseInt(tempLine[1]);
                admissionId = Integer.parseInt(tempLine[0]);
                patientDAO.createAdmission(patientId, admissionId);
            }
        }
        // Reading patient.txt and adding patient
        for (String line: patientLines){
            String[] patientLine = line.split("\\s+");
            Execute.addPatient(patientLine);
        }
        // Reading input.txt and execute operations
        for(String line: inputLines){
            String[] tempLine = line.split(" ");
            if(tempLine[0].equals("AddPatient")){ // Adding patient
                String[] patientInfo = new String[tempLine.length-1]; // for ignoring AddPatient
                for (int i = 0; i < patientInfo.length; i++) {
                    patientInfo[i] = tempLine[i+1];
                }
                System.setOut(output);
                System.out.println("Patient "+Integer.parseInt(patientInfo[0])+" "+patientInfo[1]+" added");
                Execute.addPatient(patientInfo);
            }else if(tempLine[0].equals("RemovePatient")){  // removing patient
                patientId = Integer.parseInt(tempLine[1]);
                patientDAO.removePatient(patientId, output);
            }else if(tempLine[0].equals("CreateAdmission")){ // creating admission
                patientId = Integer.parseInt(tempLine[2]);
                admissionId = Integer.parseInt(tempLine[1]);
                System.setOut(output);
                System.out.println("Admission "+admissionId+" created");
                patientDAO.createAdmission(patientId, admissionId);
            }else if(tempLine[0].equals("AddExamination")){  // adding examination
                admissionId = Integer.parseInt(tempLine[1]);
                String[] admissionInfo = new String[tempLine.length-2];  // for ignoring admissionId and AddExamination

                if (tempLine[2].equals("Inpatient")){
                    System.setOut(output);
                    System.out.println("Inpatient examination added to admission "+admissionId);
                }
                else if(tempLine[2].equals("Outpatient")){
                    System.setOut(output);
                    System.out.println("Outpatient examination added to admission "+admissionId);
                }
                // ignore AddExamination and create Examination
                if (admissionInfo.length >= 0) System.arraycopy(tempLine, 2, admissionInfo, 0, admissionInfo.length);
                Execute.addExamination(admissionId,admissionInfo);
            }else if(tempLine[0].equals("TotalCost")){
                admissionId = Integer.parseInt(tempLine[1]);
                Execute.printTotalCost(admissionId, output);  // calling printTotalCost function
            }else if(tempLine[0].equals("ListPatients")){
                Execute.listPatient(output, patientOut);  // calling listPatient function
            }
        }

    }
}