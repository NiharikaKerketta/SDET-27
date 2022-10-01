package Serialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.PojoObjectLibrary;
import pojo.PojoSpouseLibrary;

public class EmployeDetailsWithSpouse {
	@Test
	public void serialization() throws Throwable, Throwable, Throwable {
		PojoSpouseLibrary spouse = new PojoSpouseLibrary("xyz",8888, "abc");
		
		PojoObjectLibrary pObj = new PojoObjectLibrary("Niharika", "ywg012", spouse);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./objectJsonData"), pObj);
	}
}
