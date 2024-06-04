package com.model;


import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="Glycemies")
public class Glycemie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "glycemie_id")
private int id ;
@Column(name = "date")
private Date date;
@Column(name = "heure")
private Time heure;
@Column(name = "niveauGlycemie")
private float niveauGlycemie;
@ManyToOne
@JoinColumn(name = "patient_id")
private Patient patient;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}

}
