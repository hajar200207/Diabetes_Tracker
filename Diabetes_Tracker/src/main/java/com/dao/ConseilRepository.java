package com.dao;

import com.model.Conseil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConseilRepository extends CrudRepository<Conseil, Integer> {
   
}

