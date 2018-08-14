package com.dev.testDAO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dev.entity.Client;
import com.dev.repository.ClientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringSwaggerApplicationTests {

	@Autowired
	private TestEntityManager EntityManager;
	@Autowired
	private ClientRepository clientRepository;
	
	@Test
	public void testSaveClients(){
		Client cls = getClient();
		Client saveInDB =EntityManager.persist(cls);
		Client getFromDB =clientRepository.findOne(saveInDB.getIdClient());
		
		assertThat(getFromDB).isEqualTo(saveInDB);
	}
    private Client getClient(){
    	Client cl =new Client();
    	cl.setIdClient(1L);
    	cl.setAddressClient("Rabat");
    	cl.setNomClient("Amine");
    	cl.setAgeClient(10);
    	return cl;
    }
    
}
