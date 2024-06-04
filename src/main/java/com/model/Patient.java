package com.model;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="patients")
public class Patient {
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name="age")
	private int age;
	@Column(name="taille")
	private int taille;
	@Column(name="poids")
	private float poids;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	 @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	    private List<Glycemie> lecturesGlycemie;

	    // Getters and Setters

	    public void saisirLectureGlycemie(Date date, Time heure, float niveauGlycemie) {
	        Glycemie lecture = new Glycemie();
	        lecture.setDate(date);
	        lecture.setHeure(heure);
	        lecture.setNiveauGlycemie(niveauGlycemie);
	        lecture.setPatient(this);
	        this.lecturesGlycemie.add(lecture);
	    }

	    public void modifierLesInformationsPersonnelles(String nom, int age, int taille, int poids) {
	        this.nom = nom;
	        this.age = age;
	        this.taille = taille;
	        this.poids = poids;
	    }
	}


