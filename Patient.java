public class Patient {
    // Attributes (contains patientId,name,surname,address,phone and admissionId(initial -1))
    private int id;
    private String surname;
    private String name;
    private String address;
    private String phone_number;
    private int admissionId=-1;

    public Patient(int id, String name, String surname, String phone_number, String address) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }
    // Getter setters
    public int getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
