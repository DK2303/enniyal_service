package com.enniyal.service.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.enniyal.service.DTO.SettingsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SettingsServiceImpl implements SettingsService {

	@Value("${enniyal.getCompany}")
	private String getCompanyUrl;

	@Value("${enniyal.addCompany}")
	private String addCompanyUrl;

	@Value("${enniyal.editCompany}")
	private String editCompanyUrl;

	@Override
	public ResponseEntity<SettingsDTO> getCompanyInfo(String companyName) {
		ResponseEntity<SettingsDTO> response = null;
		try (RestTemplate restTemplate = new RestTemplate()) {
			response = restTemplate.getForEntity(getCompanyUrl + "/" + companyName, SettingsDTO.class);
			System.out.println(response);
			response.getBody().setCompanyLogo(decompressBytes(response.getBody().getCompanyLogo()));
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;

	}

	@Override
	public SettingsDTO addCompanyInfo(MultipartFile multipartBody, String request) {
		SettingsDTO settingsJson = new SettingsDTO();
		SettingsDTO response = null;
		try {
			ObjectMapper om = new ObjectMapper();
			settingsJson = om.readValue(request, SettingsDTO.class);
			System.out.println(settingsJson);

			settingsJson.setFileName(multipartBody.getOriginalFilename());
			settingsJson.setFileType(multipartBody.getContentType());
			settingsJson.setCompanyLogo(compressBytes(multipartBody.getBytes()));
			try (RestTemplate restTemplate = new RestTemplate()) {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<SettingsDTO> requestData = new HttpEntity<SettingsDTO>(settingsJson, header);
				response = restTemplate.postForObject(addCompanyUrl, requestData, SettingsDTO.class);
				System.out.println(response);
				response.setCompanyLogo(decompressBytes(response.getCompanyLogo()));
				return response;
			}
		} catch (Exception e) {

		}
		return response;

	}

	@Override
	public SettingsDTO editCompanyInfo(MultipartFile multipartBody, String request) {
		SettingsDTO settingsJson = new SettingsDTO();
		SettingsDTO response = null;
		try {
			ObjectMapper om = new ObjectMapper();
			settingsJson = om.readValue(request, SettingsDTO.class);
			System.out.println(settingsJson);

			settingsJson.setFileName(multipartBody.getOriginalFilename());
			settingsJson.setFileType(multipartBody.getContentType());
			settingsJson.setCompanyLogo(compressBytes(multipartBody.getBytes()));
			try (RestTemplate restTemplate = new RestTemplate()) {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<SettingsDTO> requestData = new HttpEntity<SettingsDTO>(settingsJson, header);
				response = restTemplate.postForObject(editCompanyUrl, requestData, SettingsDTO.class);
				System.out.println(response);
				response.setCompanyLogo(decompressBytes(response.getCompanyLogo()));
				return response;
			}
		} catch (Exception e) {

		}
		return response;

	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

//	private String getDataFromStream(InputStream stream) throws IOException {
//		StringBuilder sb = new StringBuilder();
//		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
//		String line = null;
//		try {
//			while ((line = br.readLine()) != null) {
//				sb.append(line);
//			}
//		} catch (IOException e) {
//			throw new IOException(e);
//		}
//		if (stream != null) {
//			stream.close();
//		}
//		return sb.toString();
//	}

}
