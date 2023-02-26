package com.example.demo.appointment;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppointments() { return appointmentRepository.findAll(); }

    public void addNewAppointment(Appointment appointment) {
        Optional<Appointment> appointmentOptional = appointmentRepository.
                findAppointmentByName(appointment.getName());
        if (appointmentOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        appointmentRepository.save(appointment);
        System.out.println(appointment);
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.findById(appointmentId);
        boolean exists = appointmentRepository.existsById(appointmentId);
        if (!exists) {
            throw new IllegalStateException("Appointment with id " + appointmentId + "does not exists");
        }
        appointmentRepository.deleteById(appointmentId);
    }

    @Transactional
    public void updateAppointment(Long appointmentId, String name, String mail, LocalDate date){
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Appointment with id " + appointmentId + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(appointment.getName(), name)) {
            appointment.setName(name);
        }

        if (mail != null && mail.length() > 0 && !Objects.equals(appointment.getMail(), mail)) {
            appointment.setMail(mail);
        }

        if (date != null && !Objects.equals(appointment.getDate(), date)){
            // edw mporw na paiksw mpala an einai taken to date
            appointment.setDate(date);
        }
    }
}
