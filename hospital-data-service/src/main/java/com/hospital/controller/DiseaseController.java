package com.hospital.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.dto.DiseaseResponseDto;
import com.hospital.entity.DoctorsData;
import com.hospital.repository.DiseaseRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DiseaseController {

	@Autowired
	DiseaseRepository diseaseRepository;

	@GetMapping("fetchAllDisease")
	public List<DiseaseResponseDto> getAllDisease() {
		List<DoctorsData> list = diseaseRepository.findAll();

		List<Object[]> distinctSpeciality = diseaseRepository.findDistinctSpeciality();

		List<Map<String, Object>> idAndSpeciality = diseaseRepository.findIdAndSpeciality();

		List<DiseaseResponseDto> collect = idAndSpeciality.stream().map(obj -> {
			DiseaseResponseDto diseaseResponseDto = new DiseaseResponseDto();
			diseaseResponseDto.setDisease((String) obj.get("speciality"));
			return diseaseResponseDto;

		}).collect(Collectors.toList());

		List<DiseaseResponseDto> diseaseResponseList = distinctSpeciality.stream().flatMap(Arrays::stream)
				.map(object -> {
					DiseaseResponseDto diseaseResponseDto = new DiseaseResponseDto();
					diseaseResponseDto.setDisease((String) object);
					return diseaseResponseDto;
				}).collect(Collectors.toList());

		return collect;
	}
}
