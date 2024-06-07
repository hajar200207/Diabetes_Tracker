package com.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "glycemies")
public class Glycemie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "glycemie_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    private int patientId;

    public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Column(name = "date")
    private Date date;

    @Column(name = "heure")
    private Time heure;

    @Column(name = "niveau_glycemie")
    private float niveauGlycemie;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public float getNiveauGlycemie() {
        return niveauGlycemie;
    }

    public void setNiveauGlycemie(float niveauGlycemie) {
        this.niveauGlycemie = niveauGlycemie;
    }
}