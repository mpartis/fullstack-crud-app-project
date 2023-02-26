package com.example.demo.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @CrossOrigin
    @GetMapping()
    public List<Appointment> getAppointments() {return appointmentService.getAppointments();}

    @CrossOrigin
    @PostMapping()
    public void registerNewAppointment(@RequestBody Appointment appointment){
        appointmentService.addNewAppointment(appointment);
    }

    @CrossOrigin
    @DeleteMapping(path = "{appointmentId}")
    public void deleteAppointment(@PathVariable("appointmentId") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
    }

    @CrossOrigin
    @PutMapping(path = "{appointmentId}")
    public void updateAppointment(@PathVariable("appointmentId") Long appointmentId,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String mail,
                                  @RequestParam(required = false)LocalDate date) {
        appointmentService.updateAppointment(appointmentId, name, mail, date);
    }

}
