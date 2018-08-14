package com.dev.testREST;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dev.controlor.ClientRest;
import com.dev.entity.Client;
import com.dev.repository.ClientRepository;
import com.dev.service.ClientServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ClientRest.class,secure=false)
public class SpringSwaggerApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClientServices clientServices;
	
	@Test
	public void testSaveClients() throws Exception{
		Client cl =new Client();
    	cl.setIdClient(1L);
    	cl.setAddressClient("Rabat");
    	cl.setNomClient("Amine");
    	cl.setAgeClient(10);
    	
    	String inputJson = this.mapToJson(mockMvc);
    	String url="/api/clients";
    	Mockito.when(clientServices.AjoueClient(Mockito.any(Client.class))).thenReturn(cl);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(url)
				.accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	/**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
    
}
