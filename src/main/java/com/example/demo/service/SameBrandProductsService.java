package com.example.demo.service;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.response.BulkProductsResponse;
import com.example.demo.entity.response.ProductResponse;
import com.example.demo.repo.Productrepo;
@Component
public class SameBrandProductsService {
	@Autowired
	Productrepo productrepo;
	
	private BulkProductsResponse bulkproductresponseobject=new BulkProductsResponse();
	public BulkProductsResponse sameBrandProductsMethod(String brandName){
	List<ProductResponse> products=productrepo.findByBrandmarketchannelBrand(brandName);
	System.out.println(products.get(0));
	System.out.println(products.get(1));
	System.out.println(products.get(0).equals(products.get(1)));
	bulkproductresponseobject.setProducts(products);
	Collections.sort(bulkproductresponseobject.getProducts(),(p1,p2)->
		{return p1.getDescription().compareTo(p2.getDescription());});
	return bulkproductresponseobject;
	}}
