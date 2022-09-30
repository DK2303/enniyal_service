package com.enniyal.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.enniyal.service.DTO.SettingsDTO;
import com.enniyal.service.services.SettingsService;
import com.ibm.websphere.jaxrs20.multipart.IMultipartBody;

@RestController
@RequestMapping("/api/v1/company")
public class SettingsController {
	
	
	@Autowired
	private SettingsService settingsService;
	
	
	@PostMapping("/add")
	public SettingsDTO addCompanyInfo(@RequestPart("file") MultipartFile file, @RequestPart("request") String request) {
		System.out.println("Inside Controller");
		System.out.println(request);
		return settingsService.addCompanyInfo(file,request);
	}
	
	@GetMapping("/get/{companyName}")
	public ResponseEntity<SettingsDTO> getCompanyInfo(@PathVariable("companyName") String companyName) {
		return settingsService.getCompanyInfo(companyName);
	}
	
	@PutMapping("/put")
	public SettingsDTO putCompanyInfo(@RequestPart("file") MultipartFile file, @RequestPart("request") String request) {
		System.out.println("Inside Controller");
		System.out.println(request);
		return settingsService.editCompanyInfo(file,request);
	}
	
	@DeleteMapping("delete")
	public void deleteComapnyInfo() {
		
	}
	

}
