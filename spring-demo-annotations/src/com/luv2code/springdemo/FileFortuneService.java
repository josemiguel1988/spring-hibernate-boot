//Practice Activity #5 - Dependency Injection with Annotations
package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String[] data;
	private Random myRandom = new Random();
	
	/** Practice Activity #6 - Bean Scopes with Annotations*/
	@PostConstruct
	public void initFileFortuneService() {
		System.out.println(">> FileFortuneService: inside of initFileFortuneService()");
		data = loadFile();
	}
	
	public String[] loadFile() {
		String filename = System.getProperty("user.dir") + "\\src\\fortune.txt";
		FileReader fileReader;
		try {
			fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
	        List<String> lines = new ArrayList<String>();
	        String line = null;
	        while ((line = bufferedReader.readLine()) != null) {
	            lines.add(line);
	        }
	        bufferedReader.close();
	        return lines.toArray(new String[lines.size()]);
	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return null;  
		 
	}
	
	
	@Override
	public String getFortune() {
		//pick a random string from the array
		
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
