package com.hospital.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.dto.DrNameResponsedto;
import com.hospital.repository.DrDetailByDiseaseRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
public class DrDetailFromDiseaseController {

	@Autowired
	DrDetailByDiseaseRepository byDiseaseRepository;

	@GetMapping("/drNameByDisease")
	@Transactional	
	public ResponseEntity<List<DrNameResponsedto>> getDrNameByDisease(@RequestParam("disease") String disease) {
		try {
		List<Map<String, Object>> bySpeciality = byDiseaseRepository.findBySpeciality(disease);
		List<DrNameResponsedto> collect = bySpeciality.stream().map(data -> {
			DrNameResponsedto drNameResponsedto = new DrNameResponsedto();
			drNameResponsedto.setName((String) data.get("drName"));
			return drNameResponsedto;
		}).collect(Collectors.toList());
		return new ResponseEntity<>(collect, HttpStatus.OK);
		}catch(Exception e) {
			log.error("An error occurred while processing the request: {}", e.getMessage(), e);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
