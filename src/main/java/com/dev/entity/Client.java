package com.dev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClient;
	@Column(name="Nom")
	private String nomClient;
	@Column(name="Address")
	private String addressClient;
	@Column(name="Age")
	private int ageClient;
	
	//////////////////////////////////////////////////////
	/////////////////////////////////////////////////////
	
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAddressClient() {
		return addressClient;
	}
	public void setAddressClient(String addressClient) {
		this.addressClient = addressClient;
	}
	public int getAgeClient() {
		return ageClient;
	}
	public void setAgeClient(int ageClient) {
		this.ageClient = ageClient;
	}
//////////////////////////////////////////////////////
	public Client()
	{
		
	}
	//////////////////////////////////////////////
	public Client(String nomClient, String addressClient, int ageClient) {
		super();
		this.nomClient = nomClient;
		this.addressClient = addressClient;
		this.ageClient = ageClient;
	}
/////////////////////////////////////////////////////
}
