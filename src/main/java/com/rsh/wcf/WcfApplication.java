package com.rsh.wcf;

import com.google.gson.JsonParseException;
import com.rsh.wcf.services.FeatureList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class WcfApplication {

	public static void main(String[] args) {
		SpringApplication.run(WcfApplication.class, args);
	}

	@GetMapping( "/hello" )
	String sayHello( @RequestParam(value = "myName", defaultValue = "World") String name){
		return String.format( "Hello %s", name);
	}

	@GetMapping( "/feature" )
	String getFeatureList(){
		return FeatureList.getFeatures();
	}

	@PostMapping("/featureUpdate")
	String updateFeatures( @RequestBody(required = true) String body ){
		try {
			FeatureList.updateFeatures(body);
			return FeatureList.getFeatures();
		} catch(JsonParseException e){
			StringBuilder sb = new StringBuilder();
			sb.append("{\"error\":\"");
			sb.append(e.getMessage());
			sb.append("\"}");
			return sb.toString();
		}
	}
}
