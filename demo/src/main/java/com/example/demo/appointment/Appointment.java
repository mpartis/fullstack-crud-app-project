package com.example.demo.appointment;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Appointment {
    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    private Long id;
    private String name;

    private String mail;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Appointment(){}

    // me to id
    public Appointment(Long id, String name, String mail, LocalDate date) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.date = date;
    }

    // xwris to id giati tha to kanei generate h vash
    public Appointment(String name, String mail, LocalDate date) {
        this.name = name;
        this.mail = mail;
        this.date = date;
    }


    // gia na metatrepetai swsta se JSON
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", date=" + date +
                '}';
    }
}
