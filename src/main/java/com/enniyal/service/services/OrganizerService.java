package com.enniyal.service.services;

import com.enniyal.service.DTO.AddOrganizeDTO;
import com.enniyal.service.DTO.ResponseDTO;

public interface OrganizerService {

	ResponseDTO addOrganizer(AddOrganizeDTO addOrganizeDTO);

	//List<GetOrganizerProjection> getOrganizer(Long companyId, Long organizerId);

}
