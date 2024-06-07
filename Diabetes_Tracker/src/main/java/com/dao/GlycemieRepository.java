package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Glycemie;

public interface GlycemieRepository  extends CrudRepository<Glycemie, Integer>{
	List<Glycemie> findByPatientId(int patientId);
}
