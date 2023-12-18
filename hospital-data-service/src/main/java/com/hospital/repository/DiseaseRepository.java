package com.hospital.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.entity.DoctorsData;
@Repository
public interface DiseaseRepository extends JpaRepository<DoctorsData, Integer>{
	

    @Query("SELECT DISTINCT d.speciality FROM DoctorsData d")
    List<Object[]> findDistinctSpeciality();

}
