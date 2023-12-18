package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entity.DoctorsData;
import com.hospital.repository.DiseaseRepository;

@RestController
@RequestMapping("/api")
public class DiseaseController {

	@Autowired
	DiseaseRepository diseaseRepository;

	@GetMapping("fetchAllDisease")
	public List<Object[]> getAllDisease() {
		List<DoctorsData> list = diseaseRepository.findAll();
		List<Object[]> distinctSpeciality = diseaseRepository.findDistinctSpeciality();

		return distinctSpeciality;
	}
}
