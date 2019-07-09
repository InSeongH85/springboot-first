package kr.inek.tanbbang01.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.inek.tanbbang01.model.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeptControllerTest {

	@Autowired
	private MockMvc mockMvc;
	// Used for converting heroes to/from JSON
  private ObjectMapper mapper = new ObjectMapper();
  
	@Test
	public void retrieveDeptById() throws Exception {
		mockMvc.perform(get("/jpa/depts/1"))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$._links.all-depts").exists())
						.andExpect(jsonPath("$.code").exists())
						.andExpect(jsonPath("$.code").isString())
						.andExpect(jsonPath("$.name").exists())
						.andExpect(jsonPath("$.name").isString())
						.andExpect(jsonPath("$.myParentId").hasJsonPath())
						.andExpect(jsonPath("$.isActive").exists())
						.andExpect(jsonPath("$.isActive").isBoolean())
						.andExpect(jsonPath("$.lastUpdatorId").exists())
						.andExpect(jsonPath("$.lastUpdatorId").isNumber())
						.andExpect(jsonPath("$.dateCreated").exists())
						.andExpect(jsonPath("$.lastUpdated").exists())
						;
	}
	
	@Test
	public void retrieveAllDepts() throws Exception {
		MvcResult result = mockMvc.perform(get("/jpa/depts"))
						.andDo(print())
						.andExpect(status().isOk())
						.andReturn()
						;
		//TODO Spring Security Config 완료후  
		Dept[] depts = fromJsonResult(result, Dept[].class);
		assertThat(depts).isNotEmpty();
	}
	
	<T> T fromJsonResult(MvcResult result, Class<T> tClass) throws Exception {
		return this.mapper.readValue(result.getResponse().getContentAsString(), tClass);
	}

	private byte[] toJson(Object object) throws Exception {
		return this.mapper.writeValueAsString(object).getBytes();
	}
	
}
