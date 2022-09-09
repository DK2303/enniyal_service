package com.enniyal.service.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.enniyal.service.DTO.AddOrganizeDTO;
import com.enniyal.service.DTO.ResponseDTO;

@Service
public class OrganizerServiceImpl implements OrganizerService{

	@Value("${enniyal.addOrganizers}")
	private String addOrganizerUrl;
	@Override
	public ResponseDTO addOrganizer(AddOrganizeDTO addOrganizeDTO) {
	   JSONObject jsonObject = new JSONObject(addOrganizeDTO);
	   ResponseDTO responseDto = null;
	   RestTemplate restTemplate = new RestTemplate();
	   HttpHeaders header = new HttpHeaders();
	   header.setContentType(MediaType.APPLICATION_JSON);
	   HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(),header);
	   try {
		 String response =   restTemplate.postForObject(addOrganizerUrl, request, String.class);
		 System.out.println(response);
		 
		 JSONObject resObject = new JSONObject(response);
		 responseDto = new ResponseDTO(resObject.getString("status"),resObject.getString("description"),resObject.getString("organiserId"));
	   } catch (Exception e) {
		   
	   }
	   
		return responseDto;
	}

//	@Override
//	public List<GetOrganizerProjection> getOrganizer(Long companyId, Long organizerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
