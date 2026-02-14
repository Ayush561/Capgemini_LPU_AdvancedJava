package Assignment;

import java.util.ArrayList;
import java.util.List;

public class HospitalService {

    public void registerPatientWithRecord(int pid, String name, int age, int contact,
                                          int rid, String bloodG, String allergies) {
        MedicalRecordDAO.insertMedicalRecord(rid, bloodG, allergies);
        MedicalRecord mr = MedicalRecordDAO.findMedicalRecord(rid);
        PatientDAO.savePatient(pid, contact, age, name, mr);
    }

    public void assignAppointmentToPatient(int aid, String date, double fee, int pid) {
        Patient p = PatientDAO.findPatient(pid);
        AppointmentDAO.insertAppointment(aid, date, fee, p);
    }

    public void addAppointmentsToDoctor(int did, String dname, String spec, List<Integer> appointmentIds) {
        List<Appointment> list = new ArrayList<>();
        for (int id : appointmentIds) {
            Appointment a = AppointmentDAO.findAppointment(id);
            if (a != null) list.add(a);
        }
        DoctorDAO.insertDoctor(did, dname, spec, list);
    }

    public Doctor fetchDoctor(int did) {
        return DoctorDAO.findDoctor(did);
    }

    public void updateAppointmentFee(int aid, double fee) {
        AppointmentDAO.updateFee(aid, fee);
    }

    public void deleteAppointment(int aid) {
        AppointmentDAO.deleteAppointment(aid);
    }

    public void deletePatient(int pid) {
        PatientDAO.deletePatient(pid);
    }

    public void deleteDoctor(int did) {
        DoctorDAO.deleteDoctor(did);
    }
}

