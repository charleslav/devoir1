package org.clinique;

import java.util.List;

public class Patient {
    private String name;
    private int gravity;
    private List<VisibleSymptom> symptoms;

    public Patient(String name, int gravity, List<VisibleSymptom> symptoms) {
        this.name = name;
        this.gravity = gravity;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public int getGravity() {
        return gravity;
    }

    public List<VisibleSymptom> getSymptoms() {
        return symptoms;
    }
}
