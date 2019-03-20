package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file an map/convert to Java POJO:
			// data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first name an last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			
			//print out address: street and city
			Address address = theStudent.getAddress();
			
			System.out.println("Street = " + address.getStreet());
			System.out.println("City = " + address.getCity());
			
			//print out languages
			for(String tempLang: theStudent.getLanguages()) {
				System.out.println(tempLang);
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
