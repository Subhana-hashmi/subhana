package com.example.controller;
import java.text.SimpleDateFormat;
import java.util.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.productModel;
import com.example.repository.productRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping(value="/product")
public class productController{
	
	@SuppressWarnings("unused")
	private static final Logger Log=LoggerFactory.getLogger(productController.class);
	
	@Autowired
	private productRepository productrepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String get() throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();
			List<productModel> product=productrepository.findActive();
		return mapper.writeValueAsString(product);
	}
	
	@RequestMapping(value="/all",  method=RequestMethod.GET)
	public String getAll() throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();
			List<productModel> product=productrepository.findAll();
		return mapper.writeValueAsString(product);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getOne(@PathVariable long id) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();
			productModel product=productrepository.findOne(id);
		return mapper.writeValueAsString(product);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String getBySearch(@RequestBody String data) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();
		JSONObject object=new JSONObject(data);
			List<productModel> product=productrepository.findBySearch(object.getString("search"));
		return mapper.writeValueAsString(product);
	}
	
	
	@RequestMapping( method=RequestMethod.POST)
	public  String insert(@RequestBody String data) throws JsonProcessingException{
		SimpleDateFormat format1=new SimpleDateFormat("dd/MMM/YYYY  HH:mm:ss");
		Date date=new Date();
		ObjectMapper mapper=new ObjectMapper();
		productModel product=new productModel();
		JSONObject object = new JSONObject(data);
		if(!object.has ("PRODCT_NAME"))
		return  "product name is missing";
	
		product.setPRODUCT_NAME(object.getString("PRODUCT_NAME"));
		product.setPRODUCT_COMPANY(object.getString("PRODUCT_COMPANY"));
		product.setPRICE(object.getInt("PRICE"));
		product.setISACTIVE("Y");
		product.setMODIFIED_BY("A");
		product.setMODIFIED_WHEN(format1.format(date));
		product.setMODIFIED_WORKSTATION("N");
		product=(productModel) productrepository.saveAndFlush(product);
		return mapper.writeValueAsString(product);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
			productModel product=productrepository.findOne(id);
			productrepository.delete(product);
		return "RECORD IS DELETED";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String UPDATE(@PathVariable Long id, @RequestBody String data) throws JsonProcessingException{
		SimpleDateFormat format1=new SimpleDateFormat("dd/MMM/YYYY  HH:mm:ss");
				Date date=new Date();
				ObjectMapper mapper=new ObjectMapper();
				productModel product=new productModel();
				JSONObject object = new JSONObject(data);
				if(!object.has ("PRODCT_NAME")) {
			product.setPRODUCT_NAME(object.getString("PRODUCT_NAME"));
				}
				if(!object.has ("IS_ACTIVE")) {
					product.setISACTIVE(object.getString("iS_ACTIVE"));
				}
				product.setMODIFIED_BY("A");
					product.setMODIFIED_WHEN(format1.format(date));
				
				product=productrepository.saveAndFlush(product);
				return mapper.writeValueAsString(product);
	}
	
}



	
	
