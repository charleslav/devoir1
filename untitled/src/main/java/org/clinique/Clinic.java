package org.clinique;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private TriageType doctorTriageType;
    private TriageType radiologyTriageType;
    private List<Patient> patientsMedecin;
    private List<Patient> patientsRadiologist;

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
        patientsMedecin = new ArrayList<>();
        patientsRadiologist = new ArrayList<>();
    }

    public void triagePatient(Patient patient) {

        patientsMedecin.add(patient);

        if (patient.getSymptoms().contains(VisibleSymptom.SPRAIN) || patient.getSymptoms().contains(VisibleSymptom.BROKEN_BONE)){
            patientsRadiologist.add(patient);
        }

    }

    public TriageType getDoctorTriageType() {
        return doctorTriageType;
    }

    public TriageType getRadiologyTriageType() {
        return radiologyTriageType;
    }

    public List<Patient> getPatientsMedecin() {
        return patientsMedecin;
    }

    public List<Patient> getPatientsRadiologist() {
        return patientsRadiologist;
    }
}
