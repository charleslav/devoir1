package org.clinique.domain;

public class Clinic {
    private TriageType doctorTriageType;
    private TriageType radiologyTriageType;

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        // TODO
    }


}
