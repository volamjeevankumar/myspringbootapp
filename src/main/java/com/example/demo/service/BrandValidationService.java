package com.example.demo.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public boolean validateBrand(String brand) throws Exception {
		String brandLowerCase = brand.toLowerCase();
		URI uri=new URI("http://localhost:8090/brandsList");
		try {
		ResponseEntity<List<String>> brandNames =
		        resttemplate.exchange(uri,HttpMethod.GET,null,new ParameterizedTypeReference<List<String>>() {});
		if (brandNames.getBody().contains(brandLowerCase))
			return true;
		else
			return false;
	}
		catch(Exception e ) {
			throw new BrandServiceException("brand service server not accessible");
			
		}
		finally {}

}
}
