package org.clinique;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {

    private Clinic clinic;
    private static Patient patientBrokenBones;
    private static Patient patientSprain;
    private static Patient patientFlu;

    @BeforeAll
    public static void setup(){
        patientFlu = new Patient("", 0, List.of(VisibleSymptom.FLU));
        patientSprain = new Patient("", 0, List.of(VisibleSymptom.SPRAIN));
        patientBrokenBones = new Patient("", 0, List.of(VisibleSymptom.BROKEN_BONE));
    }

    @BeforeEach
    public void beforeEach(){
        this.clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);
    }



    @Test
    public void givenClinic_whenInstantiate_thenMedecinPatientListShouldBeEmpty(){
        assert(clinic.getPatientsMedecin()).isEmpty();
    }

    @Test
    public void givenClinic_whenInstantiate_thenRadiologistPatientListShouldBeEmpty(){
        assert(clinic.getPatientsRadiologist()).isEmpty();
    }

    @Test
    public void givenPatient_whenTriagePatient_thenAddPatientToMedecinPatientList(){
        clinic.triagePatient(patientFlu);

        assertEquals(1, clinic.getPatientsMedecin().size());
    }

    @Test
    public void givenSpain_whenTriagePatient_thenAddPatientToPatientList(){
        clinic.triagePatient(patientSprain);

        assertEquals(1, clinic.getPatientsRadiologist().size());
        assertEquals(1, clinic.getPatientsMedecin().size());
    }

    @Test
    public void givenBrokenBone_whenTriagePatient_thenAddPatientToPatientList(){
        clinic.triagePatient(patientBrokenBones);

        assertEquals(1, clinic.getPatientsRadiologist().size());
        assertEquals(1, clinic.getPatientsMedecin().size());
    }

    @Test
    public void givenFlu_whenTriagePatient_thenNotAddPatientToRadiologistList(){
        clinic.triagePatient(patientFlu);

        assertEquals(0, clinic.getPatientsRadiologist().size());
    }

    @Test
    public void given2Patients_whenTriageSecondPatient_thenAddAtSecondPatientToMedecinListEnd(){
        clinic.triagePatient(patientSprain);
        clinic.triagePatient(patientFlu);

        assertEquals(patientFlu, clinic.getPatientsMedecin().get(1));
    }

    @Test
    public void given2Patients_whenTriageSecondPatient_thenAddAtSecondPatientToRadiologistListEnd(){
        clinic.triagePatient(patientBrokenBones);
        clinic.triagePatient(patientSprain);

        assertEquals(patientSprain, clinic.getPatientsRadiologist().get(1));
    }
}