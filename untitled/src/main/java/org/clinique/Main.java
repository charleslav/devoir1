package org.clinique;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TriageType doctorTriageType = TriageType.FIFO;
        TriageType radiologyTriageType = TriageType.FIFO;



         Clinic clinic = new Clinic(doctorTriageType, radiologyTriageType);
         Patient patient = new Patient("John", 4, List.of(VisibleSymptom.MIGRAINE));
         clinic.triagePatient(patient);
    }

}