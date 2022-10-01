package Serialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.PojoArrayLibrary;

public class EmployeArrayDetails {
	
	@Test
	public void serialization() throws Throwable, Throwable, Throwable {
		
		int[] arr = {9999,7777,8888};
		PojoArrayLibrary pObj = new PojoArrayLibrary("Niharika","neha@gmail.com",arr);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./arrayJsonData"), pObj);
	}
}
