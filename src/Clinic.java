import java.util.Queue;
import java.util.LinkedList;   // LinkedList also implements Queue
import java.util.Set;
import java.util.HashSet;

class Clinic {

    private Queue<Patient> patientQueue;
    private Set<Patient> admittedPatients;
    private int dayCount;

    // Constructor to initialize the clinic with a queue and a set of admitted patients
    public Clinic() {
        this.patientQueue = new LinkedList<>();       // no patient in queue yet
        this.admittedPatients = new HashSet<>();      // no patient admitted yet
        this.dayCount = 1;    // Start with Day 1
    }


    // Admit a patient to the clinic
    public void admitPatient(Patient patient) {
        patientList.add(patient);
    }
    

    // Schedule appointments (maximum 3 patients per day)
    public void getSchedule() {
         int patientCountPerDay = 3; // Maximum patients per day
    int day = 1; // Start with Day 1
    int count = 0; // Counter to track patients scheduled on the current day

    for (Patient patient : queue) {
        if (admittedPatients.contains(patient)) {
            // Skip already admitted patients
            continue;
        }

        // Assign appointment day
        patient.setAppointmentDay("Day " + day);
        admittedPatients.add(patient);
        System.out.println("Scheduled " + patient.getName() + " on Day " + day);

        // Increment count and check if the day limit is reached
        count++;
        if (count == patientCountPerDay) {
            day++; // Move to the next day
            count = 0; // Reset the counter
        }
    }
    }


    // Provide treatment or prescription for a patient after their appointment
    public void providedTreatment(Patient patient, String treatment) {
         if (admittedPatients.contains(patient)) {
        // Provide treatment and update patient record
        patient.setTreatment(treatment);
        System.out.println("Treatment provided to " + patient.getName() + ": " + treatment);
    } else {
        // Patient not found in admitted list
        System.out.println("Patient not found in the admitted list.");
    }
    }


    // Get the details of a patient
    public void getPatientDetails(Patient patient) {
        if (admittedPatients.contains(patient)) {
        // Print patient details
        System.out.println("Patient Details:");
        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
        System.out.println("ID: " + patient.getId());
        System.out.println("Appointment Day: " + patient.getAppointmentDay());
        System.out.println("Treatment: " + patient.getTreatment());
    } else {
        // Patient not found in admitted list
        System.out.println("Patient not found in the admitted list.");
    }
    }


    // Get the appointment details of a patient
    public void getAppointmentDetails(Patient patient) {
         if (admittedPatients.contains(patient)) {
        // Print appointment details
        System.out.println("Appointment Details: " + patient.getName() + " is scheduled on " + patient.getAppointmentDay());
    } else {
        // Patient not found in admitted list
        System.out.println("Patient not found in the admitted list.");
    }
    }


    // Discharge a patient from the clinic
    public void dischargePatient(Patient patient) {
         if (admittedPatients.contains(patient)) {
        // Remove the patient from the admitted list
        admittedPatients.remove(patient);
        System.out.println("Patient " + patient.getName() + " discharged.");
    } else {
        // Patient not found in the admitted list
        System.out.println("Patient not found in the admitted list.");
    }
    }
}
