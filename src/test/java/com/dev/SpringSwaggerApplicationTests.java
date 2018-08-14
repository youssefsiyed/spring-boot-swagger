package com.dev;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dev.repository.ClientRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringSwaggerApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ClientRepository clientRepository;
	
	@Test
	public void contextLoads() throws Exception {
		Mockito.when(clientRepository.findAll()).thenReturn(Collections.emptyList());
		
		MvcResult  mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/api/clients")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
	    
		System.out.println(mvcResult.getResponse());
		Mockito.verify(clientRepository).findAll();
	
	}

}
