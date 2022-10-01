package Serialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.PojoLibrary;

public class EmployeDetails {
	@Test
	public void serialization() throws Throwable, Throwable, Throwable {
		//create object for pojo class and pass the values
		PojoLibrary pObj = new PojoLibrary("Niharika", 90, 78965, "neha@gmail.com");
		
		//convert java object into json using object mapper class
		ObjectMapper mapper = new ObjectMapper();
		//print the json value in console
		System.out.println(mapper.writeValueAsString(pObj));
		
		//generate json file
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./jsonData1.json"), pObj);
	}
}
