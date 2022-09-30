package com.enniyal.service.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.enniyal.service.DTO.SettingsDTO;

public interface SettingsService {

	ResponseEntity<SettingsDTO> getCompanyInfo(String companyName);

	SettingsDTO addCompanyInfo(MultipartFile multipartBody, String request);

	SettingsDTO editCompanyInfo(MultipartFile file, String request);
}