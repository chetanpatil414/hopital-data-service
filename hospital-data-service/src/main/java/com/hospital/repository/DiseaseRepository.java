package com.hospital.repository;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.entity.DoctorsData;
@Repository
public interface DiseaseRepository extends JpaRepository<DoctorsData, Integer>{
	
//	@Cacheable("distinctSpeciality")
//    @Query("SELECT DISTINCT d.speciality FROM DoctorsData d")
//    List<Object[]> findDistinctSpeciality();
    
    @Cacheable("idAndSpeciality")
    @Query("SELECT new map(d.id as id, d.speciality as speciality) FROM DoctorsData d")
    List<Map<String,Object>> findIdAndSpeciality();

}
