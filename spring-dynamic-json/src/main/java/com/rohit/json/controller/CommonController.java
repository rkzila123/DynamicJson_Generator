package com.rohit.json.controller;


import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.rohit.json.pojo.Address;
import com.rohit.json.pojo.Student;

@RestController
public class CommonController {
	
	@GetMapping("/generatePOJO")
	public void getJsonData() {
		
		System.out.println("Entering getJsonData::");

        Student student = sampleStudentObject();
        try {
        	
        	JsonFactory factory = new JsonFactory();
            StringWriter jsonObjectWriter = new StringWriter();
            JsonGenerator jsonGenerator = factory.createGenerator(jsonObjectWriter);
           // JsonGenerator jsonGenerator = new JsonFactory().createGenerator(new FileOutputStream("student_data.txt"));
            
            // for pretty formatted printing
            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            // start root from here
            jsonGenerator.writeStartObject();
 
            jsonGenerator.writeNumberField("rollNumber", student.getRollNumber());
            jsonGenerator.writeStringField("firstName", student.getFirstName());
            jsonGenerator.writeStringField("lastName", student.getLastName());
            jsonGenerator.writeBooleanField("permanent", student.isPermanent());
 
            jsonGenerator.writeObjectFieldStart("address"); // object writing
            jsonGenerator.writeStringField("addressLine", student.getAddress().getAddressLine());
            jsonGenerator.writeStringField("city", student.getAddress().getCity());
            jsonGenerator.writeNumberField("zipCode", student.getAddress().getZipCode());
           // jsonGenerator.writeStringField("state", student.getAddress().getState());
            jsonGenerator.writeEndObject(); // address object completed
 
            jsonGenerator.writeArrayFieldStart("phoneNumbers");
            for (long num : student.getPhoneNumbers())
                jsonGenerator.writeNumber(num);
            jsonGenerator.writeEndArray();
 
             // start array writing for cities
            jsonGenerator.writeArrayFieldStart("cities");
            for (String city : student.getCities())
                jsonGenerator.writeString(city);
            // closing cities array
            jsonGenerator.writeEndArray(); 
 
            jsonGenerator.writeObjectFieldStart("properties");
            Set<String> keySet = student.getProperties().keySet();
            for (String key : keySet) {
                String value = student.getProperties().get(key);
                jsonGenerator.writeStringField(key, value);
            }
            // End of  properties writing
            jsonGenerator.writeEndObject();
            //End root object writing
            jsonGenerator.writeEndObject(); 
 
            jsonGenerator.flush();
            jsonGenerator.close();
            
            System.out.println(jsonObjectWriter.toString());
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
 
        System.out.println("Exiting getJsonData::");
	}

	private Student sampleStudentObject() {
    	 
        Student student = new Student();
        student.setRollNumber(11);
        student.setFirstName("Rohit");
        student.setLastName("Kumar");
        student.setPhoneNumbers(new long[] { 2233445566L, 3344556677L });
 
        Address add = new Address();
        add.setAddressLine("New Town");
        add.setCity("Kolkata");
        add.setState("West Bengal");
        add.setZipCode(700156);
        student.setAddress(add);
 
        List<String> cities = new ArrayList<>();
        cities.add("Dallas");
        cities.add("San Antonio");
        cities.add("Irving");
        student.setCities(cities);
 
        Map<String, String> props = new HashMap<>();
        props.put("age", "32 years");
        props.put("interst", "Music");
        props.put("play", "Badminton");
 
        student.setProperties(props);
 
        return student;
    }

}
