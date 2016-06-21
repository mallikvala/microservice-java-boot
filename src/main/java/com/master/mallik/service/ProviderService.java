package com.master.mallik.service;

import org.springframework.stereotype.Component;

import com.master.mallik.models.Provider;

@Component
public class ProviderService {
	
	public Provider getMockedProvider(){
		Provider p = new Provider();
		p.setName("Tieto Boys Rock!");
		return p;
	}

}
