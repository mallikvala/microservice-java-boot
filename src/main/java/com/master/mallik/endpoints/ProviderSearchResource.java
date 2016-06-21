package com.master.mallik.endpoints;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.master.mallik.models.Provider;
import com.master.mallik.service.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/mallik")
public class ProviderSearchResource {
	
	@Autowired
	ProviderService service;

    @RequestMapping(value = "/all",method = RequestMethod.GET,headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return new ResponseEntity<String>(mapper.writeValueAsString(service.getMockedProvider()), headers, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":\""+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
