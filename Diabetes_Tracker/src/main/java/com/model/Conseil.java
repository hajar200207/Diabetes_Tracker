package com.model;

import javax.persistence.*;

@Entity
@Table(name = "conseils")
public class Conseil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conseil_id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "niveaux_max")
    private float niveauxMax;

    @Column(name = "niveaux_min")
    private float niveauxMin;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getNiveauxMax() {
		return niveauxMax;
	}

	public void setNiveauxMax(float niveauxMax) {
		this.niveauxMax = niveauxMax;
	}

	public float getNiveauxMin() {
		return niveauxMin;
	}

	public void setNiveauxMin(float niveauxMin) {
		this.niveauxMin = niveauxMin;
	}

	@Lob
    @Column(name = "photo")
    private byte[] photo;

    // Getters and setters
    // ...

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
