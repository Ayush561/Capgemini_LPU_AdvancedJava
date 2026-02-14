
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestHospital {

    HospitalService service = new HospitalService();

    @Test
    public void testOneToOne() {
        service.registerPatientWithRecord(101, "Alex", 30, 9999, 201, "A+", "Dust");
        Patient p = PatientDAO.findPatient(101);
        assertNotNull(p);
        assertNotNull(p.getRecord());
    }

    @Test
    public void testManyToOne() {
        service.registerPatientWithRecord(102, "Ben", 25, 8888, 202, "B+", "Smoke");
        service.assignAppointmentToPatient(301, "2026-02-14", 500, 102);

        Appointment a = AppointmentDAO.findAppointment(301);
        assertNotNull(a);
        assertNotNull(a.getPatient());
    }

    @Test
    public void testOneToMany() {
        service.registerPatientWithRecord(103, "Cara", 22, 7777, 203, "O+", "None");
        service.assignAppointmentToPatient(302, "2026-02-15", 400, 103);
        service.assignAppointmentToPatient(303, "2026-02-16", 450, 103);

        service.addAppointmentsToDoctor(401, "Dr. Jane", "Ortho", Arrays.asList(302, 303));

        Doctor d = service.fetchDoctor(401);
        assertNotNull(d);
    }

    @Test
    public void testUpdate() {
        service.registerPatientWithRecord(104, "Dan", 35, 6666, 204, "AB+", "Pollen");
        service.assignAppointmentToPatient(304, "2026-02-20", 1000, 104);

        service.updateAppointmentFee(304, 1200);

        Appointment a = AppointmentDAO.findAppointment(304);
        assertEquals(1200, a.getFee());
    }

    @Test
    public void testDelete() {
        service.registerPatientWithRecord(105, "Eva", 29, 5555, 205, "A-", "None");
        service.assignAppointmentToPatient(305, "2026-02-22", 900, 105);
        service.addAppointmentsToDoctor(402, "Dr. Ray", "Neuro", Arrays.asList(305));

        service.deleteAppointment(305);
        assertNull(AppointmentDAO.findAppointment(305));

        service.deletePatient(105);
        assertNull(PatientDAO.findPatient(105));

        service.deleteDoctor(402);
        assertNull(DoctorDAO.findDoctor(402));
    }
}
