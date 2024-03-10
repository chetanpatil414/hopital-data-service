package com.hospital.repository;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospital.entity.DoctorsData;

@Repository
public interface DrDetailByDiseaseRepository extends JpaRepository<DoctorsData, Integer> {
	
	/*
	 * 1) Added @Param annotation to the disease parameter in the method signature
	 * to correctly bind the parameter in the query.
	 * 
	 * 2) Modified the @Query annotation to filter the results 
	 *  based on the speciality (or disease) parameter.
	 * 
	 * This assumes that the DoctorsData entity has a speciality property. Adjust
	 * the property name in the query if it's different.
	 */	
	 @Cacheable("doctorsBySpecialityCache")
	@Query("SELECT new map(d.drName as drName) FROM DoctorsData d WHERE d.speciality = :disease")
	List<Map<String,Object>> findBySpeciality(@Param("disease") String disease);

}
