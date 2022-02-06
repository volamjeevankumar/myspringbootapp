package com.example.demo.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exceptionfamily.BrandServiceException;

@Service
public class BrandValidationService {
	@Autowired
	private RestTemplate resttemplate;

	@Value("${brandservice.hostname}")
	private String brandServiceHostname;

	public boolean validateBrand(String brand) throws Exception {
		String brandLowerCase = brand.toLowerCase();
		URI uri=new URI(brandServiceHostname+"/brandsList");
		try {
		ResponseEntity<List<String>> brandNames =
		        resttemplate.exchange(uri,HttpMethod.GET,null,new ParameterizedTypeReference<List<String>>() {});
		if (brandNames.getBody().contains(brandLowerCase))
			return true;
		else
			return false;
	}
		catch(Exception e ) {
			throw new BrandServiceException("brand service changed code for new branch server not accessible");

		}
		finally {}

}
}
