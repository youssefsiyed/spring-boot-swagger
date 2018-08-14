package com.dev.controlor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.entity.Client;
import com.dev.service.ClientServices;

@RestController
public class ClientRest {

	@Autowired
	private ClientServices clientservice;
	
	/////////////////////////////////////////////////////
	@GetMapping(value="/api/clients")
	public List<Client> AllClient(){
		return clientservice.ListClients();
	}
    /////////////////////////////////////////////////
	@GetMapping(value="/api/clients/{id}")
	public Client GetClient(@PathVariable("id")Long id){
	return clientservice.AvoirClient(id);
	}
	
	/////////////////////////////////////////////////////
	@PostMapping(value="/api/clients")
	public Client AddClient(@RequestBody Client c){
	return clientservice.AjoueClient(c);
	}
	
	/////////////////////////////////////////////////////
	@PutMapping(value="/api/clients/{id}")
	public Client UpdateClient(@RequestBody Client c,@PathVariable("id")Long id){
	return clientservice.ModifierClient(c, id);
	}
	
	/////////////////////////////////////////////////////
	@DeleteMapping(value="/api/clients/{id}")
	public void DeleteClient(@PathVariable("id")Long id){
	 clientservice.SupprimerClient(id);;
	}
}
