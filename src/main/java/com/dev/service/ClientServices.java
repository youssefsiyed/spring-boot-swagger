package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.entity.Client;
import com.dev.repository.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client AjoueClient(Client c){
		return clientRepository.save(c);
	}
	public List<Client> ListClients(){
		return clientRepository.findAll();
	}
	public Client AvoirClient(Long id){
		return clientRepository.findOne(id);
	}
	public void SupprimerClient(Long id){
		clientRepository.delete(id);
	}
	public Client ModifierClient(Client c,Long id){
		c.setIdClient(id);
		return clientRepository.saveAndFlush(c);
	}
}
