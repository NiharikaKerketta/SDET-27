package Serialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.PojoLibrary;

public class Deserialization {
	@Test
	public void deserialization() throws Throwable, Throwable, Throwable {
		ObjectMapper mapper = new ObjectMapper();
		PojoLibrary pObj = mapper.readValue(new File("./jsonData.json"), PojoLibrary.class);
		
		System.out.println(pObj.name);
		System.out.println(pObj.id);
		System.out.println(pObj.phoneNo);
		System.out.println(pObj.emailId);
	}
}
